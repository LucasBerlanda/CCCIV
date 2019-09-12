package br.edu.unoesc.service;

import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService implements  Crud<Pessoa>{

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public boolean salvar(Pessoa dado){
        pessoaRepository.save(dado);
        return true;
    }

    @Override
    public boolean excluir(Pessoa dado){
        pessoaRepository.delete(dado);
        return true;
    }
    @Override
    public List<Pessoa> listar(){
        return pessoaRepository.findAll();
    }
}
