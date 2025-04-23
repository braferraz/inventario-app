package br.com.braferraz.inventario.dto.formulario.template;

import br.com.braferraz.inventario.model.Campo;
import jakarta.persistence.*;

import java.util.List;

public class TemplateDTO {

    private String nome;
    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    private List<Long> campos;
}
