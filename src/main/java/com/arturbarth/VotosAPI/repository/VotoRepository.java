package com.arturbarth.VotosAPI.repository;

import com.arturbarth.VotosAPI.Model.Voto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    
}
