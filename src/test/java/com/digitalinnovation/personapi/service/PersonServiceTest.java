package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.repository.Repository;
import com.digitalinnovation.personapi.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    Repository repository;

    @InjectMocks
    PersonService personService;

    @Test
    void TestGivenPersonDTOThenReturnSavedMessage() {

        PersonDTO personDTO = PersonUtils.createFakePersonDTO();
        Person expectedSavedPerson = PersonUtils.createFakePersonEntity();

        when(repository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO messageResponseDTO = personService.postPerson(personDTO);
        MessageResponseDTO expectedMessage = MessageResponseDTO.builder()
                .message( personDTO.getFirstName() + " " + personDTO.getLastName() + " salvo com sucesso.")
                .build();
        assertEquals(expectedMessage, messageResponseDTO);

    }
}
