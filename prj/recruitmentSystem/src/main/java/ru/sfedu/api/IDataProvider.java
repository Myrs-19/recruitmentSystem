package ru.sfedu.api;

import java.util.List;

/**
 *
 * @author mike
 */
public interface IDataProvider<T> {
    
    <T> void saveRecord(Object obj);
    
    <T> Object getRecordByID(String id, Class<T> clazz);
    
    <T> List<T> getAllRecord(Class<T> clazz);
    
    <T> void updateRecordById(String id, Object obj);
    
    void deleteRecordById(String id, Class<T> clazz);
}
