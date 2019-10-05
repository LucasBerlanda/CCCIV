package br.edu.unoesc.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty(message = "O nome é obrigatório!")
    @Size(max = 60, message = "O nome deve ser menor!")
    @Column(name="nome", nullable=false)
    private String nome;

    @NotNull
    @NotEmpty(message = "O sobrenome é obrigatório!")
    @Size(max = 60, message = "O sobrenome deve ser menor!")
    @Column(name="sobrenome", nullable=false)
    private String sobrenome;

    @NotNull
    @NotEmpty(message = "O CPF é obrigatório!")
    @CPF(message = "Esse CPF é inválido!")
    @Column(name="cpf", nullable=false)
    private String cpf;

    @NotNull
    @Email( message = "O e-mail é inválido!")
    @Size(min = 1, message = "E-mail inválido!")
    @Column(name="email", nullable=false)
    private String email;

    @NotNull
    @Size(min = 1, max = 11, message = "O telefone é inválido!")
    @Column(name="telefone", nullable=false)
    private String telefone;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Pessoa(Long id, String nome, String sobrenome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.telefone = telefone;
    }

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
