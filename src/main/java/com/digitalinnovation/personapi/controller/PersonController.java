package com.digitalinnovation.personapi.controller;

import com.digitalinnovation.personapi.dto.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/post")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO post(@RequestBody @Valid PersonDTO personDTO){
        return personService.postPerson(personDTO);
    }
}
