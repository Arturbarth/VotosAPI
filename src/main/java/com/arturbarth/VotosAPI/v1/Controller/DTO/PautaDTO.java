package com.arturbarth.VotosAPI.v1.Controller.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.arturbarth.VotosAPI.v1.Model.Pauta;

public class PautaDTO {
    private Long pautaId;
    private String descricao;
    private LocalDateTime criacao;    
    private String cpfAssociadoCriador;    


    public PautaDTO(Pauta pauta) {
        this.pautaId = pauta.getId();
        this.descricao =  pauta.getDescricao();
        this.criacao =  pauta.getCriacao();
        this.cpfAssociadoCriador = pauta.getAssociadoCriador().getCpf();
	}

    public static List<PautaDTO> converter(List<Pauta> pautas) {
		return pautas.stream().map(PautaDTO::new).collect(Collectors.toList());
	}

    /**
     * @return Long return the pautaId
     */
    public Long getPautaId() {
        return pautaId;
    }

    /**
     * @param pautaId the pautaId to set
     */
    public void setPautaId(Long pautaId) {
        this.pautaId = pautaId;
    }

    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return LocalDateTime return the criacao
     */
    public LocalDateTime getCriacao() {
        return criacao;
    }

    /**
     * @param criacao the criacao to set
     */
    public void setCriacao(LocalDateTime criacao) {
        this.criacao = criacao;
    }

    /**
     * @return String return the cpfAssociadoCriador
     */
    public String getCpfAssociadoCriador() {
        return cpfAssociadoCriador;
    }

    /**
     * @param cpfAssociadoCriador the cpfAssociadoCriador to set
     */
    public void setCpfAssociadoCriador(String cpfAssociadoCriador) {
        this.cpfAssociadoCriador = cpfAssociadoCriador;
    }

}
