package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import org.springframework.stereotype.Service;
import br.edu.unoesc.model.Pessoa;

import java.util.List;

@Service
public interface PessoaService extends Crud<Pessoa> {

    public List<AutoCompleteDTO> pesquisaCliente(String keyword);

    public List<Pessoa> pessoaByNome(String nomePessoa);

    Integer quantidade();

    public Pessoa getById(Long id);

}