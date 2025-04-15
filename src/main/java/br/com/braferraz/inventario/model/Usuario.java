package br.com.braferraz.inventario.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O E-mail não pode estar em branco")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    private String senha;

    private String regional;
}
