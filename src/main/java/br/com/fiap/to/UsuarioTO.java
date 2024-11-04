package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class UsuarioTO {
    private Long idCliente;
    @NotBlank private String nome;
    @NotBlank private String email;
    @NotBlank private String usuario;
    @NotBlank private String senha;
    @NotBlank private String placa;

    public UsuarioTO() {
    }

    public UsuarioTO(Long idCliente, String nome, String email, String usuario, String senha, String placa) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.placa = placa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
