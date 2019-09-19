package br.edu.unoesc.service;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService implements Crud<Livro> {

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

}

