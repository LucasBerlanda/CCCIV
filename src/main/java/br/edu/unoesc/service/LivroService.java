package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface LivroService extends Crud<Livro> {

    public List<AutoCompleteDTO> pesquisaLivro(String keyword);

    public List<Livro> livroByNome(String titulo);

    Integer quantidade();

    Integer validadeQuantidade(Long id);

    Integer quantidadeTotal();

    Livro retirarLivro(Livro dado, Integer qtd);

    Livro devolverLivro(Livro dado, Integer qtd);

    Livro getById(Long id);

    public List<Livro> buscaLivrosDisponiveis();

    public List<Livro> livrosDisponiveisByTitulo(String titulo);

}

