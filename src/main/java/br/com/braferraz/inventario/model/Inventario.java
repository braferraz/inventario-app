package br.com.braferraz.inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "O Codigo do cliente não pode estar em branco")
    private String codCliente;

    @NotNull(message = "A data de início não pode ser nula")
    private LocalDate dataInicio;

    @NotNull(message = "O status não pode ser nulo")
    private Status status;

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

    public Inventario(Long id, String nome, String codCliente, LocalDate dataInicio, Status status, Usuario criadoPor, List<Usuario> inventariadores) {
        this.id = id;
        this.nome = nome;
        this.codCliente = codCliente;
        this.dataInicio = dataInicio;
        this.status = status;
        this.criadoPor = criadoPor;
        this.inventariadores = inventariadores;
    }
    public Inventario(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Usuario getCriadoPor() {
        return criadoPor;
    }

    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
    }

    public List<Usuario> getInventariadores() {
        return inventariadores;
    }

    public void setInventariadores(List<Usuario> inventariadores) {
        this.inventariadores = inventariadores;
    }
}
