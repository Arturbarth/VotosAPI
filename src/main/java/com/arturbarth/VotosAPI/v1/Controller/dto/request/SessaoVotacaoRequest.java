package com.arturbarth.VotosAPI.v1.Controller.dto.request;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.model.Pauta;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;
import com.arturbarth.VotosAPI.v1.service.PautaService;
import com.fasterxml.jackson.annotation.JsonFormat;

import antlr.collections.List;

public class SessaoVotacaoRequest {   

    @NotNull
    private Integer pauta;
   
    @NotNull
    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);

    public SessaoVotacao converter(PautaService pautaService) {
		Pauta pautar = pautaService.findById(pauta);
		return new SessaoVotacao(pautar, validoAte);
	}

    /**
     * @return int return the pauta
     */
    public Integer getPauta() {
        return pauta;
    }

    /**
     * @param pauta the pauta to set
     */
    public void setPauta(Integer pauta) {
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

}
