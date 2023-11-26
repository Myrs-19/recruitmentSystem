/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ru.sfedu.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;
import ru.sfedu.Constants;
/**
 *
 * @author mike
 */
public class MongoProvider {
    private static final Logger log = LogManager.getLogger(MongoProvider.class);
    
    public static<T> void save(T obj){
        try{
        MongoCollection<Document> collection = getCollection(obj.getClass());
        
        ObjectMapper objectMapper = new ObjectMapper();
        Document document = new Document()
              .append("item" , objectMapper.writeValueAsString(obj));
        
        collection.insertOne(document);
        log.info("saved obj = {}", obj);
        
        for(Document doc : collection.find()){
            System.out.println(doc);
        }
        } catch(Exception e){
            log.error(e.getMessage());
        }
        
        
    }
    
    private static MongoCollection<Document> getCollection(Class clazz){
        MongoClient mongoClient = MongoClients.create(Constants.MONGO_URI);
        
        MongoDatabase db = mongoClient.getDatabase(
                getConfigurationEntry(Constants.MONGO_DB_NAME)
        );
        
        MongoCollection collection = db.getCollection(clazz.getSimpleName().toLowerCase());
        
        return collection;
    }
}
