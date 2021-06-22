package com.arturbarth.VotosAPI.v1.Controller.DTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.arturbarth.VotosAPI.v1.Model.SessaoVotacao;

public class SessaoVotacaoDTO {    
    private Long sessaoId;    
    private String pauta;
    private ArrayList<VotoDTO> votos;
    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);
    

    public SessaoVotacaoDTO(){
    }

    public SessaoVotacaoDTO(SessaoVotacao sessaoVotacao) {
        this.sessaoId = sessaoVotacao.getId();
        this.pauta = sessaoVotacao.getPauta().getId().toString();
        this.validoAte = sessaoVotacao.getValidoAte();
        this.votos = new ArrayList<>();
		this.votos.addAll(sessaoVotacao.getVotos().stream().map(VotoDTO::new).collect(Collectors.toList()));
    }

    public static List<SessaoVotacaoDTO> converter(List<SessaoVotacao> sessoesVotacao) {
		return sessoesVotacao.stream().map(SessaoVotacaoDTO::new).collect(Collectors.toList());
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
    public void setVotos(ArrayList<VotoDTO> votos) {
        this.votos = votos;
    }

}
