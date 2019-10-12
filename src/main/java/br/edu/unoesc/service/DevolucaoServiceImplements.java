package br.edu.unoesc.service;

import br.edu.unoesc.model.Devolucao;
import br.edu.unoesc.repository.DevolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class DevolucaoServiceImplements implements DevolucaoService {

    @Autowired
    private DevolucaoRepository repository;

    @Override
    @Transactional
    public void salvar(Devolucao dado) {
        try {
            dado.setData(LocalDate.now());
            repository.save(dado);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void excluir(Long dadoId) {
        repository.deleteById(dadoId);
    }

    @Override
    public List listar() {
        return this.repository.findAll();
    }

}
