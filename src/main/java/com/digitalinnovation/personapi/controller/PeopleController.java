package com.digitalinnovation.personapi.controller;

import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.entity.PhoneNumber;
import com.digitalinnovation.personapi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personmanagement")
public class PeopleController {

    @Autowired
    private Repository repository;

    //Não utilizando PhoneType, birthDate. Modificado o parametro phoneNumberda classe Person
    @GetMapping("/{firstName}-{lastName}-{cpf}-{phoneNumber}")
    public void post(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName, @PathVariable("cpf") String cpf, @PathVariable("phoneNumber") String number){

        PhoneNumber phoneNumber =  PhoneNumber.builder().number(number).build();
        Person person = Person.builder().firstName(firstName).lastName(lastName).cpf(cpf).phoneNumber(phoneNumber).build();

            repository.save(person);

    }
}
