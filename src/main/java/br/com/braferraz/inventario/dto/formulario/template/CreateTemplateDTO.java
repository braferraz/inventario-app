package br.com.braferraz.inventario.dto.formulario.template;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateTemplateDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotEmpty
    private List<Long> campos;

    public CreateTemplateDTO(String nome, List<Long> campos) {
        this.nome = nome;
        this.campos = campos;
    }

    public CreateTemplateDTO(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getCampos() {
        return campos;
    }

    public void setCampos(List<Long> campos) {
        this.campos = campos;
    }
}
