package br.edu.unoesc.service;

import br.edu.unoesc.model.Livro;
import org.springframework.stereotype.Service;

@Service
public interface LivroService extends Crud<Livro> {

    Integer quantidade();

}

