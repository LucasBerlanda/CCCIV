package br.edu.unoesc.service;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class RetiradaServiceImplements implements RetiradaService {

    @Autowired
    private RetiradaRepository repository;

    @Override
    public void salvar(Retirada dado) {
        repository.save(dado);
    }

    @Override
    public void excluir(Long dadoId) {
        repository.deleteById(dadoId);
    }

    @Override
    public List listar() {
        return this.repository.findAll();
    }

    @Override
    public Integer temQuantidade(Long id) {
        Integer quantidade = 0;
        quantidade = repository.temQuantidade(id);
        return quantidade;
    }
}
