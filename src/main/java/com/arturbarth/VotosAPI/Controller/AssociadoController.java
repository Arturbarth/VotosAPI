package com.arturbarth.VotosAPI.Controller;

import com.arturbarth.VotosAPI.Controller.DTO.AssociadoDto;
import com.arturbarth.VotosAPI.Controller.Form.AssociadoForm;
import com.arturbarth.VotosAPI.Model.Associado;
import com.arturbarth.VotosAPI.repository.AssociadoRepository;

import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

    @GetMapping
    public List<Associado> lista(){
        return associadoRepository.findAll();
    }

    @GetMapping("/{id}")
	public ResponseEntity<Associado> detalhar(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		if (associado.isPresent()) {
			return ResponseEntity.of(associado) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<AssociadoDto> cadastrar(@RequestBody @Validated AssociadoForm form, UriComponentsBuilder uriBuilder) {
		Associado associado = form.converter(associadoRepository);
		associadoRepository.save(associado);
		
		URI uri = uriBuilder.path("/associado/{id}").buildAndExpand(associado.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssociadoDto(associado));
	}
		    
}