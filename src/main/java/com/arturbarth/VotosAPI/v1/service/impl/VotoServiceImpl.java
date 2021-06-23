package com.arturbarth.VotosAPI.v1.service.impl;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.VotoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.VotoResponse;
import com.arturbarth.VotosAPI.v1.exceptions.SessaoVotacaoEncerradaExpt;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoJaVotouExpt;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoNaoPodeVotarExpt;
import com.arturbarth.VotosAPI.v1.model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;
import com.arturbarth.VotosAPI.v1.repository.VotoRepository;
import com.arturbarth.VotosAPI.v1.service.ValidaCpfService;
import com.arturbarth.VotosAPI.v1.service.VotoService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import javassist.bytecode.stackmap.BasicBlock.Catch;

@Service
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final AssociadoRepository associadoRepository;
    private final ValidaCpfService ValidaCpfSerive;

    public VotoServiceImpl(VotoRepository votoRepository, SessaoVotacaoRepository sessaoVotacaoRepository,
            AssociadoRepository associadoRepository, ValidaCpfService validaCpfService) {
        this.votoRepository = votoRepository;
        this.sessaoVotacaoRepository = sessaoVotacaoRepository;
        this.associadoRepository = associadoRepository;
        this.ValidaCpfSerive = validaCpfService;
    }

    @Override
    public Optional<Voto> findByCpf(String cpf){
        return votoRepository.findByAssociado_cpf(cpf);
    }
    

    @Override
    public ResponseEntity<VotoResponse> save(VotoRequest votoRequest, UriComponentsBuilder uriBuilder){
        Voto voto = votoRequest.converter(associadoRepository, sessaoVotacaoRepository);                         
        if(LocalDateTime.now().isAfter(voto.getSessaoVotacao().getValidoAte())) {
            throw new SessaoVotacaoEncerradaExpt();
        }
        if (!ValidaCpfSerive.validarCpf(votoRequest.getCpf())){
            throw new AssociadoNaoPodeVotarExpt();
        }
        //o tratamento de voto duplicado na sessão de votação por CPF ficará somente na UNIQUE pois não sei como tratar ainda.
        votoRepository.save(voto);
        
        URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(voto.getId()).toUri();
        return ResponseEntity.created(uri).body(new VotoResponse(voto));           
    }
    
}
