package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaServiceImplements implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    @Transactional
    public void salvar(Pessoa dado) {
        repository.save(dado);
    }

    @Override
    @Transactional
    public void excluir(Long dado) {
        repository.deleteById(dado);

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List listar() {
        return this.repository.findAll();
    }


    @Override
    public Integer quantidade() {
        Integer qtd = 0;
        List<Pessoa> pessoas = this.repository.findAll();
        qtd = pessoas.size();
        System.out.println(qtd);
        return qtd;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<AutoCompleteDTO> pesquisaCliente(String keyword){
        return repository.pesquisaCliente(keyword);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Pessoa> pessoaByNome(String nomePessoa){
        return repository.pessoaByNome(nomePessoa);
    }

    public Pessoa getById(Long id){
        return repository.getById(id);
    }

}
