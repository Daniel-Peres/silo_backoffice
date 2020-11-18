package br.com.silo.backoffice.security;

import br.com.silo.backoffice.domain.Empresa;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    private final String jwttoken;

    private long expireAt;

    private long id;

    private String nome;

    private Empresa empresa;

    private String nivelAcesso;

    public JwtResponse(String jwttoken, long expireAt, long id, String nome, Empresa empresa, String nivelAcesso) {
        this.jwttoken = jwttoken;
        this.expireAt = expireAt;
        this.id = id;
        this.nome = nome;
        this.empresa = empresa;
        this.nivelAcesso = nivelAcesso;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public long getId() {
        return id;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public String getNome() {
        return this.nome;
    }

    public Empresa getEmpresa() { return this.empresa; }

    public String getNivelAcesso() {return  this.nivelAcesso;}
}
