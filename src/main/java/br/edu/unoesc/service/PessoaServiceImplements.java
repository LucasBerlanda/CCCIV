package br.edu.unoesc.service;

import br.edu.unoesc.dto.AutoCompleteDTO;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.PessoaRepository;
import br.edu.unoesc.repository.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaServiceImplements implements PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private RetiradaRepository retiradaRepository;

    @Override
    @Transactional
    public void salvar(Pessoa dado) {
        repository.save(dado);
    }

    @Override
    @Transactional
    public void excluir(Long dado) {
        List <Retirada> pessoaRetirada = retiradaRepository.buscaLivroEmprestadoParaExcluirPessoa(dado);
        try {
            if (pessoaRetirada.size() == 0) {
                repository.deleteById(dado);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public List listar() {
        return this.repository.findAll();
    }


    @Override
    public Integer quantidade() {
        Integer qtd = 0;
        List<Pessoa> pessoas = this.repository.findAll();
        qtd = pessoas.size();
        return qtd;
    }

    @Override
    @Transactional
    public List<AutoCompleteDTO> pesquisaCliente(String keyword){
        return repository.pesquisaCliente(keyword);
    }

    @Override
    @Transactional
    public List<Pessoa> pessoaByNome(String nomePessoa){
        return repository.pessoaByNome(nomePessoa);
    }

    public Pessoa getById(Long id){
        return repository.getById(id);
    }

}
