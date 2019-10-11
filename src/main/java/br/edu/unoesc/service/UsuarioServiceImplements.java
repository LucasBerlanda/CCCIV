package br.edu.unoesc.service;

import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void salvar(Usuario dado) {
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
}
