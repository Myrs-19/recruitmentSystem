package ru.sfedu.lab2.model;

import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.sfedu.lab2.api.HibernateDataProvider;

public class TestEntityTest {
    
    private static final Logger log = LogManager.getLogger(TestEntityTest.class.getName());
    
    /**
     * Method checks mapping TestEntity entity to configured database
     */
    @Test
    public void testMapInstance(){
        log.debug("testMapInstance [1]: fulling instance");
        
        TestEntity te = new TestEntity();
        te.setName("test 1");
        te.setDescription("test 1 description");
        te.setDateCreated(new Date());
        te.setCheck(false);
    
        log.debug("testMapInstance [2]: instance has fulled");
        
        try{
            
            log.debug("testMapInstance [3]: getting session");
            
            Session session = HibernateDataProvider.getSession();
        
            log.debug("testMapInstance [4]: saving instance");
            
            session.save(te);
        
            log.debug("testMapInstance [5]: close session");
            
            session.close();
        } catch(Exception ex){
            log.error("testMapInstance [6]: error = {}", ex.getMessage());
            fail(ex.getMessage());
        }
    }
}
