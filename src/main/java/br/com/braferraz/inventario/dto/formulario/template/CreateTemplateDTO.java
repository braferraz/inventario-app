package br.com.braferraz.inventario.dto.formulario.template;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateTemplateDTO {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotEmpty
    private List<Long> campoIds;

    public CreateTemplateDTO(String nome, List<Long> campoIds) {
        this.nome = nome;
        this.campoIds = campoIds;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getCampoIds() {
        return campoIds;
    }

    public void setCampoIds(List<Long> campoIds) {
        this.campoIds = campoIds;
    }
}
