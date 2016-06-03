package com.avantica.microservice.repository;

import com.avantica.microservice.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * Created by max.macalupu on 23/05/2016.
 */

//@Repository
//@Profile("microservicio")
@Service("personaRepository")
//@Component
public class PersonaRepositoryImpl implements PersonaRepository{

//    private final MongoOperations mongoOperations ;
//
//    @Autowired
//    public PersonaRepositoryImpl(MongoOperations mongoOperations) {
//        this.mongoOperations = mongoOperations;
//    }

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void guardarPersona(Persona persona) {
        mongoTemplate.save(persona);
    }

    @Override
    public Persona obtenerPersona(BigInteger ID) {
        Query query = query(where("id").is(ID));
        return mongoTemplate.findOne(query , Persona.class);
    }
}