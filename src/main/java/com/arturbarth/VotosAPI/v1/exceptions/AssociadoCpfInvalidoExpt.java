package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class AssociadoCpfInvalidoExpt extends DefaultException {

    public AssociadoCpfInvalidoExpt(String cpf) {
        super("O CPF " + cpf + " informado é inválido!", HttpStatus.BAD_REQUEST);
    }
    
}
