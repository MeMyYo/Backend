package cl.ufro.prava.backend.jwt;

import cl.ufro.prava.backend.model.Usuario;

public class JWTResponseToken extends JWTResponse {
    
    private final String token;
    
    private final Usuario usuario;
    
    public JWTResponseToken(String token, Usuario usuario) {
        
        this.token = token;
        this.usuario = usuario;
        
    }
    
    public String getToken() {
        
        return this.token;
        
    }
    
    public Usuario getUsuario() {
        
        return this.usuario;
        
    }
    
}
