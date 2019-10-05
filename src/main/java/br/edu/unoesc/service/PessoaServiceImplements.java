package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImplements implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Override
    public void salvar(Pessoa dado) {
        repository.save(dado);
    }

    @Override
    public void excluir(Long dado) {
        repository.deleteById(dado);

    }

    @Override
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
    public List<AutoCompleteDTO> pesquisaCliente(String keyword){
        return repository.pesquisaCliente(keyword);
    }

    @Override
    public List<Pessoa> pessoaByNome(String nomePessoa){
        return repository.pessoaByNome(nomePessoa);
    }

}
