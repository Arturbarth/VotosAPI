package com.arturbarth.VotosAPI.v1.controller.dto.response;

public class ResultadoVotacaoResponse {

    private Integer quantidadeVotos;
    private Integer quantidadeVotosSim;
    private Integer quantidadeVotosNao;
    private Double percentualSim;
    private Double percentualNao;    
    
    public ResultadoVotacaoResponse(Integer quantidadeVotos, Integer quantidadeVotosSim, Integer quantidadeVotosNao) {
        this.quantidadeVotos = quantidadeVotos;
        this.quantidadeVotosSim = quantidadeVotosSim;
        this.quantidadeVotosNao = quantidadeVotosNao;
        this.percentualSim = (double) ((quantidadeVotosSim / quantidadeVotos) * 100);
        this.percentualNao = 100 - percentualSim;
    }

    /**
     * @return Integer return the quantidadeVotos
     */
    public Integer getQuantidadeVotos() {
        return quantidadeVotos;
    }

    /**
     * @param quantidadeVotos the quantidadeVotos to set
     */
    public void setQuantidadeVotos(Integer quantidadeVotos) {
        this.quantidadeVotos = quantidadeVotos;
    }

    /**
     * @return Integer return the quantidadeVotosSim
     */
    public Integer getQuantidadeVotosSim() {
        return quantidadeVotosSim;
    }

    /**
     * @param quantidadeVotosSim the quantidadeVotosSim to set
     */
    public void setQuantidadeVotosSim(Integer quantidadeVotosSim) {
        this.quantidadeVotosSim = quantidadeVotosSim;
    }

    /**
     * @return Integer return the quantidadeVotosNao
     */
    public Integer getQuantidadeVotosNao() {
        return quantidadeVotosNao;
    }

    /**
     * @param quantidadeVotosNao the quantidadeVotosNao to set
     */
    public void setQuantidadeVotosNao(Integer quantidadeVotosNao) {
        this.quantidadeVotosNao = quantidadeVotosNao;
    }

    /**
     * @return Double return the percentualSim
     */
    public Double getPercentualSim() {
        return percentualSim;
    }

    /**
     * @param percentualSim the percentualSim to set
     */
    public void setPercentualSim(Double percentualSim) {
        this.percentualSim = percentualSim;
    }

    /**
     * @return Double return the percentualNao
     */
    public Double getPercentualNao() {
        return percentualNao;
    }

    /**
     * @param percentualNao the percentualNao to set
     */
    public void setPercentualNao(Double percentualNao) {
        this.percentualNao = percentualNao;
    }

}
