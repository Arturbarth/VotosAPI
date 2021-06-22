package com.arturbarth.VotosAPI.v1.Controller.Form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.Model.Associado;
import com.arturbarth.VotosAPI.v1.Model.Pauta;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import com.arturbarth.VotosAPI.v1.repository.PautaRepository;

import org.hibernate.validator.constraints.Length;

public class PautaForm {
   
    @NotNull @NotEmpty @Length(min = 5)
    private String descricao;    
       
    @NotNull @NotEmpty @Length(min = 12)
    private String cpf;

    public Pauta converter(AssociadoRepository associadoRepository) {
		Associado associado = associadoRepository.findByCpf(cpf);
		return new Pauta(descricao, associado);
	}
    
    /**
     * @return String return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

}
