package ru.sfedu.util;

import ru.sfedu.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.yaml.snakeyaml.Yaml;


public class ConfigurationUtilYaml extends ConfigurationUtil{
    
    private static Map<String, Object> configuration; 
    public ConfigurationUtilYaml() {
        
    }

    private static Map<String, Object> getConfiguration() throws IOException {
        if(configuration == null || configuration.isEmpty()){
            loadConfiguration();
        }
        return configuration;
    }

    private static void loadConfiguration() throws IOException {
        
        InputStream in;
        
        String configPath = ConfigurationUtil.getConfigPath();
        
        if (configPath == null || configPath.isEmpty()) {
            in = ConfigurationUtil.class.getClassLoader().getResourceAsStream(Constants.DEFAULT_CONFIG_PATH_YAML);
        } else {
            File file = new File(configPath);
            in = new FileInputStream(file); //IOException
        }

        Yaml yaml = new Yaml();
        ConfigurationUtilYaml.configuration = yaml.load(in);
        
    }
    
    public static String getConfigurationEntry(String key) {
        try{
            if(getConfiguration().containsKey(key)){
                return configuration.get(key).toString();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
        return "";
    }
    
    public static List<String> getConfigurationEntryList(String key) {
        try{
            if(getConfiguration().containsKey(key)){
                String value = getConfiguration().get(key).toString();
                List<String> list = Arrays.asList(value.split("\\s*,\\s*"));
                return list;
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        
        return null;
    }

}