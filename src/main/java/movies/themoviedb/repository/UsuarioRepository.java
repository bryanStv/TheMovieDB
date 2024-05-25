package movies.themoviedb.repository;

import movies.themoviedb.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByName(String name);
}
