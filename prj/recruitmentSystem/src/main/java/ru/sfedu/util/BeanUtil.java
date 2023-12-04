package ru.sfedu.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

import ru.sfedu.model.*;


public class BeanUtil<T> {
    private static final Logger log = LogManager.getLogger(BeanUtil.class.getName());
    
    //reflection
    public <T> String getIdInstance(T obj) throws NullPointerException{
        log.debug("getIdInstance [1]: getting id instance, obj = {}", obj);
        
        try{
            Method method = obj.getClass().getMethod(Constants.NAME_METHOD_GETTING_ID);
            return (String) method.invoke(obj);
        } catch (NoSuchMethodException ex){
            log.error("getIdInstance [2]: error = {}", ex.getMessage());
        } catch(IllegalAccessException | InvocationTargetException ex){
            log.error("getIdInstance [3]: error = {}", ex.getMessage());
        }
        
        throw new NullPointerException("failed a way to invoke getting method");
    }
    
    //reflection
    public <T> void setIdInstance(T obj, String id){
        log.debug("setIdInstance [1]: setting id instance, obj = {}, id = {}", obj, id);
        
        try{
            Method method = obj.getClass().getMethod(Constants.NAME_METHOD_SETTING_ID, String.class);
            method.invoke(obj, id);
        } catch (NoSuchMethodException ex){
            log.error("setIdInstance [2]: error = {}", ex.getMessage());
        } catch(IllegalAccessException | InvocationTargetException ex){
            log.error("setIdInstance [3]: error = {}", ex.getMessage());
        }
        
    }

}
