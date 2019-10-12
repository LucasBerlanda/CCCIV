package br.edu.unoesc.service;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.RetiradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RetiradaServiceImplements implements RetiradaService {

    @Autowired
    private RetiradaRepository repository;

    @Override
    @Transactional
    public void salvar(Retirada dado) {
        try {
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

    @Override
    @Transactional
    public Integer temQuantidade(Long idPessoa, Long idLivro) {
        Integer quantidade = 0;
        quantidade = repository.temQuantidade(idPessoa, idLivro);
        return quantidade;
    }

    @Override
    @Transactional
    public Retirada devolverLivroDaRetirada(Long idLivro, Long idPessoa ,Integer qtd) {
        Retirada retirada = repository.retiradaPorID(idLivro, idPessoa, qtd);

        try {
            Integer qtdAtual = retirada.getQuantidade();
            retirada.setQuantidade(qtdAtual - qtd);
            repository.save(retirada);
        }catch (Exception e){
            e.printStackTrace();
        }
        return retirada;
    }

    @Override
    @Transactional
    public List<Object> livrosEmprestados() {
        return repository.livrosEmprestados();
    }

    @Override
    @Transactional
    public List<Retirada> livrosEmprestadosByCliente(String nome) {
        return repository.livrosEmprestadosByCliente(nome);
    }

    @Override
    @Transactional
    public List<Retirada> livrosEmprestadosByLivro(String titulo) {
        return repository.livrosEmprestadosByLivro(titulo);
    }

}
