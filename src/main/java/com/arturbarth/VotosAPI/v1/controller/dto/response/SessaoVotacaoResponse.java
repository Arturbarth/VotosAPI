package com.arturbarth.VotosAPI.v1.controller.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.arturbarth.VotosAPI.v1.model.OpcoesVoto;
import com.arturbarth.VotosAPI.v1.model.SessaoVotacao;

public class SessaoVotacaoResponse {    
    private Long sessaoId;    
    private String pauta;    
    private LocalDateTime validoAte = LocalDateTime.now().plusMinutes(1);

    private ArrayList<VotoResponse> votos;
    private ResultadoVotacaoResponse resultadoVotacao;

    public SessaoVotacaoResponse(){
    }

    public SessaoVotacaoResponse(SessaoVotacao sessaoVotacao) {
        this.sessaoId = sessaoVotacao.getId();
        this.pauta = sessaoVotacao.getPauta().getId().toString();
        this.validoAte = sessaoVotacao.getValidoAte();
            
        this.votos = new ArrayList<>();
        if (sessaoVotacao.getVotos() != null){
            this.votos.addAll(sessaoVotacao.getVotos().stream().map(VotoResponse::new).collect(Collectors.toList()));

            Integer quantidadeVotos = this.votos.size();
            Integer quantidadeVotosSim = (int) sessaoVotacao.getVotos().stream().filter(c -> c.getVoto() == OpcoesVoto.SIM).count();
		    Integer quantidadeVotosNao = (int) sessaoVotacao.getVotos().stream().filter(c -> c.getVoto() == OpcoesVoto.NAO).count();
            
            resultadoVotacao = new ResultadoVotacaoResponse(quantidadeVotos, quantidadeVotosSim, quantidadeVotosNao);
        } 
    }

    public static List<SessaoVotacaoResponse> converter(List<SessaoVotacao> sessoesVotacao) {
        List<SessaoVotacaoResponse> listaResp = sessoesVotacao.stream().map(SessaoVotacaoResponse::new).collect(Collectors.toList());
		return listaResp;
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
    
    /**
     * @return ResultadoVotacaoResponse return the resultadoVotacao
     */
    public ResultadoVotacaoResponse getResultadoVotacao() {
        return resultadoVotacao;
    }

    /**
     * @param resultadoVotacao the resultadoVotacao to set
     */
    public void setResultadoVotacao(ResultadoVotacaoResponse resultadoVotacao) {
        this.resultadoVotacao = resultadoVotacao;
    }

}
