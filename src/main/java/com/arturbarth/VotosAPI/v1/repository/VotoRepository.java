package com.arturbarth.VotosAPI.v1.repository;

import com.arturbarth.VotosAPI.v1.model.Voto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    
}
