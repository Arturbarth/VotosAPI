package com.arturbarth.VotosAPI.v1.service;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.SessaoVotacaoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.SessaoVotacaoResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface SessaoVotacaoService {    
    ResponseEntity<SessaoVotacaoResponse> save(SessaoVotacaoRequest sessaoVotacaoRequest, UriComponentsBuilder uriBuilder);
}
