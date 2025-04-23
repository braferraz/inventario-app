package br.com.braferraz.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String codCliente;

    private LocalDate dataInicio;

    private Status status;

    @ManyToOne
    private Usuario criadoPor;

    @ManyToMany
    @JoinTable(
            name = "inventario_usuarios",
            joinColumns = @JoinColumn(name = "inventario_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> inventariadores = new ArrayList<>();

    @ManyToOne
    private Template templateFormulario;

    public Inventario(Long id, String nome, String codCliente, LocalDate dataInicio, Status status, Usuario criadoPor, List<Usuario> inventariadores, Template templateFormulario) {
        this.id = id;
        this.nome = nome;
        this.codCliente = codCliente;
        this.dataInicio = dataInicio;
        this.status = status;
        this.criadoPor = criadoPor;
        this.inventariadores = inventariadores;
        this.templateFormulario = templateFormulario;
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

    public Template getTemplateFormulario() {
        return templateFormulario;
    }

    public void setTemplateFormulario(Template templateFormulario) {
        this.templateFormulario = templateFormulario;
    }
}
