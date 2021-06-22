package com.arturbarth.VotosAPI.v1.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.arturbarth.VotosAPI.v1.Controller.DTO.SessaoVotacaoDTO;
import com.arturbarth.VotosAPI.v1.Controller.DTO.VotoDTO;
import com.arturbarth.VotosAPI.v1.Controller.Form.SessaoVotacaoForm;
import com.arturbarth.VotosAPI.v1.Controller.Form.VotoForm;
import com.arturbarth.VotosAPI.v1.Model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.Model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;
import com.arturbarth.VotosAPI.v1.repository.VotoRepository;

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
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private SessaoVotacaoRepository sessaoVotacaoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public List<VotoDTO> lista(){        
        List<Voto> votos = votoRepository.findAll();
	    return VotoDTO.converter(votos);                
    }

    @GetMapping("/{id}")
	public ResponseEntity<Voto> detalhar(@PathVariable Long id) {
		Optional<Voto> votos = votoRepository.findById(id);
		if (votos.isPresent()) {
			return ResponseEntity.of(votos) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<VotoDTO> cadastrar(@RequestBody @Validated VotoForm form, UriComponentsBuilder uriBuilder) {		
        Voto voto = form.converter(associadoRepository, sessaoVotacaoRepository);        
		votoRepository.save(voto);
		
		URI uri = uriBuilder.path("/voto/{id}").buildAndExpand(voto.getId()).toUri();
		return ResponseEntity.created(uri).body(new VotoDTO(voto));
	}

    
}
