package com.avantica.microservice.service;

import com.avantica.microservice.model.Persona;

import java.math.BigInteger;

/**
 * Created by max.macalupu on 19/05/2016.
 */
public interface PersonaService {

    void guardarPersona(Persona p);

    void modificarPersona(Persona p);

    Persona buscarPersonaPorID(BigInteger id);

    void eliminarPersona(Long id);
}
