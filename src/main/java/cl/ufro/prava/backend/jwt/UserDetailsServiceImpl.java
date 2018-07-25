package cl.ufro.prava.backend.jwt;

import cl.ufro.prava.backend.model.Usuario;
import cl.ufro.prava.backend.model.UsuarioRepository;
import static java.util.Collections.emptyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario user = this.usuarioRepository.findByNombre(username);
        
        if ( user == null ) {
            throw new UsernameNotFoundException(username);
        }
        
        return new org.springframework.security.core.userdetails.User(user.getNombre(), user.getPassword(), emptyList());
        
    }
    
    public Usuario getUserByUsername(String username) {
        
        return this.usuarioRepository.findByNombre(username);
        
    }
    
}
