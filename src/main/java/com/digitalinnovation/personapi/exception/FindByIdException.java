package com.digitalinnovation.personapi.exception;



public class FindByIdException extends Exception {

    public FindByIdException() {
        super("ID não encontrado");
    }
}
