package com.arturbarth.VotosAPI.Model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SessaoVotacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessaoId;

    @OneToOne
    private Pauta pauta;

    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);

    @OneToMany
    private List<Voto> votos;
    
    /**
     * @return Long return the sessaoId
     */
    public Long getSessaoId() {
        return sessaoId;
    }

    /**
     * @param sessaoId the sessaoId to set
     */
    public void setSessaoId(Long sessaoId) {
        this.sessaoId = sessaoId;
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
