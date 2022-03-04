package com.digitalinnovation.personapi.utils;

import com.digitalinnovation.personapi.dto.request.PhoneDTO;
import com.digitalinnovation.personapi.entity.PhoneNumber;
import com.digitalinnovation.personapi.enums.PhoneType;

public class PhoneUtils {
    private static final String PHONE_NUMBER = "9999999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final Long PHONE_ID = 1L;

    public static PhoneNumber createFakePhoneEntity(){
        return PhoneNumber.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .id(PHONE_ID)
                .build();
    }

    public static PhoneDTO createFakePhoneDTO(){
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .id(PHONE_ID)
                .build();
    }

}
