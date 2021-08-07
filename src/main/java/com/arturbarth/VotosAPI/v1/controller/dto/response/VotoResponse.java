package com.arturbarth.VotosAPI.v1.controller.dto.response;

import java.util.List;
import java.util.stream.Collectors;

import com.arturbarth.VotosAPI.v1.model.OpcoesVoto;
import com.arturbarth.VotosAPI.v1.model.Voto;

public class VotoResponse {
    
    private String cpfAssociado;
   
	private OpcoesVoto voto;    

    private Long sessaoVotacaoId;


    public VotoResponse(){
    }

    public VotoResponse(Voto voto) {
        this.cpfAssociado = voto.getAssociado().getCpf();
        this.voto = voto.getVoto();     
        this.sessaoVotacaoId = voto.getSessaoVotacao().getId(); 
    }

    public static List<VotoResponse> converter(List<Voto> votos) {
		return votos.stream().map(VotoResponse::new).collect(Collectors.toList());
	}

    /**
     * @return String return the cpfAssociado
     */
    public String getCpfAssociado() {
        return cpfAssociado;
    }

    /**
     * @param cpfAssociado the cpfAssociado to set
     */
    public void setCpfAssociado(String cpfAssociado) {
        this.cpfAssociado = cpfAssociado;
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
     * @return Long return the pautaId
     */
    public Long getPautaId() {
        return sessaoVotacaoId;
    }

    /**
     * @param pautaId the pautaId to set
     */
    public void setPautaId(Long pautaId) {
        this.sessaoVotacaoId = pautaId;
    }

}
