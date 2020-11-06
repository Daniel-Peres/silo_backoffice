package br.com.silo.backoffice.service;

import br.com.silo.backoffice.dao.UsuarioDAO;
import br.com.silo.backoffice.domain.Usuario;
import br.com.silo.backoffice.domain.dto.UsuarioDTO;
import br.com.silo.backoffice.exception.BadRequestException;
import br.com.silo.backoffice.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {
    @Autowired
    UsuarioDAO usuarioDAO;

    public Usuario get(String nome) {
        return usuarioDAO.findByUsername(nome);
    }

    public Usuario get(Long userId) {
        Usuario user = usuarioDAO.findById(userId).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não foi encontrado.");
        }
        return user;
    }

//    public Page<Usuario> get(String name, Integer pageSize, Integer page) {
//        Pageable paging = PageRequest.of(page, pageSize);
//
//        return usuarioDAO.findPaged(name, paging);
//    }

    public Page<Usuario> get(String name, long empresaId, Integer pageSize, Integer page) {
        Pageable paging = PageRequest.of(page, pageSize);

        return usuarioDAO.findPaged(name, empresaId, paging);
    }

    public void saveUser(UsuarioDTO userDTO) {

        Boolean valid = isValidUsername(userDTO.getNome(), 0L);
        if (!valid) {
            throw new BadRequestException("Já existe um usuário com este nome.");
        }

        Usuario usuario = new Usuario();
        usuario.setId(userDTO.getId());
        usuario.setNome(userDTO.getNome());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setSenha(encoder.encode(userDTO.getSenha()));

        usuario.setEmpresa(userDTO.getEmpresa());

        usuarioDAO.save(usuario);
    }

    public void updateUser(UsuarioDTO userDTO) {

        Boolean valid = isValidUsername(userDTO.getNome(), userDTO.getId());
        if (!valid) {
            throw new BadRequestException("Já existe um usuário com este nome.");
        }

        Usuario usuario = usuarioDAO.findById(userDTO.getId()).orElse(null);

        //Verifica se usuário existe.
        if (usuario == null) {
            throw new NotFoundException();
        }

        //usuario.setId(userDTO.getId());
        usuario.setNome(userDTO.getNome());

        if(userDTO.getSenha() != null && !userDTO.getSenha().isEmpty()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            usuario.setSenha(encoder.encode(userDTO.getSenha()));
        }

        usuario.setEmpresa(userDTO.getEmpresa());

        usuarioDAO.save(usuario);
    }

    public Boolean isValidUsername(String nome, Long id) {
        Usuario user = usuarioDAO.findByUsername(nome);

        if (user == null)
            return true;

        if (id != 0) {
            return user.getId() == id;
        } else {
            return false;
        }
    }

    public void deleteUser(Long id) {
        Usuario usuario = usuarioDAO.findById(id).orElse(null);

        //Verifica se usuário existe.
        if (usuario == null) {
            throw new NotFoundException();
        }

        usuarioDAO.delete(usuario);
    }
}
