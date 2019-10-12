package br.edu.unoesc.service;

import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBancoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario usuario = repository.findByCpf(s);
        if(usuario.getId()>0){
            UsuarioImplements usuarioImplements = new UsuarioImplements(usuario);
            return usuarioImplements;
        }
        else {
            throw new UsernameNotFoundException("Veio sem usuario");
        }
    }
}
