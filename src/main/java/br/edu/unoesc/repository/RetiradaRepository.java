package br.edu.unoesc.repository;

import br.edu.unoesc.model.Retirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

    @Query(value = "Select sum(r.quantidade) from Retirada r where pessoa_id = :pessoa_id && livro_id = :livro_id", nativeQuery = true)
    public Integer temQuantidade(@Param("pessoa_id") Long id, @Param("livro_id") Long idLivro);

    @Query(value ="SELECT * FROM Retirada r where r.livro_id = :idLivro and r.pessoa_id = :idPessoa and r.quantidade >= :qtd ORDER BY r.id LIMIT 1", nativeQuery = true)
    public Retirada retiradaPorID(@Param("idLivro") Long idLivro, @Param("idPessoa") Long idPessoa, @Param("qtd") Integer qtd);

    @Query("SELECT r FROM Retirada r where r.quantidade > 0")
    public List<Object> livrosEmprestados();

    @Query(value = "SELECT * FROM Retirada r where r.livro_id = :id and r.quantidade > 0 ORDER BY r.livro_id LIMIT 1", nativeQuery = true)
    public List<Retirada> buscaLivroEmprestadoParaExcluir(@Param("id") Long id);

    @Query(value = "SELECT * FROM Retirada r where r.pessoa_id = :id and r.quantidade > 0 ORDER BY r.livro_id LIMIT 1", nativeQuery = true)
    public List<Retirada> buscaLivroEmprestadoParaExcluirPessoa(@Param("id") Long id);

    @Query("SELECT r from Retirada r where r.quantidade > 0 and r.pessoa.nome like ?1%")
    public List<Retirada> livrosEmprestadosByCliente(String nome);

    @Query("SELECT r from Retirada r where r.quantidade > 0 and r.livro.titulo like ?1%")
    public List<Retirada> livrosEmprestadosByLivro(String titulo);
}