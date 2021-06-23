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
import com.arturbarth.VotosAPI.v1.service.SessaoVotacaoService;

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
@RequestMapping("/sessao")
public class SessaoVotacaoController {

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private PautaRepository pautaRepository;//só esta declarada para o Spring realizar a injeção no construtor do sessaoVotacaoService

    @Autowired
    private SessaoVotacaoService sessaoVotacaoService;

    @GetMapping
    @Cacheable(value="retornarSessaoVotacao")
    public List<SessaoVotacaoResponse> lista(){        
        List<SessaoVotacaoResponse> listaResp = SessaoVotacaoResponse.converter(sessaoVotacaoRepository.findAll()); 
	    return listaResp;               
    }

    @GetMapping("/{id}")
    @Cacheable(value="retornarSessaoVotacaoPorId")
	public ResponseEntity<SessaoVotacaoResponse> detalhar(@PathVariable Long id) {		
        Optional<SessaoVotacao> sessoesVotacao = sessaoVotacaoRepository.findById(id);
		if (sessoesVotacao.isPresent()) {
			return ResponseEntity.ok(new SessaoVotacaoResponse(sessoesVotacao.get()));
		}		
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<SessaoVotacaoResponse> cadastrar(@RequestBody @Validated SessaoVotacaoRequest sessaoVotacaoRequest, UriComponentsBuilder uriBuilder) {
		return sessaoVotacaoService.save(sessaoVotacaoRequest, uriBuilder);
	}
    
    

    
}
