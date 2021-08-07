package com.arturbarth.VotosAPI.v1.model;

public enum OpcoesVoto {
    NAO("NÃO"),
    SIM("SIM");

    private String label;
    
    OpcoesVoto(String label){
      this.label = label;
    }

    /**
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }
}
