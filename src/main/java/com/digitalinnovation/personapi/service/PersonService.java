package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.MessageResponseDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.repository.Repository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    Repository personRepository;

    public PersonService(Repository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO postPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO.builder()
                .message(savedPerson.getFirstName() + " " + savedPerson.getLastName() + " adicionado com sucesso. ")
                .build();
    }
}
