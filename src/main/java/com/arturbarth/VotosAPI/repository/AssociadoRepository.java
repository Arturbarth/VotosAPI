package com.arturbarth.VotosAPI.repository;

import com.arturbarth.VotosAPI.Model.Associado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {

    List<Associado> findByNome(String nome);
    Associado findByCpf(String cpf);
    
}
