package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.SessaoVotacaoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.SessaoVotacaoResponse;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;
import com.arturbarth.VotosAPI.v1.service.PautaService;
import com.arturbarth.VotosAPI.v1.service.SessaoVotacaoService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SessaoVotacaoServiceImpl implements SessaoVotacaoService {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    
    public SessaoVotacaoServiceImpl(SessaoVotacaoRepository sessaoVotacaoRepository, PautaService pautaService){
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.pautaService = pautaService;
    }
    
    public ResponseEntity<SessaoVotacaoResponse> save(SessaoVotacaoRequest sessaoVotacaoRequest, UriComponentsBuilder uriBuilder){        
        SessaoVotacao sessaoVotacao = sessaoVotacaoRequest.converter(pautaService);
		sessaoVotacaoRepository.save(sessaoVotacao);		
		URI uri = uriBuilder.path("/sessao/{id}").buildAndExpand(sessaoVotacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SessaoVotacaoResponse(sessaoVotacao));  
    }
    
}
