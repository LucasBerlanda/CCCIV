package br.edu.unoesc.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Devolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;

    @NotNull(message = "A pessoa é obrigatória!")
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @NotNull(message = "O livro é obrigatório!")
    @ManyToOne
    @JoinColumn(name = "livro_id")
    private Livro livro;

    @NotNull(message = "A quantidade é obrigatória!")
    @Min(value = 1, message = "A quantidade é inválida")
    private Integer quantidade;

    public Devolucao() {
    }

    public Devolucao(Long id, LocalDate data, Pessoa pessoa, Livro livro, Integer quantidade) {
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
