package com.arturbarth.VotosAPI.v1.service;

import java.util.Optional;

import com.arturbarth.VotosAPI.v1.controller.dto.request.VotoRequest;
import com.arturbarth.VotosAPI.v1.controller.dto.response.VotoResponse;
import com.arturbarth.VotosAPI.v1.model.Voto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface VotoService {
    Optional<Voto> findByCpf(String cpf);
    ResponseEntity<VotoResponse> save(VotoRequest votoRequest, UriComponentsBuilder uriBuilder);   
    
}
