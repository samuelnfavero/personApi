package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.mapper.PersonMapper;
import com.digitalinnovation.personapi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private Repository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(Repository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO postPerson(PersonDTO personDTO){

        Person person = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO.builder()
                .message(savedPerson.getFirstName() + " " + savedPerson.getLastName() + " adicionado com sucesso. ")
                .build();
    }
}
