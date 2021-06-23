package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.AssociadoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.AssociadoResponse;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoJaExisteExpt;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoNaoCadastrado;
import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.service.AssociadoService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class AssociadoServiceImpl implements AssociadoService {
    
    private final AssociadoRepository associadoRepository;

    public AssociadoServiceImpl(AssociadoRepository associadoRepository){
      this.associadoRepository = associadoRepository;
    }

    @Override
    public Associado findByCpf(String cpf){        
        return associadoRepository.findByCpf(cpf).orElseThrow(() -> new AssociadoNaoCadastrado(cpf));
    }

    @Override
    public Optional<Associado> findByCpfOptional(String cpf){        
        return associadoRepository.findByCpf(cpf);
    }

    @Override
    public ResponseEntity<AssociadoResponse> save(AssociadoRequest associadoForm, UriComponentsBuilder uriBuilder){        
        if (findByCpfOptional(associadoForm.getCpf()).isPresent()){
          throw new AssociadoJaExisteExpt(associadoForm.getCpf());
        }
        Associado associado = associadoForm.converter(associadoRepository);        
		associadoRepository.save(associado);

        URI uri = uriBuilder.path("/associado/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoResponse(associado));

    }

    
}
