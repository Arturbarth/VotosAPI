package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class AssociadoJaExisteExpt extends DefaultException  {

    public AssociadoJaExisteExpt(String cpf) {
        super("Associado já cadastrado! " + cpf, HttpStatus.CONFLICT);
    }

}
