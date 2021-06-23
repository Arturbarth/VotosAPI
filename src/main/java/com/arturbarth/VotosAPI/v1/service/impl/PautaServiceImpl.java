package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.PautaRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.PautaResponse;
import com.arturbarth.VotosAPI.v1.exceptions.PautaNaoCadastradaExpt;
import com.arturbarth.VotosAPI.v1.model.Pauta;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.service.PautaService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class PautaServiceImpl implements PautaService {
    
    private final PautaRepository pautaRepository;
    private final AssociadoRepository associadoRepository;

    public PautaServiceImpl(PautaRepository pautaRepository, AssociadoRepository associadoRepository){
      this.pautaRepository = pautaRepository;
      this.associadoRepository = associadoRepository;
    }

    @Override
    public Pauta findById(Integer pautaId){
       return pautaRepository.findById(pautaId.longValue()).orElseThrow(() -> new PautaNaoCadastradaExpt(pautaId));
    }

    @Override
    public ResponseEntity<PautaResponse> save(PautaRequest pautaRequest, UriComponentsBuilder uriBuilder){
        Pauta pauta = pautaRequest.converter(associadoRepository);
		pautaRepository.save(pauta);
		
		URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PautaResponse(pauta));
    }
    
}
