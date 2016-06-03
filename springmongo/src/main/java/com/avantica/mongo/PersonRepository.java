package com.avantica.mongo;

import com.avantica.model.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by max.macalupu on 23/05/2016.
 */
public interface PersonRepository extends MongoRepository<Persona, String> {
}
