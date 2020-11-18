package br.com.silo.backoffice.domain.dto;

import br.com.silo.backoffice.domain.Empresa;
import br.com.silo.backoffice.domain.Usuario;

public class UsuarioDTO {

    //private static Empresa empresa;
    Long id;

    String nome;

    String senha;

    String token = "";

    Empresa empresa;

    String nivelAcesso;

    //Empresa empresa;


    public static UsuarioDTO converter(Usuario usuario) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmpresa(usuario.getEmpresa());
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNome(usuario.getNome());
        usuarioDTO.setToken(usuario.getToken());
        usuarioDTO.setNivelAcesso(usuario.getNivelAcesso());
        return usuarioDTO;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Empresa getEmpresa() {return empresa;}

    public void setEmpresa(Empresa empresa) {this.empresa = empresa;}

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
