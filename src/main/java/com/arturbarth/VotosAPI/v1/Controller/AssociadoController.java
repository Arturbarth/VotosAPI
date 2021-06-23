package com.arturbarth.VotosAPI.v1.Controller;

import com.arturbarth.VotosAPI.v1.Controller.dto.request.AssociadoRequest;
import com.arturbarth.VotosAPI.v1.Controller.dto.response.AssociadoResponse;
import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.service.AssociadoService;
import com.arturbarth.VotosAPI.v1.service.ValidaCpfService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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
@RequestMapping("/associado")
public class AssociadoController {

    @Autowired
    private AssociadoRepository associadoRepository;

	@Autowired
    private AssociadoService associadoService;

	@Autowired
    private ValidaCpfService validaCpfService;//só esta declarada para o Spring realizar a injeção no construtor do votoService  


    @GetMapping
	@Cacheable(value="buscarTodosAssociados")
    public List<Associado> buscarTodos(){
        return associadoRepository.findAll();
    }

    @GetMapping("/{id}")
	@Cacheable(value="buscarAssociadoPorId")
	public ResponseEntity<Associado> buscarPorId(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		if (associado.isPresent()) {
			return ResponseEntity.of(associado) ;
        }        
		return ResponseEntity.notFound().build();
	}	

    @PostMapping
	@Transactional
	public ResponseEntity<AssociadoResponse> cadastrar(@RequestBody @Validated AssociadoRequest associadoRequest, UriComponentsBuilder uriBuilder) {		
		return associadoService.save(associadoRequest, uriBuilder);		
	}
		    
}
