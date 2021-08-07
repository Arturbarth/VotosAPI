package com.arturbarth.VotosAPI.v1.service;

import com.arturbarth.VotosAPI.v1.controller.dto.request.PautaRequest;
import com.arturbarth.VotosAPI.v1.controller.dto.response.PautaResponse;
import com.arturbarth.VotosAPI.v1.model.Pauta;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface PautaService {
    
    ResponseEntity<PautaResponse> save(PautaRequest pautaRequest, UriComponentsBuilder uriBuilder);
    Pauta findById(Integer pautaId);
    
}
