package com.arturbarth.VotosAPI.v1.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;


@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pautaId;
    private String descricao;
    private LocalDateTime criacao;
    
    @ManyToOne
    private Associado associadoCriador;

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
     * @return Associado return the associadoCriador
     */
    public Associado getAssociadoCriador() {
        return associadoCriador;
    }

    /**
     * @param associadoCriador the associadoCriador to set
     */
    public void setAssociadoCriador(Associado associadoCriador) {
        this.associadoCriador = associadoCriador;
    }
}
