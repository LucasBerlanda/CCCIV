package br.edu.unoesc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.repository.PessoaRepository;

@Service
public class PessoaService implements Crud<Pessoa> {

    @Autowired
    private PessoaRepository repository;

    @Override
    public boolean salvar(Pessoa dado) {
        repository.save(dado);
        return true;
    }

    @Override
    public boolean excluir(Pessoa dado) {
        repository.delete(dado);
        return true;
    }
}