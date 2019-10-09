package br.edu.unoesc.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "O título é obrigatório!")
    @Size(max = 60, message = "O título deve ser menor!")
    @Column(name="titulo", nullable=false)
    private String titulo;

    @NotNull
    @NotEmpty(message = "O autor é obrigatório!")
    @Size(max = 60, message = "O autor deve ser menor!")
    @Column(name="autores", nullable=false)
    private String autores;

    @NotNull
    @NotEmpty(message = "O genero é obrigatório!")
    @Size(max = 60, message = "O genero deve ser menor!")
    @Column(name="genero", nullable=false)
    private String genero;

    @NotNull
    @NotEmpty(message = "A editora é obrigatória!")
    @Size(max = 60, message = "A editora deve ser menor!")
    @Column(name="editora", nullable=false)
    private String editora;

    @NotNull(message = "Ano de publicação é obrigatório!")
    @Column(name="anoPublicacao", nullable=false)
    private Integer anoPublicacao;

    @NotNull(message = "A quantidade é obrigatória!")
    @Min(value = 0, message = "A quantidade é inválida")
    private Integer quantidade;

    public Livro() {

    }

    public Livro(Long id, String titulo, String autores, String genero, String editora, Integer anoPublicacao, Integer quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                '}';
    }
}
