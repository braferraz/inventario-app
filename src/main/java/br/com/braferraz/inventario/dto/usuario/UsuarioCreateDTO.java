package br.com.braferraz.inventario.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class UsuarioCreateDTO {
    @NotBlank(message = "O Nome não pode estar em branco")
    private String nome;

    @Email
    @NotBlank(message = "O E-mail não pode estar em branco")
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    private String senha;

    private String regional;

    public UsuarioCreateDTO(String nome, String email, String senha, String regional) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.regional = regional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRegional() {
        return regional;
    }

    public void setRegional(String regional) {
        this.regional = regional;
    }
}
