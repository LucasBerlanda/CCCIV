package br.edu.unoesc.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Retirada")
public class Retirada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    @NotNull(message = "A pessoa é obrigatória!")
    @ManyToOne
    private Pessoa pessoa;

    @NotNull(message = "O livro é obrigatório!")
    @ManyToOne
    private Livro livro;

    @NotNull(message = "A quantidade é obrigatória!")
    @Min(value = 1, message = "A quantidade é inválida")
    private Integer quantidade;

    /**
     * A FAZER>>>
     * falta fazer a quantidade da retirada aqui
     * fazer os joins com as anotações @JoinColunm(name=" name_id")
     * fazer no @ManyToOne o (feth = FetchType.LAZY)
     * se precisar fazer o toString
     * **/

    public Retirada() {

    }

    public Retirada(Long id, LocalDate data, Pessoa pessoa, Livro livro, Integer quantidade) {
        this.id = id;
        this.data = data;
        this.pessoa = pessoa;
        this.livro = livro;
        this.quantidade = quantidade;
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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
