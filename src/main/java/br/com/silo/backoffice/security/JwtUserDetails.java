package br.com.silo.backoffice.security;

import br.com.silo.backoffice.domain.Empresa;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class JwtUserDetails extends User {
    private long id;
    private Empresa empresa;
    private String nivelAcesso;

    public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, long id, Empresa empresa, String nivelAcesso) {
        super(username, password, authorities);
        this.id = id;
        this.empresa = empresa;
        this.nivelAcesso = nivelAcesso;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return super.getUsername() ;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresaId(Empresa empresaId) {
        this.empresa = empresaId;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

}
