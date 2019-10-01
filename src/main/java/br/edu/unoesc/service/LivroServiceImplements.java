package br.edu.unoesc.service;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroServiceImplements implements LivroService {

    @Autowired
    private LivroRepository repository;

    @Override
    public boolean salvar(Livro dado) {
        this.repository.save(dado);
        return true;
    }

    @Override
    public boolean excluir(Livro dado) {
        this.repository.delete(dado);
        return true;
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

}
