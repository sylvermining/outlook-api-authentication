package com.avantica.microservice.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by max.macalupu on 20/05/2016.
 */
@Configuration
//@ComponentScan(basePackageClasses = ApplicationConfig.class)
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoConfiguration {

//    @Autowired
//    private List<Converter<?, ?>> converters;

    @Override
    protected String getDatabaseName() {
        return "microservicio";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo("127.0.0.1",27017);
//        Mongo mongo = new MongoClient("127.0.0.1:27017");
//        mongo.setWriteConcern(WriteConcern.SAFE);
//        return mongo;
    }

    @Override
    protected String getMappingBasePackage() {
        return "com.avantica.microservice";
    }

    @Override
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo() , "microservicio");
    }

//    @Override
//    public CustomConversions customConversions() {
//        return new CustomConversions(converters);
//    }

}