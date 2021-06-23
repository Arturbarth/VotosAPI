package com.arturbarth.VotosAPI.v1.Controller.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;

public class SessaoVotacaoResponse {    
    private Long sessaoId;    
    private String pauta;
    private ArrayList<VotoResponse> votos;
    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);
    
    private ResultadoVotacaoResponse resultadoVotacao;

    public SessaoVotacaoResponse(){
    }

    public SessaoVotacaoResponse(SessaoVotacao sessaoVotacao) {
        this.sessaoId = sessaoVotacao.getId();
        this.pauta = sessaoVotacao.getPauta().getId().toString();
        this.validoAte = sessaoVotacao.getValidoAte();
        this.votos = new ArrayList<>();
        if (sessaoVotacao.getVotos() != null) this.votos.addAll(sessaoVotacao.getVotos().stream().map(VotoResponse::new).collect(Collectors.toList()));
    }

    public static List<SessaoVotacaoResponse> converter(List<SessaoVotacao> sessoesVotacao) {
		return sessoesVotacao.stream().map(SessaoVotacaoResponse::new).collect(Collectors.toList());
	}

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
     * @return String return the pauta
     */
    public String getPauta() {
        return pauta;
    }

    /**
     * @param pauta the pauta to set
     */
    public void setPauta(String pauta) {
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
     * @param votos the votos to set
     */
    public void setVotos(ArrayList<VotoResponse> votos) {
        this.votos = votos;
    }

}
