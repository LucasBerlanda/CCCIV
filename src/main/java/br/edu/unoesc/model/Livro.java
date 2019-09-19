package br.edu.unoesc.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String titulo;

    @OneToMany
    private List<Autor> autores;

    private String genero;

    private String editora;

    private Integer anoPublicacao;

    public Livro() {

    }

    public Livro(Long id, String titulo, List<Autor> autores, String genero, String editora, Integer anoPublicacao) {
        Id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
