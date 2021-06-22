package com.arturbarth.VotosAPI.v1.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.SessaoVotacaoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.SessaoVotacaoResponse;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/sessao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private PautaRepository pautaRepository;

    @GetMapping
    public List<SessaoVotacaoResponse> lista(){        
        List<SessaoVotacao> sessoesVotacao = sessaoVotacaoRepository.findAll();
	    return SessaoVotacaoResponse.converter(sessoesVotacao);                
    }

    @GetMapping("/{id}")
	public ResponseEntity<SessaoVotacaoResponse> detalhar(@PathVariable Long id) {		
        Optional<SessaoVotacao> sessoesVotacao = sessaoVotacaoRepository.findById(id);
		if (sessoesVotacao.isPresent()) {
			return ResponseEntity.ok(new SessaoVotacaoResponse(sessoesVotacao.get()));
		}		
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<SessaoVotacaoResponse> cadastrar(@RequestBody @Validated SessaoVotacaoRequest form, UriComponentsBuilder uriBuilder) {
		SessaoVotacao sessaoVotacao = form.converter(pautaRepository);
		sessaoVotacaoRepository.save(sessaoVotacao);
		
		URI uri = uriBuilder.path("/sessao/{id}").buildAndExpand(sessaoVotacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new SessaoVotacaoResponse(sessaoVotacao));
	}
    
    

    
}
