package ru.sfedu.api;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import ru.sfedu.Constants;
import ru.sfedu.exception.IncorrectDataStorageException;

import ru.sfedu.model.CommandType;
import ru.sfedu.model.RepositoryType;

import ru.sfedu.util.FileUtil;
import ru.sfedu.util.BeanUtil;
import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;

public class DataProviderCsv implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    
    public DataProviderCsv(){
        
        try{
            FileUtil.createFolderIfNotExists(getConfigurationEntry(Constants.CSV_PATH_FOLDER));
        } catch(IOException ex){
            log.error("DataProviderCsv [1]: error = {}", ex.getMessage());
        }
    }
    
    @Override
    public <T> void saveRecord(T obj) {
        log.debug("saveRecord [1]: obj = {}",  ((T) obj));
        
        try (FileWriter writer  = new FileWriter(getPath(obj.getClass()), true)){
            
            BeanUtil<T> mapper = new BeanUtil<T>();
            mapper.setIdInstance(obj, getId(obj.getClass()));
            
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write(obj);
            
            log.debug("saveRecord [2]: object saved succesfully");
        } catch (IOException ex) {
            log.error("saveRecord [3]: error = {}",  ex.getMessage());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveRecord [4]: error = {}",  ex.getMessage());
        }
        
        
    }

    @Override
    public <T> Object getRecordByID(String id, Class<T> clazz) {
       log.debug("getRecordByID [1]: getting record by id, clazz = {}, id = {}", clazz, id);
       
       try(FileReader fileReader = new FileReader(getPath(clazz))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<T> beanStrategy = new ColumnPositionMappingStrategy<T>();
            beanStrategy.setType(clazz);
           
            CsvToBean<T> csvToBean = new CsvToBean<T>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            BeanUtil<T> beanUtil = new BeanUtil<T>();
            List<T> list = csvToBean.parse()
                    .stream()
                    .filter(it -> {
                        String idIt = beanUtil.getIdInstance(it);
                        return idIt.equals(id);
                    })
                    .toList();
            if(list.size() > 1){
                throw new IncorrectDataStorageException("such id more 1");
            }
            else{
                return list.get(0);
            }
            
        } catch(NullPointerException ex){
            log.error("getRecordByID [2]: error = {}", ex.getMessage());
        } catch (FileNotFoundException ex) {
            log.error("getRecordByID [3]: error = {}", ex.getMessage());
        } catch(IncorrectDataStorageException ex){
            log.error("getRecordByID [4]: error = {}", ex.getMessage());
        } catch (IOException ex) {
            log.error("getRecordByID [5]: error = {}", ex.getMessage());
        }
       
       throw new NullPointerException("error of getting record");
    }

    @Override
    public <T> List<T> getAllRecord(Class<T> clazz) {
        log.debug("getAllRecord [1]: getting all record from = {}", getPath(clazz));
        
        try(FileReader fileReader = new FileReader(getPath(clazz))){
            CSVReader csvReader = new CSVReader(fileReader);
           
            ColumnPositionMappingStrategy<T> beanStrategy = new ColumnPositionMappingStrategy<T>();
            beanStrategy.setType(clazz);
            
            CsvToBean<T> csvToBean = new CsvToBean<T>();
            
            csvToBean.setCsvReader(csvReader);
            csvToBean.setMappingStrategy(beanStrategy);
            csvToBean.setOrderedResults(true);
            
            return csvToBean.parse();
            
        } catch(NullPointerException ex){
            log.error("getAllRecord [2]: error = {}", ex.getMessage());
        } catch (FileNotFoundException ex) {
            log.error("getAllRecord [3]: error = {}", ex.getMessage());
        } catch (IOException ex) {
            log.error("getAllRecord [5]: error = {}", ex.getMessage());
        }

        throw new NullPointerException("error of getting records");
    }
    
    @Override
    public <T> void updateRecord(T obj){
        BeanUtil<T> beanUtil = new BeanUtil<T>();
        String id = beanUtil.getIdInstance(obj);
        log.debug("updateRecord [1]: obj = {}, id = {}", obj, id);
         
        boolean isExist = false;
        List<? extends Object> objectsT = getAllRecord(obj.getClass());
         
        try(FileWriter writer = new FileWriter(getPath(obj.getClass()), false);){
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            for(Object objectT : objectsT){
                if(id.equals(beanUtil.getIdInstance(objectT))){
                    beanToCsv.write((T)obj);
                    isExist = true;
                } else{
                    beanToCsv.write((T)objectT);
                }
            }
            
            if(!isExist){
                log.error("updateRecordById [2]: error = {}",  "Невозможно изменить несуществующую запись");
            }
            
            MongoProvider.save(CommandType.UPDATED, RepositoryType.CSV, obj);
            log.debug("updateRecordById [3]: object updated succesfully");
        } catch (NullPointerException ex) {
            log.error("updateRecordById [4]: error = {}",  ex.getMessage());
        } catch(IOException ex){
            log.error("updateRecordById [5]: error = {}",  "Ошибка чтения");
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("updateRecordById [6]: error = {}",  "Ошибка записи");
        }
       
    }
    
    
    @Override
    public <T> void deleteRecordById(String id, Class<T> clazz) {
        log.debug("deleteRecordById [1]:  удаление записи, id = {}, clazz = {}", id, clazz);
        
        List<? extends Object> objectsT = getAllRecord(clazz);
         
        try(FileWriter writer = new FileWriter(getPath(clazz), false);){   
            BeanUtil<T> mapper = new BeanUtil<T>();
            
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            for(Object objectT : objectsT){
                if(!id.equals(mapper.getIdInstance(objectT))){
                    beanToCsv.write((T) objectT);
                }
                else{
                    T obj;
                    obj = (T) objectT;
                    MongoProvider.save(CommandType.DELETED, RepositoryType.CSV, obj);
                
                }
            }
            
            log.debug("updateRecordById [2]: object deleted succesfully");
        } catch (NullPointerException ex) {
            log.error("updateRecordById [3]: error = {}",  ex.getMessage());
        } catch(IOException ex){
            log.error("updateRecordById [5]: error = {}",  ex.getMessage());
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("updateRecordById [6]: error = {}",  ex.getMessage());
        }
    }
    
    private <T> String getId(Class<T> clazz){
        log.debug("getId [1]: gettind id, clazz = {}", clazz);
        
        List<? extends Object> objects = getAllRecord(clazz);
        try{
            if(objects != null && objects.isEmpty()){
                return Constants.CSV_FIRST_ID;
            } 
            else{
                BeanUtil<T> mapper = new BeanUtil<T>();

                String result = mapper.getIdInstance(objects.get(0));
                String idObj;
                for(Object object : objects){
                    idObj = mapper.getIdInstance(object);
                    if(Integer.parseInt(result) <= Integer.parseInt(idObj)){
                        result = idObj;
                    }
                }

                return Integer.parseInt(result) + 1 + "";
            }
        } catch(Exception ex){
            log.error("getId [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("failed to create id");
    }
    
    private String getPath(Class clazz){
        return getConfigurationEntry(Constants.CSV_PATH_FOLDER) + clazz.getName() + Constants.CSV_FILE_TYPE;
    }
    
}
