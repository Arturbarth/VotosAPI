package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.VotoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.VotoResponse;
import com.arturbarth.VotosAPI.v1.model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;
import com.arturbarth.VotosAPI.v1.repository.VotoRepository;
import com.arturbarth.VotosAPI.v1.service.VotoService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final AssociadoRepository associadoRepository;

    public VotoServiceImpl(VotoRepository votoRepository, SessaoVotacaoRepository sessaoVotacaoRepository,
            AssociadoRepository associadoRepository) {
        this.votoRepository = votoRepository;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.associadoRepository = associadoRepository;
    }

    public ResponseEntity<VotoResponse> save(VotoRequest votoRequest, UriComponentsBuilder uriBuilder){
        Voto voto = votoRequest.converter(associadoRepository, sessaoVotacaoRepository);        
		votoRepository.save(voto);
		
		URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(voto.getId()).toUri();
		return ResponseEntity.created(uri).body(new VotoResponse(voto));   
    }
    
}
