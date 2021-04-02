package br.edu.unoesc.service;

import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void salvar(Usuario dado) {
        dado.setSenha(passwordEncoder.encode(dado.getSenha()));
        repository.save(dado);
    }

    @Override
    public void excluir(Long dadoId) {
        repository.deleteById(dadoId);
    }

    @Override
    public List listar() {
        return repository.findAll();
    }

	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getUsuarioLogado() {
		Authentication user = SecurityContextHolder.getContext().getAuthentication();
		Usuario userDetails = (Usuario) user.getPrincipal();
		return userDetails;
	}
}
