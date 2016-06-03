package com.avantica.microservice.boot;

import com.avantica.microservice.model.Persona;
import com.avantica.microservice.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
	PersonaService personaService;

	@RequestMapping("/guardarPersona")
    public String index() {

        Persona p = new Persona();
        p.setDocumento("46257001");
        p.setNombre("Max Leo Junior");
		personaService.guardarPersona(p);
       return "Hello world from spring....!";
    }
}