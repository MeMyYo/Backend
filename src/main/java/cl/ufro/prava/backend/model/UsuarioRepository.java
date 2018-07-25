package cl.ufro.prava.backend.model;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
    @Override
    public List<Usuario> findAll();
    
    public Usuario findByNombre(String nombre);
}
