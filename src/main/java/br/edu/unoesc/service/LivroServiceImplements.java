package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImplements implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Override
    public void salvar(Livro dado) {
        this.repository.save(dado);
    }

    @Override
    public void excluir(Long dado) {
        this.repository.deleteById(dado);
    }

    @Override
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

    @Override
    public List<AutoCompleteDTO> pesquisaLivro(String keyword){
        return repository.pesquisaLivro(keyword);
    }

    @Override
    public List<Livro> livroByNome(String titulo){
        return repository.livroByNome(titulo);
    }

}
