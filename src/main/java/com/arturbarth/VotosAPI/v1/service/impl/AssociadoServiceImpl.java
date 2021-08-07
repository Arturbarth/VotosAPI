package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;

import com.arturbarth.VotosAPI.v1.controller.dto.request.AssociadoRequest;
import com.arturbarth.VotosAPI.v1.controller.dto.response.AssociadoResponse;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoJaExisteExpt;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoNaoCadastrado;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoNaoPodeVotarExpt;
import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.service.AssociadoService;
import com.arturbarth.VotosAPI.v1.service.ValidaCpfService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class AssociadoServiceImpl implements AssociadoService {
    
    private final AssociadoRepository associadoRepository;
    private final ValidaCpfService validaCpfSerive;

    public AssociadoServiceImpl(AssociadoRepository associadoRepository, ValidaCpfService validaCpfSerive){
      this.associadoRepository = associadoRepository;
      this.validaCpfSerive = validaCpfSerive;
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
    public ResponseEntity<AssociadoResponse> save(AssociadoRequest associadoRequest, UriComponentsBuilder uriBuilder){        
        if (findByCpfOptional(associadoRequest.getCpf()).isPresent()){
          throw new AssociadoJaExisteExpt(associadoRequest.getCpf());
        }
        if (!validaCpfSerive.validarCpf(associadoRequest.getCpf())){
            throw new AssociadoNaoPodeVotarExpt();   
        }

        Associado associado = associadoRequest.converter(associadoRepository);        
		associadoRepository.save(associado);

        URI uri = uriBuilder.path("/associado/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoResponse(associado));

    }

    
}
