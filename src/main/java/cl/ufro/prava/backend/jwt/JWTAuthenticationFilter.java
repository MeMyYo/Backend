package cl.ufro.prava.backend.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import static cl.ufro.prava.backend.jwt.SecurityConstants.EXPIRATION_TIME;
import static cl.ufro.prava.backend.jwt.SecurityConstants.HEADER_STRING;
import static cl.ufro.prava.backend.jwt.SecurityConstants.LOGIN_URL;
import static cl.ufro.prava.backend.jwt.SecurityConstants.SECRET;
import static cl.ufro.prava.backend.jwt.SecurityConstants.TOKEN_PREFIX;
import cl.ufro.prava.backend.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public JWTAuthenticationFilter(AuthenticationManager authManager) {

        super(new AntPathRequestMatcher(LOGIN_URL));

        setAuthenticationManager(authManager);

    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws AuthenticationException {
        
        try {

            Usuario                                 user        = this.mapper.readValue(request.getInputStream(), Usuario.class);
            UsernamePasswordAuthenticationToken     authToken   = new UsernamePasswordAuthenticationToken(
                    user.getNombre(),
                    user.getPassword(),
                    new ArrayList<>()
            );

            return getAuthenticationManager().authenticate( authToken );

        } catch (IOException e) {
            
            throw new BadCredentialsException( e.getMessage() );
            
        }
        
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication auth
    ) throws IOException, ServletException {
        
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth.getPrincipal();

        if ( user != null ) {
            
            String jwtToken = Jwts.builder()
                    .setSubject( user.getUsername() )
                    .setExpiration( new Date(System.currentTimeMillis() + EXPIRATION_TIME) )
                    .signWith( SignatureAlgorithm.HS512, SECRET )
                    .compact();

            String token = TOKEN_PREFIX + jwtToken;
            JWTResponse jwtResponse = new JWTResponseToken(token, this.userDetailsService.getUserByUsername(user.getUsername()));

            response.addHeader(HEADER_STRING, token);
            response.setContentType("application/json");
            response.getWriter().write( this.mapper.writeValueAsString( jwtResponse ) );
            
        } else {
            
            JWTResponse jwtResponse = new JWTErrorResponse("invalid_credentials");
            
            response.setContentType("application/json");
            response.getWriter().write( this.mapper.writeValueAsString(jwtResponse) );
            
        }

    }
    
    @Override
    protected void unsuccessfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
        ) {
        
        try {
            
            JWTResponse jwtResponse = new JWTErrorResponse("invalid_credentials");
            
            response.setContentType("application/json");
            response.getWriter().write( this.mapper.writeValueAsString(jwtResponse) );
            
        } catch ( IOException e ) {
            
            throw new RuntimeException(e);
            
        }
        
    }

}
