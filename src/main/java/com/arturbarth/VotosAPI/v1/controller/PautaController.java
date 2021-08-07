package com.arturbarth.VotosAPI.v1.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.arturbarth.VotosAPI.v1.controller.dto.request.PautaRequest;
import com.arturbarth.VotosAPI.v1.controller.dto.response.PautaResponse;
import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.model.Pauta;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.service.PautaService;

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
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;
    
    @Autowired
    private AssociadoRepository associadoRepository;//só esta declarada para o Spring realizar a injeção no construtor do pautaService

	@Autowired
    private PautaService pautaService;

    @GetMapping
	@Cacheable(value="retornarPautas")
    public List<PautaResponse> lista(){        
        List<Pauta> pautas = pautaRepository.findAll();
	    return PautaResponse.converter(pautas);                
    }

    @GetMapping("/{id}")
	@Cacheable(value="retornarPautaPorId")
	public ResponseEntity<Pauta> detalhar(@PathVariable Long id) {
		Optional<Pauta> pauta = pautaRepository.findById(id);
		if (pauta.isPresent()) {
			return ResponseEntity.of(pauta) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<PautaResponse> cadastrar(@RequestBody @Validated PautaRequest pautaRequest, UriComponentsBuilder uriBuilder) {
		return pautaService.save(pautaRequest, uriBuilder);		
	}

}
