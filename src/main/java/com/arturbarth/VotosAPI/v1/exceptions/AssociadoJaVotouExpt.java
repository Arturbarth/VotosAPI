package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class AssociadoJaVotouExpt extends DefaultException  {

    public AssociadoJaVotouExpt(String cpf) {
        super("Associado já votou nessa pauta! " + cpf, HttpStatus.CONFLICT);
    }

}