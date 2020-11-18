package br.com.silo.backoffice.security;

import br.com.silo.backoffice.dao.UsuarioDAO;
import br.com.silo.backoffice.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioDAO.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        return new JwtUserDetails(user.getNome(), user.getSenha(), grantedAuthorityList, user.getId(), user.getEmpresa(), user.getNivelAcesso());
    }

    public Usuario save(Usuario usuario) {
        Usuario newUser = new Usuario();
        newUser.setNome(usuario.getNome());
        newUser.setSenha(bcryptEncoder.encode(usuario.getSenha()));
        newUser.setEmpresa(usuario.getEmpresa());
        usuarioDAO.save(newUser);
        return newUser;
    }
}
