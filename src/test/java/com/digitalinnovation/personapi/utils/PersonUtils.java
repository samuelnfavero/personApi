package com.digitalinnovation.personapi.utils;

import com.digitalinnovation.personapi.dto.request.PersonDTO;
import com.digitalinnovation.personapi.dto.request.PhoneDTO;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.entity.PhoneNumber;

import java.time.LocalDate;
import java.util.Collections;

public class PersonUtils {
    private static final String FIRST_NAME = "BBBBBBB";
    private static final String LAST_NAME = "AAAAAAA";
    private static final String CPF = "12345678912";
    private static final LocalDate BIRTH_DATE = LocalDate.of(1996,12,11);

    public static Person createFakePersonEntity(){
        return Person.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneEntity()))
                .build();
    }

    public static PersonDTO createFakePersonDTO(){
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .birthDate("11-12-1996")
                .phones(Collections.singletonList(PhoneUtils.createFakePhoneEntity()))
                .build();
    }
}
