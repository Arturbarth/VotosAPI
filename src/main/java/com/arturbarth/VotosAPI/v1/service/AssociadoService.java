package com.arturbarth.VotosAPI.v1.service;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.AssociadoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.AssociadoResponse;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface AssociadoService {

    ResponseEntity<AssociadoResponse> save(AssociadoRequest associadoForm, UriComponentsBuilder uriBuilder);
    
}
