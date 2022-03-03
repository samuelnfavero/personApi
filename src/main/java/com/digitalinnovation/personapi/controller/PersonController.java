package com.digitalinnovation.personapi.controller;

import com.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.exception.DeleteException;
import com.digitalinnovation.personapi.exception.FindByIdException;
import com.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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

    @GetMapping("/listAll")
    public List<PersonDTO> listAll(){
        return personService.listAllPeople();
    }

    @DeleteMapping("/delete")
    public MessageResponseDTO delete(Long id) throws DeleteException {
        return personService.deletePerson(id);
    }

    @GetMapping("/findbyid")
    public PersonDTO findById(Long id) throws FindByIdException {
        return personService.findPersonById(id);
    }
}
