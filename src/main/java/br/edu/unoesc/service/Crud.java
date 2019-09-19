package br.edu.unoesc.service;

public interface Crud <T> {

    boolean salvar(T dado);

    boolean excluir(T dado);

}
