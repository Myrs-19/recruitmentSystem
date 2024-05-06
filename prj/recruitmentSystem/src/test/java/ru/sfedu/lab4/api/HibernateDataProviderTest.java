package ru.sfedu.lab4.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import ru.sfedu.lab4.model.*;
import ru.sfedu.lab4.api.HibernateDataProvider;

import static org.junit.jupiter.api.Assertions.*;

class HibernateDataProviderTest {
    private static final Logger log = LogManager.getLogger(HibernateDataProvider.class.getName());

    private static HibernateDataProvider dp = new HibernateDataProvider();

    /**
     * Тест сохранения Client
     *
     * тип: позитивный
     */
    @Test
    void saveRecord() {
        log.debug("saveRecord [1]: create client");
        Client client = new Client();

        //person fields
        client.setName("Mike");
        client.setSurname("Seleznev");
        client.setMiddleName("Mikhal");
        client.setAge(20);
        client.setBirthday("12-06-2003");
        client.setPhone("89996940159");
        client.setEmail("mseleznev@sfedu.ru");
        client.setTypePerson(TypePerson.ClientType);

        //client fields
        client.setPassword("pipi");
        client.setAddress("Zorge 28/2");

        try{
            log.debug("testSaveClient [2]: save client, client = {}", client);

            dp.saveRecord(client);

            log.debug("testSaveClient [3]: client has been saved");
        } catch(Exception ex){
            log.error("testSaveClient [4]: error = {}", ex.getMessage());

            fail(ex.getMessage());
        }
    }

    @Test
    void deleteRecord() {
    }

    @Test
    void updateRecord() {
    }

    @Test
    void getRecord() {
    }
}