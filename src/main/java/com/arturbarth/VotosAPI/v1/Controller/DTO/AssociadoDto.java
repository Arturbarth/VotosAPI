package com.arturbarth.VotosAPI.v1.Controller.DTO;

import com.arturbarth.VotosAPI.v1.Model.Associado;

public class AssociadoDto {
    
    private Long id;
    private String cpf;
    private String nome;
 

    public AssociadoDto(Associado associado) {
        this.id = associado.getId();
        this.cpf =  associado.getCpf();
        this.nome =  associado.getNome();
	}

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
     * @return String return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
