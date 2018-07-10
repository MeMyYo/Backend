package cl.ufro.prava.backend.controller;

import cl.ufro.prava.backend.model.Autor;
import cl.ufro.prava.backend.model.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("autor")
public class AutorController {
    
    @Autowired
    private AutorRepository autorRepository;
    
    @GetMapping
    public List<Autor> index() {
        return this.autorRepository.findAll();
    }
    
    @PostMapping
    public Long store(@RequestBody Autor autor) {
        return this.autorRepository.save(autor).getId();
    }
    
}
