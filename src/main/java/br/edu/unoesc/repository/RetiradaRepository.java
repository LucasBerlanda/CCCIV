package br.edu.unoesc.repository;

import br.edu.unoesc.model.Retirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

    @Query("Select sum(r.quantidade) from Retirada r where r.pessoa.id = :pessoa_id and r.livro.id = :livro_id")
    public Integer temQuantidade(@Param("pessoa_id") Long id, @Param("livro_id") Long idLivro);

    @Query("SELECT R FROM Retirada R where R.id = :id")
    public Retirada retiradaPorID(@Param("id") Long id);

    @Query("SELECT r FROM Retirada r where r.quantidade > 0")
    public List<Object> livrosEmprestados();

    @Query("SELECT r from Retirada r where r.quantidade > 0 and r.pessoa.nome like ?1%")
    public List<Retirada> livrosEmprestadosByCliente(String nome);

    @Query("SELECT r from Retirada r where r.quantidade > 0 and r.livro.titulo like ?1%")
    public List<Retirada> livrosEmprestadosByLivro(String titulo);
}