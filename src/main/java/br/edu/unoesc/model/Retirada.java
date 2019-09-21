package br.edu.unoesc.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Retirada")
public class Retirada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate data;

    @ManyToOne
    private Pessoa pessoa;

    @ManyToOne
    private Livro livro;

    public Retirada() {

    }

    public Retirada(Long id, LocalDate data, Pessoa pessoa, Livro livro) {
        this.id = id;
        this.data = data;
        this.pessoa = pessoa;
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
