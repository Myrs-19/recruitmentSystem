/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import java.io.IOException;

/**
 *
 * @author mike
 */
public interface IDataProvider {
    
    void initDataProviter() throws IOException;
    
    <T> void saveRecord(Object obj) throws IOException ;
    
    void deleteRecordById(int id);
    
    Object getRecordByID();
    
    Object[] getAllRecord();
}
