package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class SessaoVotacaoEncerradaExpt extends DefaultException {

    public SessaoVotacaoEncerradaExpt() {
        super("Sessão de votação encerrada!", HttpStatus.BAD_REQUEST);        
    }
        
}
