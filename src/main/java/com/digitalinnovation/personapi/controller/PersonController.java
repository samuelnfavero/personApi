package com.digitalinnovation.personapi.controller;

import com.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.exception.PersonNotFoundException;
import com.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/personapi")
public class PersonController {

    PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO post(@RequestBody @Valid PersonDTO personDTO){
        return personService.postPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAllPeople();
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO delete(@PathVariable Long id) throws PersonNotFoundException {
        return personService.deletePerson(id);
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findPersonById(id);
    }

}
