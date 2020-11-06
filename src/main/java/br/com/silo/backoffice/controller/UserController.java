package br.com.silo.backoffice.controller;

import br.com.silo.backoffice.domain.Usuario;
import br.com.silo.backoffice.domain.dto.UsuarioDTO;
import br.com.silo.backoffice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public UsuarioDTO get() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return UsuarioDTO.converter(userService.get(currentPrincipalName));
    }

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    public Page<Usuario> getUsers(@RequestParam String name, @RequestParam Integer pageSize, @RequestParam Integer page) {
//        return userService.get(name, pageSize, page);
//    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<Usuario> getUsers(@RequestParam String name, @RequestParam long empresaId, @RequestParam Integer pageSize, @RequestParam Integer page) {
        return userService.get(name, empresaId, pageSize, page);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UsuarioDTO getUserByID(@PathVariable Long id) {
        return UsuarioDTO.converter(userService.get(id));
    }

//    @RequestMapping(value = "/listbyemail", method = RequestMethod.GET)
//    public Page<Usuario> getUsersByEmail(@RequestParam String email, @RequestParam Integer page) {
//        return userService.getByEmail(email, page);
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void post(@RequestBody UsuarioDTO user) {
        userService.saveUser(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public UsuarioDTO put(@RequestBody UsuarioDTO user) {
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
