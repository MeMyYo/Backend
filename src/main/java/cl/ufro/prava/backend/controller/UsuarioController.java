package cl.ufro.prava.backend.controller;

import cl.ufro.prava.backend.model.Usuario;
import cl.ufro.prava.backend.model.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @GetMapping("usuario")
    @Secured("IS_AUTHENTICATED_FULLY")
    public List<Usuario> index() {
        return this.usuarioRepository.findAll();
    }
    
    @PostMapping("usuario")
    @PreAuthorize("true")
    public Long store(@RequestBody Usuario usuario) {
        
        System.out.println(usuario.getPassword());
        
        // Encriptar contraseña
        usuario.setPassword( this.passwordEncoder.encode( usuario.getPassword() ) );
        
        // Guardar usuario
        return this.usuarioRepository.save(usuario).getId();
    }
}
