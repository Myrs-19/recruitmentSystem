/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author mike
 */
public interface IDataProvider<T> {
    
    void initDataProviter();
    
    <T> void saveRecord(Object obj);
    
    <T> Object getRecordByID(int id, Class<T> clazz);
    
    <T> List<T> getAllRecord(Class<T> clazz);
    
    <T> void changeRecordById(int id);
    
    void deleteRecordById(int id);
}
