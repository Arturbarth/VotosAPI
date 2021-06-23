package com.arturbarth.VotosAPI.v1.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.SessaoVotacaoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.request.VotoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.SessaoVotacaoResponse;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.VotoResponse;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;
import com.arturbarth.VotosAPI.v1.repository.VotoRepository;
import com.arturbarth.VotosAPI.v1.service.VotoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @Autowired
    private VotoService votoService;

    @GetMapping
    @Cacheable
    public List<VotoResponse> lista(){        
        List<Voto> votos = votoRepository.findAll();
	    return VotoResponse.converter(votos);                
    }

    @GetMapping("/{id}")
    @Cacheable
	public ResponseEntity<Voto> detalhar(@PathVariable Long id) {
		Optional<Voto> votos = votoRepository.findById(id);
		if (votos.isPresent()) {
			return ResponseEntity.of(votos) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<VotoResponse> cadastrar(@RequestBody @Validated VotoRequest votoRequest, UriComponentsBuilder uriBuilder) {		        
        return votoService.save(votoRequest, uriBuilder);
	}

    
}
