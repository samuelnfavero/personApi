package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.exception.PersonNotFoundException;
import com.digitalinnovation.personapi.mapper.PersonMapper;
import com.digitalinnovation.personapi.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
        return getMessage(savedPerson, " salvo com sucesso.");
    }

    public List<PersonDTO> listAllPeople() {
        List<Person> person = personRepository.findAll();
        return person.stream()
                .map(p -> personMapper.toDTO(p))
                .collect(Collectors.toList());
    }

    public MessageResponseDTO deletePerson(Long id) throws PersonNotFoundException {
        getPerson(id);
        personRepository.deleteById(id);
        return MessageResponseDTO.builder().message("Deletado com sucesso!").build();
    }

    public PersonDTO findPersonById(Long id) throws PersonNotFoundException {
        Person person = getPerson(id);
        return personMapper.toDTO(person);
    }

    public MessageResponseDTO updatePerson(PersonDTO personDTO) throws PersonNotFoundException {
        Person person = personMapper.toModel(personDTO);
        getPerson(person.getId());
        Person savedPerson = personRepository.save(person);
        return getMessage(savedPerson, " atualizado com sucesso.");
    }

    private Person getPerson(Long id) throws PersonNotFoundException {
        Person person;
        try {
            person = personRepository.findById(id).get();
        }catch(Exception e){
            throw new PersonNotFoundException(id);
        }
        return person;
    }

    private MessageResponseDTO getMessage(Person savedPerson, String message) {
        return MessageResponseDTO.builder()
                .message(savedPerson.getFirstName() + " " + savedPerson.getLastName() + message)
                .build();
    }

}
