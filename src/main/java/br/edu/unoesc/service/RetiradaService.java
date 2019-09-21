package br.edu.unoesc.service;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetiradaService implements Crud<Retirada> {

    @Autowired
    private RetiradaRepository repository;

    @Override
    public boolean salvar(Retirada dado) {
        repository.save(dado);
        return false;
    }

    @Override
    public boolean excluir(Retirada dado) {
        repository.delete(dado);
        return false;
    }
}
