package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class AssociadoNaoCadastrado extends DefaultException {
    
    public AssociadoNaoCadastrado(String cpf) {
        super("Associado não cadastrado! " + cpf, HttpStatus.BAD_REQUEST);
    }

}
