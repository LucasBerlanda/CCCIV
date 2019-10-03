package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LivroService extends Crud<Livro> {

    public List<AutoCompleteDTO> pesquisaLivro(String keyword);

    Integer quantidade();

}

