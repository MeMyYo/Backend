package cl.ufro.prava.backend.model;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {
    
    @Override
    public List<Autor> findAll();
    
    public Optional<Autor> findByNombre(String nombre);
    
}
