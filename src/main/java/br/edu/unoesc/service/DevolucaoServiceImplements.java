package br.edu.unoesc.service;

import br.edu.unoesc.model.Devolucao;
import br.edu.unoesc.repository.DevolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevolucaoServiceImplements implements DevolucaoService {

    @Autowired
    private DevolucaoRepository repository;

    @Override
    public void salvar(Devolucao dado) {
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

}
