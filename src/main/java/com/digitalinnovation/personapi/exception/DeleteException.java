package com.digitalinnovation.personapi.exception;

public class DeleteException extends Exception{
    public DeleteException(){
        super("ID não encontrado no banco de dados");
    }
}
