package com.arturbarth.VotosAPI.v1.controller.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.model.Associado;
import com.arturbarth.VotosAPI.v1.model.OpcoesVoto;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;

import org.hibernate.validator.constraints.Length;

public class VotoRequest {

    @NotNull @NotEmpty @Length(min = 12)
    private String cpf;
       
    @NotNull @NotEmpty 
	private String voto;    

    @NotNull
    private Integer sessaoVotacao;

    public Voto converter(AssociadoRepository associadoRepository, SessaoVotacaoRepository sessaoVotacaoRepository) {
		Associado associado = associadoRepository.findByCpf(cpf).get();
        SessaoVotacao sessaoVotacaor = sessaoVotacaoRepository.getOne(sessaoVotacao.longValue());
		return new Voto(associado, sessaoVotacaor, OpcoesVoto.valueOf(voto.toUpperCase()));
	}    

    /**
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return OpcoesVoto return the voto
     */
    public String getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(String voto) {
        this.voto = voto;
    }

    /**
     * @return Long return the sessaoVotacao
     */
    public Integer getSessaoVotacao() {
        return sessaoVotacao;
    }

    /**
     * @param sessaoVotacao the sessaoVotacao to set
     */
    public void setSessaoVotacao(Integer sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

}
