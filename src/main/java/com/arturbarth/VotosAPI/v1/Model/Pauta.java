package com.arturbarth.VotosAPI.v1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Entity
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @NotEmpty
    private String descricao;

    private LocalDateTime criacao = LocalDateTime.now();
    
    @ManyToOne
    private Associado associadoCriador;

    public Pauta(){
    }

    public Pauta(String descricao, Associado associadoCriador){
       this.descricao = descricao;
       this.associadoCriador = associadoCriador;
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
