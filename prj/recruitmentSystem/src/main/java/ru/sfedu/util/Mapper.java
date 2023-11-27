/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Constants;

public class Mapper<T> {
    private static final Logger log = LogManager.getLogger(Mapper.class.getName());
    
    
    public <T> T getInstance(Class<T> clazz, String[] values) {
        log.debug("getInstance [1]: getting instance, clazz = {}, values = {}", clazz, values);
        
        try{
            Constructor<T> constructor = clazz.getConstructor();
            T instance = constructor.newInstance();

            Field[] fields = clazz.getDeclaredFields();
            String fieldName;
            String value;

            for(int i = 0; i < fields.length; i++){
                fieldName = fields[i].getName();
                value = values[i];
                Method method = clazz.getMethod(Constants.PREFIX_SETTER_METHOD + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), String.class);
                method.invoke(instance, value);
            }
            
            return instance;
        } catch(NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex){
            log.error("getInstance [2]: error = {}", ex.getMessage());
        }
        
        return null;
    }
}
