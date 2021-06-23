package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class FalhaValidarCpfExpt extends DefaultException {
    public  FalhaValidarCpfExpt(){
        super("Falha ao realizar a validação de CPF", HttpStatus.BAD_REQUEST);
    }    
}
