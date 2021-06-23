package com.arturbarth.VotosAPI.v1.service;

import java.util.Optional;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.AssociadoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.AssociadoResponse;
import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

public interface AssociadoService {

    Associado findByCpf(String cpf);
    Optional<Associado> findByCpfOptional(String cpf);
    ResponseEntity<AssociadoResponse> save(AssociadoRequest associadoForm, UriComponentsBuilder uriBuilder);
    
}
