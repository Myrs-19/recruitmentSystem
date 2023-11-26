package ru.sfedu.util;

import ru.sfedu.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.api.MongoProvider;


public class ConfigurationUtilProperties extends ConfigurationUtil{    

    private static final Logger log = LogManager.getLogger(MongoProvider.class);
    private static final Properties configuration = new Properties();
    
    public ConfigurationUtilProperties() {

    }

    private static Properties getConfiguration() throws IOException {
        if (configuration.isEmpty()) {
            loadConfiguration();
        }
        return configuration;
    }

    private static void loadConfiguration() throws IOException {
        InputStream in;
        
        String configPath = ConfigurationUtil.getConfigPath();
        
        if (configPath == null || configPath.isEmpty()) {
            in = ConfigurationUtil.class.getClassLoader().getResourceAsStream(Constants.DEFAULT_CONFIG_PATH_PROP);
        } else {
            File file = new File(configPath);
            in = new FileInputStream(file);
        }

        try {
            configuration.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally {
            in.close();
        }
    }
    
    public static String getConfigurationEntry(String key) {
        try {
            return getConfiguration().getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static List<String> getConfigurationEntryList(String key){
        try {
            String value = getConfiguration().getProperty(key);
            List<String> list = Arrays.asList(value.split("\\s*,\\s*")); 
            return list;
        } catch (IOException e) {
            log.error(e);
        } catch(NullPointerException e){
            log.error(e);
        }
        
        return null;
    }
    
    public static Map<Integer, String> getConfigurationEntryMap(String key){
        try {
            String value = getConfiguration().getProperty(key);
            List<String> list = getConfigurationEntryList(key);
            
            Map<Integer, String> result = new HashMap();
            int k;
            for(String el : list){
                k = Integer.parseInt(getConfigurationEntry(key + "." + el));
                result.put(k, el);
            }
            
            return result;
                    
        } catch (IOException e) {
            log.error(e);
        } catch(NullPointerException e){
            log.error(e);
        }
        
        return null;
    }

}