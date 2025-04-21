package br.com.braferraz.inventario.dto.inventario;

import br.com.braferraz.inventario.model.Status;
import br.com.braferraz.inventario.model.Usuario;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UpdateInventarioDTO {
    private String nome;

    private String codCliente;

    private LocalDate dataInicio;

    private Status status;

    @ManyToMany
    @JoinTable(
            name = "inventario_usuarios",
            joinColumns = @JoinColumn(name = "inventario_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> inventariadores = new ArrayList<>();

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

    public List<Usuario> getInventariadores() {
        return inventariadores;
    }

    public void setInventariadores(List<Usuario> inventariadores) {
        this.inventariadores = inventariadores;
    }
}
