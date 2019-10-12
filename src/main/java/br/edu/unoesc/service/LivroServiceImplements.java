package br.edu.unoesc.service;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.LivroRepository;
import br.edu.unoesc.repository.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivroServiceImplements implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    RetiradaRepository retiradaRepository;

    @Override
    @Transactional
    public void salvar(Livro dado) {
        try {
            this.repository.save(dado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void excluir(Long dado) {
        List <Retirada> livroRetirada = retiradaRepository.buscaLivroEmprestadoParaExcluir(dado);
        try {
            if (livroRetirada.size() == 0){
                this.repository.deleteById(dado);
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
    @Transactional
    public Livro retirarLivro(Livro dado, Integer qtd) {
        try {
            Integer qtdAtual = dado.getQuantidade();
            dado.setQuantidade(qtdAtual - qtd);
            repository.save(dado);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dado;
    }

    @Override
    @Transactional
    public Livro devolverLivro(Livro dado, Integer qtd) {
        try {
            Integer qtdAtual = dado.getQuantidade();
            dado.setQuantidade(qtdAtual + qtd);
            repository.save(dado);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dado;
    }

    public Livro getById(Long id) {
        return repository.getById(id);
    }

    //busca os livros disponíveis
    @Override
    @Transactional
    public List<Livro> buscaLivrosDisponiveis() {
        return repository.livrosDisponiveis();
    }
    //busca os livros disponíveis por titulo
    @Transactional
    public List<Livro> livrosDisponiveisByTitulo(String titulo){
        return repository.livrosDisponiveisByTitulo(titulo);
    }

    @Override
    @Transactional
    public List<AutoCompleteDTO> pesquisaLivro(String keyword){
        return repository.pesquisaLivro(keyword);
    }

    //busca livros por titulo
    @Override
    @Transactional
    public List<Livro> livroByNome(String titulo){
        return repository.livroByNome(titulo);
    }

}
