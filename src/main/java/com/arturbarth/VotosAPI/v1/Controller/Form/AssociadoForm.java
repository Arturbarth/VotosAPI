package com.arturbarth.VotosAPI.v1.Controller.Form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.Model.Associado;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;

import org.hibernate.validator.constraints.Length;

public class AssociadoForm {
	
    @NotNull @NotEmpty @Length(min = 12)
	private String cpf;

    @NotNull @NotEmpty
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
