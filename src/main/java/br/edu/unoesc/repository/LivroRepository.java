package br.edu.unoesc.repository;

import br.edu.unoesc.dto.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro getById(Long id);

    @Query("SELECT l.id as id, l.titulo as label FROM Livro l where titulo like %:keyword% and l.quantidade > 0")
    public List<AutoCompleteDTO> pesquisaLivro(@Param("keyword") String keyword);

    @Query("SELECT l.id as id, l.titulo as label FROM Livro l where titulo like %:keyword%")
    public List<AutoCompleteDTO> pesquisaLivroDevolucao(@Param("keyword") String keyword);

    @Query("Select l.quantidade from Livro l where l.id = :id")
    public Integer quantidadeDoLivro(@Param("id") Long id);

    @Query("SELECT l FROM Livro l where l.titulo like ?1%")
    List<Livro> livroByNome(String titulo);

    @Query("SELECT l from Livro l where l.quantidade >= 1")
    public List<Livro> livrosDisponiveis();

    @Query("SELECT l from Livro l where l.quantidade >= 1 and l.titulo like ?1%")
    public List<Livro> livrosDisponiveisByTitulo(String titulo);

    @Query("SELECT SUM(l.quantidade) from Livro l")
    public Integer quantidadeTotal();
}
