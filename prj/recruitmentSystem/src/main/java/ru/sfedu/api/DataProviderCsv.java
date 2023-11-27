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

import ru.sfedu.model.*;
import ru.sfedu.Constants;
import ru.sfedu.util.Mapper;

public class DataProviderCsv<T> implements IDataProvider<T> {
    private static final Logger log = LogManager.getLogger(DataProviderCsv.class.getName());
    
    @Override
    public void initDataProviter(){
        
    }
    
    @Override
    public <T> void saveRecord(Object obj) {
        log.debug("saveRecord [1]: obj = {}",  ((T) obj));
        try (FileWriter writer  = new FileWriter(((T) obj).getClass().getName() + Constants.CSV_FILE_TYPE, true)){
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer)
                .withSeparator(Constants.CSV_DEFAULT_SEPARATOR)
                .build();
            beanToCsv.write((T) obj);
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            log.error("saveRecord [2]: error = {}",  ex.getMessage());
        } 
        
        log.debug("saveRecord [3]: object saved succesfully");
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
        return obj;
    }

    @Override
    public <T> List<T> getAllRecord(Class<T> clazz) {
        String pathToCsv = clazz.getName() + Constants.CSV_FILE_TYPE;
        
        log.debug("getAllRecord [1]: getting all record from = {}", pathToCsv);
        
        List<T> result = new ArrayList();
        try(FileReader fileReader = new FileReader(pathToCsv)){
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
    public <T> void changeRecordById(String id){
        //    
    }
    
    
    @Override
    public void deleteRecordById(String id) {
        
    }
    
    private <T> int getId(Object obj){
        int id;
        //code
        return 0;
    }
}
