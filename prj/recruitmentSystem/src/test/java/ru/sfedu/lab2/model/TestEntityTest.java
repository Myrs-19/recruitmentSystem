package ru.sfedu.lab2.model;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.lab2.api.HibernateDataProvider;

public class TestEntityTest {
    
    private static final Logger log = LogManager.getLogger(TestEntityTest.class.getName());
    
    private static HibernateDataProvider dataProvider = new HibernateDataProvider();
    
    static Operation operation = new Operation("type", 500L);
    static TestEntity entity = new TestEntity("mike", "description", new Date(), false, operation);
    
 @Test
    void saveTestEntity() throws Exception {
        dataProvider.saveTestEntity(entity);
    }

    @Test
    void deleteTestEntity() throws Exception {
        dataProvider.deleteTestEntity(1L);
    }

    @Test
    void updateTestEntity() throws Exception {
        entity.setId(2L);
        dataProvider.updateTestEntity(entity);
    }

    @Test
    void getTestEntity() throws Exception {
        dataProvider.getTestEntity(2L);
    }
}
