package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.annotation.ApplicationScope;

@ApplicationScope
public class AssociadoJaVotouExpt extends DefaultException  {

    public AssociadoJaVotouExpt(String cpf) {
        super("Associado já votou nessa pauta! " + cpf, HttpStatus.CONFLICT);
    }

}