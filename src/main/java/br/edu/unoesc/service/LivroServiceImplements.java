package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroServiceImplements implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Override
    @Transactional
    public void salvar(Livro dado) {
        this.repository.save(dado);
    }

    @Override
    @Transactional
    public void excluir(Long dado) {
        this.repository.deleteById(dado);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List listar() {
        return this.repository.findAll();
    }

    @Override
    public Integer quantidade() {
        Integer qtd = 0;
        List<Livro> livros = this.repository.findAll();
        qtd = livros.size();

        return qtd;
    }

    @Override
    public Integer validadeQuantidade(Long id) {
        Integer quantidade = 0;
        quantidade = repository.quantidadeDoLivro(id);
        return quantidade;
    }

    @Override
    public Integer quantidadeTotal() {
        return repository.quantidadeTotal();
    }

    @Override
    public Livro retirarLivro(Livro dado, Integer qtd) {
        Integer qtdAtual = dado.getQuantidade();
        dado.setQuantidade(qtdAtual - qtd);
        repository.save(dado);
        return dado;
    }

    @Override
    public Livro devolverLivro(Livro dado, Integer qtd) {
        Integer qtdAtual = dado.getQuantidade();
        dado.setQuantidade(qtdAtual + qtd);
        repository.save(dado);
        return dado;
    }

    public Livro getById(Long id) {
        return repository.getById(id);
    }

    //busca os livros disponíveis
    @Override
    public List<Livro> buscaLivrosDisponiveis() {
        return repository.livrosDisponiveis();
    }
    //busca os livros disponíveis por titulo
    public List<Livro> livrosDisponiveisByTitulo(String titulo){
        return repository.livrosDisponiveisByTitulo(titulo);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<AutoCompleteDTO> pesquisaLivro(String keyword){
        return repository.pesquisaLivro(keyword);
    }

    //busca livros por titulo
    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Livro> livroByNome(String titulo){
        return repository.livroByNome(titulo);
    }

}
