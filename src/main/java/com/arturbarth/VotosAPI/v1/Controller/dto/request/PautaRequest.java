package com.arturbarth.VotosAPI.v1.Controller.dto.request;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.arturbarth.VotosAPI.v1.model.Pauta;
import com.arturbarth.VotosAPI.v1.repository.AssociadoRepository;
import org.hibernate.validator.constraints.Length;

public class PautaRequest {
   
    @NotNull @NotEmpty @Length(min = 5)
    private String descricao;    
       
    @NotNull @NotEmpty @Length(min = 12)
    private String cpf;

    public Pauta converter(AssociadoRepository associadoRepository) {
		var associado = associadoRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Associado não encontrado"));
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
