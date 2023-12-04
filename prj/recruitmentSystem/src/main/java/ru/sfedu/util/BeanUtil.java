package ru.sfedu.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
    
    //reflection
    public <T> String getIdInstance(T obj) throws NullPointerException{
        log.debug("getIdInstance [1]: getting id instance, obj = {}", obj);
        
        try{
            Method method = obj.getClass().getMethod(Constants.NAME_METHOD_GETTING_ID);
            return (String) method.invoke(obj);
        } catch (NoSuchMethodException ex){
            log.error("getIdInstance [2]: error = {}", ex.getMessage());
        } catch(IllegalAccessException | InvocationTargetException ex){
            log.error("getIdInstance [2]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("failed a way to invoke getting method");
    }
    
    //reflection
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
