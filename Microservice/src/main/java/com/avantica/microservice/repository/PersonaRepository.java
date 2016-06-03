package com.avantica.microservice.repository;

import com.avantica.microservice.model.Persona;

import java.math.BigInteger;

/**
 * Created by max.macalupu on 23/05/2016.
 */
//public interface PersonaRepository extends Repository<Persona, BigInteger> {
public interface PersonaRepository {

    void guardarPersona(Persona persona );

    Persona obtenerPersona(BigInteger ID);
}
