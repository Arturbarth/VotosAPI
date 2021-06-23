package com.arturbarth.VotosAPI.v1.service;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.VotoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.VotoResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface VotoService {
    ResponseEntity<VotoResponse> save(VotoRequest votoRequest, UriComponentsBuilder uriBuilder);    
}
