package ru.sfedu.api;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

import ru.sfedu.model.*;

public class DataProviderCsv implements IDataProvider {
    
    StatefulBeanToCsv<Object> beanToCsv;
    
    @Override
    public void initDataProviter() throws IOException{
        
    }
    
    @Override
    public <T> void saveRecord(Object obj) {
        
        try (Writer writer  = new FileWriter(((T) obj).getClass().getName() + ".csv", true)){
            StatefulBeanToCsv<T> beanToCsv = new StatefulBeanToCsvBuilder<T>(writer).build();
            beanToCsv.write((T) obj);
            
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException ex) {
            Logger.getLogger(DataProviderCsv.class.getName()).log(Level.WARNING, null, ex);
        } 
    
    }

    @Override
    public void deleteRecordById(int id) {
        
    }

    @Override
    public Object getRecordByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object[] getAllRecord() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
