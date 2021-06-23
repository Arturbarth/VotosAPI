package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class AssociadoNaoPodeVotarExpt extends DefaultException {    
    public AssociadoNaoPodeVotarExpt(){
        super("Associado não pode votar!", HttpStatus.BAD_REQUEST);
    }
}
