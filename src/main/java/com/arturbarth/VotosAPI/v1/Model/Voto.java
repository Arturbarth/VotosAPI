package com.arturbarth.VotosAPI.v1.Model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Voto {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Associado associado;

    @Enumerated(EnumType.STRING)
	private OpcoesVoto voto;    

    private LocalDateTime dataVoto = LocalDateTime.now();

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

}
