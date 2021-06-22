package com.arturbarth.VotosAPI.v1.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "sessao_votacao")
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Pauta pauta;

    @NotNull
    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);

    @OneToMany(mappedBy = "sessaoVotacao")
    private List<Voto> votos;

    public SessaoVotacao(){

    }

    public SessaoVotacao(Pauta pauta, LocalDateTime validoAte){
       this.pauta = pauta;
       this.validoAte = validoAte;
    }
    
    public SessaoVotacao(Pauta pauta, LocalDateTime validoAte, List<Voto> votos){
        this.pauta = pauta;
        this.validoAte = validoAte;
        this.votos = votos;
     }
    
    /**
     * @return Long return the sessaoId
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the sessaoId to set
     */
    public void setSessaoId(Long id) {
        this.id = id;
    }

    /**
     * @return Pauta return the pauta
     */
    public Pauta getPauta() {
        return pauta;
    }

    /**
     * @param pauta the pauta to set
     */
    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    /**
     * @return LocalDateTime return the validoAte
     */
    public LocalDateTime getValidoAte() {
        return validoAte;
    }

    /**
     * @param validoAte the validoAte to set
     */
    public void setValidoAte(LocalDateTime validoAte) {
        this.validoAte = validoAte;
    }

    /**
     * @return List<Voto> return the votos
     */
    public List<Voto> getVotos() {
        return votos;
    }

    /**
     * @param votos the votos to set
     */
    public void setVotos(List<Voto> votos) {
        this.votos = votos;
    }

}
