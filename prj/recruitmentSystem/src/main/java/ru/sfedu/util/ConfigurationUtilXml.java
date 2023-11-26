package ru.sfedu.util;

import ru.sfedu.Constants;

import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ConfigurationUtilXml  extends ConfigurationUtil{

    
    private static DocumentBuilder builder;
    private static Document configuration;    
    
    
    public ConfigurationUtilXml() throws SAXException, IOException, ParserConfigurationException {
        
    }

    private static Document getConfiguration() throws IOException, ParserConfigurationException {
        if (builder == null) {
            createBuilder();
        }
        if(configuration == null){
            loadConfiguration();
        }
        return configuration;
    }

    private static void createBuilder() throws ParserConfigurationException{
        
        builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        
    }
    
    private static void loadConfiguration() throws IOException {
        InputStream in;
        
        String configPath = ConfigurationUtil.getConfigPath();
        
        if (configPath == null || configPath.isEmpty()) {
            in = ConfigurationUtil.class.getClassLoader().getResourceAsStream(Constants.DEFAULT_CONFIG_PATH_XML);
        } else {
            File file = new File(configPath);
            in = new FileInputStream(file);
        }

        try{
            configuration = builder.parse(in);
            configuration.normalizeDocument();
        } catch(SAXException e){
            e.printStackTrace();
        }
    }
    
    public static String getConfigurationEntry(String key) {
        try {
//            NodeList nodeList = getConfiguration().getElementsByTagName(key);
//            return nodeList.item(0).getTextContent();
            Node node = getConfiguration().getElementsByTagName(key).item(0);
            return node.getTextContent();
        } catch (IOException | NullPointerException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getConfigurationEntryList(String key) {
        try {
            
            NodeList nodes = getConfiguration().getDocumentElement().getElementsByTagName(key);
            List<String> list = new ArrayList();
            for(int i = 0; i < nodes.getLength(); i++){
                list.add(nodes.item(i).getTextContent());
            }
            return list;
            
        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
}