package com.arturbarth.VotosAPI.v1.repository;

import com.arturbarth.VotosAPI.v1.Model.SessaoVotacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Long> {

}