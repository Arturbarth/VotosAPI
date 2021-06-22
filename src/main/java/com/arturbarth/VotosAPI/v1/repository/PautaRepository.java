package com.arturbarth.VotosAPI.v1.repository;

import java.util.List;
import java.util.Optional;

import com.arturbarth.VotosAPI.v1.Model.Pauta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
    List<Pauta> findByDescricao(String descricao);
}
