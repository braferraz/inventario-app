package br.com.braferraz.inventario.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Long> campos = new ArrayList<>();

    public Template(Long id, String nome, List<Long> campos) {
        this.id = id;
        this.nome = nome;
        this.campos = campos;
    }
    public Template(){

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

    public List<Long> getCampos() {
        return campos;
    }

    public void setCampos(List<Long> campos) {
        this.campos = campos;
    }

}
