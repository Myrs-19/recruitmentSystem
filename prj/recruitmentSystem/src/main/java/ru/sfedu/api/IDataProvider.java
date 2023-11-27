package ru.sfedu.api;

import java.util.List;

/**
 *
 * @author mike
 */
public interface IDataProvider<T> {
    
    void initDataProviter();
    
    <T> void saveRecord(Object obj);
    
    <T> Object getRecordByID(String id, Class<T> clazz);
    
    <T> List<T> getAllRecord(Class<T> clazz);
    
    <T> void changeRecordById(String id);
    
    void deleteRecordById(String id);
}
