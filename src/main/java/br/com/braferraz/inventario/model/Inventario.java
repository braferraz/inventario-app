package br.com.braferraz.inventario.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Inventario {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "O Nome não pode estar em branco")
    private String nome;

    @NotNull(message = "A data de início não pode ser nula")
    private LocalDate dataInicio;

    @NotNull(message = "O status não pode ser nulo")
    private Status status;

    @NotBlank(message = "O Codigo do cliente não pode estar em branco")
    private String codCliente;

    @NotNull(message = "Usuário não pode ser nulo")
    @ManyToOne
    private Usuario criadoPor;

    @NotEmpty(message = "A lista de inventariadores não pode estar vazia")
    @ManyToMany
    @JoinTable(
            name = "inventario_usuarios",
            joinColumns = @JoinColumn(name = "inventario_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> inventariadores = new ArrayList<>();
}
