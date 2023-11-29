package ru.sfedu.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.Document;

import static ru.sfedu.util.ConfigurationUtilProperties.getConfigurationEntry;
import ru.sfedu.Constants;

import ru.sfedu.model.CommandType;
import ru.sfedu.model.RepositoryType;
/**
 *
 * @author mike
 */
public class MongoProvider {
    private static final Logger log = LogManager.getLogger(MongoProvider.class);
    
    public static<T> void save(CommandType command, RepositoryType repositoryType, T obj){
        log.debug("save [1]: command = {}, type = {}, object = {}", command, repositoryType, obj);
        try{
            MongoCollection<Document> collection = getCollection(obj.getClass());

            ObjectMapper objectMapper = new ObjectMapper();
            Document document = new Document()
                    .append(Constants.MONGO_FIELD_TIME, new Date())
                    .append(Constants.MONGO_FIELD_COMMAND, command.toString())
                    .append(Constants.MONGO_FIELD_REPOSITORY, repositoryType.toString())
                    .append(Constants.MONGO_FIELD_OBJECT, objectMapper.writeValueAsString(obj));

            collection.insertOne(document);
            log.info("save [2]: saved successfully obj = {}", obj);
        } catch(JsonProcessingException ex){
            log.error("save [3]: error = {}", ex.getMessage());
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
