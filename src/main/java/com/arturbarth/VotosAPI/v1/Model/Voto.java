package com.arturbarth.VotosAPI.v1.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(
	name = "votos",
	uniqueConstraints = {
		@UniqueConstraint(
			columnNames = {
				"associado_id",
				"sessao_votacao_id"
			})
	})
public class Voto {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull    
    private Associado associado;

    @Enumerated(EnumType.STRING)    
    @NotNull
	private OpcoesVoto voto;    

    private LocalDateTime dataVoto = LocalDateTime.now();

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "sessao_votacao_id")
    private SessaoVotacao sessaoVotacao;

    public Voto(){
    }

    public Voto(Associado associado, SessaoVotacao sessaoVotacao, OpcoesVoto voto){
       this.associado = associado;
       this.sessaoVotacao = sessaoVotacao;
       this.voto = voto;
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
     * @return Associado return the associado
     */
    public Associado getAssociado() {
        return associado;
    }

    /**
     * @param associado the associado to set
     */
    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    /**
     * @return OpcoesVoto return the voto
     */
    public OpcoesVoto getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(OpcoesVoto voto) {
        this.voto = voto;
    }


    /**
     * @return LocalDateTime return the dataVoto
     */
    public LocalDateTime getDataVoto() {
        return dataVoto;
    }

    /**
     * @param dataVoto the dataVoto to set
     */
    public void setDataVoto(LocalDateTime dataVoto) {
        this.dataVoto = dataVoto;
    }



    /**
     * @return SessaoVotacao return the sessaoVotacao
     */
    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    /**
     * @param sessaoVotacao the sessaoVotacao to set
     */
    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

}
