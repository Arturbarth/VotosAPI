package com.arturbarth.VotosAPI.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.arturbarth.VotosAPI.v1.model.Associado;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {  
    Optional<Associado> findByCpf(String cpf);    
}
