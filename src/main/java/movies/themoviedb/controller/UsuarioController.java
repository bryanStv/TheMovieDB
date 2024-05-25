package movies.themoviedb.controller;

import movies.themoviedb.entity.Usuario;
import movies.themoviedb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioController {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private void add(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    private void delete(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public boolean login(String username, String password) {
        Usuario user = usuarioRepository.findByName(username);
        if(user != null) {
            if(password.equals(user.getPass())){
                return true;
            }
        }
        return false;
    }

    public boolean register(String username, String password) {
        Usuario user = usuarioRepository.findByName(username);
        if (user != null) {
            return false;
        }
        user = new Usuario();
        user.setName(username);
        user.setPass(password);
        add(user);
        return true;
    }

    public boolean forgotPassword(String username) {
        Usuario user = usuarioRepository.findByName(username);
        if(user != null) {
            return true;
        }
        return false;
    }

}
