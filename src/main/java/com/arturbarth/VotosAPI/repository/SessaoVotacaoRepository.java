package com.arturbarth.VotosAPI.repository;

import com.arturbarth.VotosAPI.Model.SessaoVotacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {

}