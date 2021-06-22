package com.arturbarth.VotosAPI.v1.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.arturbarth.VotosAPI.v1.Controller.DTO.PautaDTO;
import com.arturbarth.VotosAPI.v1.Controller.Form.PautaForm;
import com.arturbarth.VotosAPI.v1.Model.Associado;
import com.arturbarth.VotosAPI.v1.Model.Pauta;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;

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
@RequestMapping("/pauta")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;
    
    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public List<PautaDTO> lista(){        
        List<Pauta> pautas = pautaRepository.findAll();
	    return PautaDTO.converter(pautas);                
    }

    @GetMapping("/{id}")
	public ResponseEntity<Pauta> detalhar(@PathVariable Long id) {
		Optional<Pauta> pauta = pautaRepository.findById(id);
		if (pauta.isPresent()) {
			return ResponseEntity.of(pauta) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<PautaDTO> cadastrar(@RequestBody @Validated PautaForm form, UriComponentsBuilder uriBuilder) {
		Pauta pauta = form.converter(associadoRepository);
		pautaRepository.save(pauta);
		
		URI uri = uriBuilder.path("/pauta/{id}").buildAndExpand(pauta.getId()).toUri();
		return ResponseEntity.created(uri).body(new PautaDTO(pauta));
	}

}
