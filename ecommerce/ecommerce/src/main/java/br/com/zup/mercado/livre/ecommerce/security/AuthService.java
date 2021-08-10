package br.com.zup.mercado.livre.ecommerce.security;

import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioModel;
import br.com.zup.mercado.livre.ecommerce.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = usuarioRepository.findByLogin(username);
        if(usuario.isPresent()) return usuario.get();

        throw new UsernameNotFoundException("Dados inválidos");
    }
}
