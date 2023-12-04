package ru.sfedu.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import ru.sfedu.model.*;


public class BeanUtil<T> {
    private static final Logger log = LogManager.getLogger(BeanUtil.class.getName());
    
    
    public <T> T getInstance(Class<T> clazz, String[] values) {
        log.debug("getInstance [1]: getting instance, clazz = {}, values = {}", clazz, values);
        
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
    
    private void fillPerson(Person obj, String[] values){
        obj.setId(values[0]);
        obj.setName(values[1]);
        obj.setSurname(values[2]);
        obj.setMiddleName(values[3]);
        obj.setAge(values[4]);
        obj.setBirthday(values[5]);
    }
}
