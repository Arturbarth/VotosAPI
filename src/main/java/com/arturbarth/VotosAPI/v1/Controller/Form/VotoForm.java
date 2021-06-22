package com.arturbarth.VotosAPI.v1.Controller.Form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.Model.Associado;
import com.arturbarth.VotosAPI.v1.Model.OpcoesVoto;
import com.arturbarth.VotosAPI.v1.Model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.Model.Voto;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.SessaoVotacaoRepository;

import org.hibernate.validator.constraints.Length;

public class VotoForm {

    @NotNull @NotEmpty @Length(min = 12)
    private String cpf;
       
    @NotNull @NotEmpty 
	private String voto;    

    @NotNull
    private Integer sessaoVotacao;

    public Voto converter(AssociadoRepository associadoRepository, SessaoVotacaoRepository sessaoVotacaoRepository) {
		Associado associado = associadoRepository.findByCpf(cpf);
        SessaoVotacao sessaoVotacaor = sessaoVotacaoRepository.getOne(sessaoVotacao.longValue());
		return new Voto(associado, sessaoVotacaor, OpcoesVoto.valueOf(voto));
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
