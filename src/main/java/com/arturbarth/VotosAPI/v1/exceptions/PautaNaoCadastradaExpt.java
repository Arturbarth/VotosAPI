package com.arturbarth.VotosAPI.v1.exceptions;

import org.springframework.http.HttpStatus;

public class PautaNaoCadastradaExpt extends DefaultException {
    
    public PautaNaoCadastradaExpt(Integer pautaId) {
        super("Pauta não cadastrada! " + pautaId, HttpStatus.BAD_REQUEST);
    }

}