package com.avantica.microservice;

import com.avantica.microservice.config.ApplicationConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by max.macalupu on 20/05/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class MongoAplicationConfigTest {

//    @Test
    public void bootstrapAppFromJavaConfig() {

//        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        assertThat(context, is(notNullValue()));
    }
}