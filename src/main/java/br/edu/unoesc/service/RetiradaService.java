package br.edu.unoesc.service;

import br.edu.unoesc.model.Retirada;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RetiradaService extends Crud<Retirada> {

    Integer temQuantidade(Long idPessoa, Long idLivro);

    Retirada devolverLivroDaRetirada(Long idLivro, Long idPessoa ,Integer qtd);

    List<Object> livrosEmprestados();

    List<Retirada> livrosEmprestadosByCliente(String nome);

    List<Retirada> livrosEmprestadosByLivro(String titulo);

    Retirada retiradaIgualExistente(Long idLivro, Long idPessoa);

    Retirada alterarRetiradaIgualExistente(Long idLivro, Long idPessoa, Integer qtd);
}
