package com.arturbarth.VotosAPI.v1.Controller.Form;

import com.arturbarth.VotosAPI.v1.Model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;

public class AssociadoForm {
	
	private String cpf;
    private String nome;


	public Associado converter(AssociadoRepository associadoRepository) {		
		return new Associado(cpf, nome);
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
