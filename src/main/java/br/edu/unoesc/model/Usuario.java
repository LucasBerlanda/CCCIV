package br.edu.unoesc.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="Usuario")
public class Usuario {

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
    @Column(name="cpf", unique = true)
    private String cpf;

    @NotNull
    @Size(min = 1, max = 11, message = "O telefone é inválido!")
    @Column(name="telefone", nullable=false)
    private String telefone;

    @NotNull
    @Size(min = 6, message = "Senha muito curta")
    @Column(name = "senha", nullable = false)
    private String senha;

    public Usuario(Long id, @NotNull @NotEmpty(message = "O nome é obrigatório!") @Size(max = 60, message = "O nome deve ser menor!") String nome, @NotNull @NotEmpty(message = "O sobrenome é obrigatório!") @Size(max = 60, message = "O sobrenome deve ser menor!") String sobrenome, @NotNull @NotEmpty(message = "O CPF é obrigatório!") @CPF(message = "Esse CPF é inválido!") String cpf, @NotNull @Size(min = 1, max = 11, message = "O telefone é inválido!") String telefone, @NotNull @Size(min = 6, message = "Senha muito curta") String senha) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.senha = senha;
    }

    public Usuario() {

    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
