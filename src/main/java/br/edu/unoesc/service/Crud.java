package br.edu.unoesc.service;

import java.util.List;

public interface Crud <T> {

    void salvar(T dado);

    void excluir(Long dadoId);

    List listar();

}
