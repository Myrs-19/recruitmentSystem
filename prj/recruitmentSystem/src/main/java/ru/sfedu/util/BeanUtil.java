/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

public class BeanUtil<T> {
    private static final Logger log = LogManager.getLogger(BeanUtil.class.getName());
    
    
    public <T> T getInstance(Class<T> clazz, String[] values) {
        log.debug("getInstance [1]: getting instance, clazz = {}, values = {}", clazz, values);
        
        //returning instance of clazz
        //code
        
        return null;
    }
    
    public <T> String getIdInstance(T obj) throws NullPointerException{
        log.debug("getIdInstance [1]: getting id instance, obj = {}", obj);
        
        //returning id of obj;
        //code
        
        return null;
    }
    
    public <T> void setIdInstance(T obj, String id){
        log.debug("setIdInstance [1]: setting id instance, obj = {}, id = {}", obj, id);
        
        //setting id of obj;
        //code
        
    }
}
