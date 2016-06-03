package com.avantica.microservice.service;

import com.avantica.microservice.model.Persona;
import com.avantica.microservice.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * Created by max.macalupu on 19/05/2016.
 */
@Service("personaServiceImpl")
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Override
    public void guardarPersona(Persona p) {
        personaRepository.guardarPersona(p);
    }

    @Override
    public void modificarPersona(Persona p) {

    }

    @Override
    public Persona buscarPersonaPorID(BigInteger id) {
        return personaRepository.obtenerPersona(id);
    }

    @Override
    public void eliminarPersona(Long id) {

    }
}