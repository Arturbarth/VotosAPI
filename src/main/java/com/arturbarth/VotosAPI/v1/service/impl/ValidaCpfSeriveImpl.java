package com.arturbarth.VotosAPI.v1.service.impl;

import java.util.Collections;

import com.arturbarth.VotosAPI.v1.Controller.dto.response.ValidaCpfResponse;
import com.arturbarth.VotosAPI.v1.exceptions.AssociadoCpfInvalidoExpt;
import com.arturbarth.VotosAPI.v1.exceptions.FalhaValidarCpfExpt;
import com.arturbarth.VotosAPI.v1.service.ValidaCpfService;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ValidaCpfSeriveImpl implements ValidaCpfService {

    private String url = "https://user-info.herokuapp.com/users/";    

    @Override
    public boolean validarCpf(final String cpf){
        ValidaCpfResponse response = retornaCpfValido(cpf);
        return "ABLE_TO_VOTE".equalsIgnoreCase(response.getStatus());
    }
    
    private ValidaCpfResponse retornaCpfValido(final String cpf) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entidade = new HttpEntity<>(headers);

        String recurso = UriComponentsBuilder.fromHttpUrl(url+cpf).toUriString();
		try {
			RestTemplate requisicao = new RestTemplate();
            ResponseEntity<ValidaCpfResponse> response = requisicao.exchange(recurso, HttpMethod.GET, entidade, ValidaCpfResponse.class);
			return response.getBody();
		} catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND){
                throw new AssociadoCpfInvalidoExpt(cpf);      
            }
			throw new FalhaValidarCpfExpt();
		}  	
    }    
}
