package com.arturbarth.VotosAPI.v1.repository;

import java.util.List;

import com.arturbarth.VotosAPI.v1.Model.SessaoVotacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {
    List<SessaoVotacao> findByPauta_id(Long id);
    List<SessaoVotacao> findByPauta_descricao(String descricao);
}