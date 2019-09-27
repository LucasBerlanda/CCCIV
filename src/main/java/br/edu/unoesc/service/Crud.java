package br.edu.unoesc.service;

import java.util.List;

public interface Crud <T> {

    boolean salvar(T dado);

    boolean excluir(T dado);

    List listar();

}
