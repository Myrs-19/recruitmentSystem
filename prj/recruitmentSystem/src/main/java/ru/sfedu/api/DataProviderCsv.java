package ru.sfedu.api;

import com.opencsv.CSVWriter;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Level;

import ru.sfedu.Constants;
import ru.sfedu.exception.NotFoundObjectException;
import ru.sfedu.model.*;
import ru.sfedu.util.FileUtil;
import ru.sfedu.util.Mapper;

public class DataProviderCsv implements IDataProvider{
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    
    public DataProviderCsv(){
        
        try{
            FileUtil.createFolderIfNotExists(Constants.CSV_PATH_FOLDER);
        } catch(IOException ex){
            log.error("DataProviderCsv [1]: error = {} (Ошибка создании директории)", ex.getMessage());
        }
    }
    
    @Override
    public <T> void saveRecord(T obj) {
        log.debug("saveRecord [1]: obj = {}",  ((T) obj));
        
        try (FileWriter writer  = new FileWriter(getPath(obj.getClass()), true)){
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
       T obj = null;
       Mapper<T> mapper = new Mapper<T>();
       try{
            List<T> records = getAllRecord(clazz)
               .stream()
               .filter(it -> mapper.getIdInstance(it).equals(id))
               .toList();
            obj = records.get(0);
        } catch(NullPointerException ex){
            log.error("getRecordByID [2]: нет такого объекта, error = {}", ex.getMessage());
        }
       
       if(obj == null){
           throw new NullPointerException();
       }
        return obj;
    }

    @Override
    public <T> List<T> getAllRecord(Class<T> clazz) {
        log.debug("getAllRecord [1]: getting all record from = {}", getPath(clazz));
        
        List<T> result = new ArrayList();
        try(FileReader fileReader = new FileReader(getPath(clazz))){
            CSVReader csvReader = new CSVReader(fileReader);
            
            Mapper<T> mapper = new Mapper<T>();
            
            result = csvReader.readAll()
                    .stream()
                    .map(it -> mapper.getInstance(clazz, it))
                    .toList();
                    
        } catch(IOException | CsvException ex){
            log.error("getAllRecord [2]: error = {}",  ex.getMessage());
        } catch(NullPointerException ex){
            log.error("getAllRecord [3]: нет такого объекта, error = {}",  ex.getMessage());
        }

        return result;
    }
    
    @Override
    public <T> void updateRecordById(String id, T obj){
        log.debug("updateRecordById [1]:  изменение записи, id = {}", id);
         
        boolean isExist = false;
        List<? extends Object> objectsT = getAllRecord(obj.getClass());
         
        try(FileWriter writer = new FileWriter(getPath(obj.getClass()), false);){   
            Mapper<T> mapper = new Mapper<T>();
            
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            for(Object objectT : objectsT){
                if(id.equals(mapper.getIdInstance(objectT))){
                    beanToCsv.write((T)obj);
                    isExist = true;
                } else{
                    beanToCsv.write((T)objectT);
                }
            }
            
            if(!isExist){
                throw new NotFoundObjectException("Невозможно изменить несуществующую запись");
            }
            
            log.debug("updateRecordById [2]: object updated succesfully");
        } catch (NullPointerException ex) {
            log.error("updateRecordById [3]: error = {}",  ex.getMessage());
        } catch(NotFoundObjectException ex){
            log.error("updateRecordById [4]: error = {}",  "Невозможно изменить несуществующую запись");
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
            Mapper<T> mapper = new Mapper<T>();
            
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            
            for(Object objectT : objectsT){
                if(!id.equals(mapper.getIdInstance(objectT))){
                    beanToCsv.write((T) objectT);
                }
            }
            
            log.debug("updateRecordById [2]: object deleted succesfully");
        } catch (NullPointerException ex) {
            log.error("updateRecordById [3]: error = {}",  ex.getMessage());
        } catch(IOException ex){
            log.error("updateRecordById [5]: error = {}",  "Ошибка чтения");
        } catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("updateRecordById [6]: error = {}",  "Ошибка записи");
        }
    }
    
    public <T> String getId(Class<T> clazz){
        String id;
        List<? extends Object> objects = getAllRecord(clazz);
        Mapper<T> mapper = new Mapper<T>();
        
        id = mapper.getIdInstance(objects.get(0));
        String idObj;
        for(Object object : objects){
            idObj = mapper.getIdInstance(object);
            if(Integer.parseInt(id) <= Integer.parseInt(idObj)){
                id = idObj;
            }
        }
        id =Integer.parseInt(id) + 1 + "";
        
        return id;
    }
    
    private String getPath(Class clazz){
        return Constants.CSV_PATH_FOLDER + clazz.getName() + Constants.CSV_FILE_TYPE;
    }
}
