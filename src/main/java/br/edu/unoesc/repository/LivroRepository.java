package br.edu.unoesc.repository;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro getById(Long id);

    @Query("SELECT l.id as id, l.titulo as label FROM Livro l where titulo like %:keyword%")
    public List<AutoCompleteDTO> pesquisaLivro(@Param("keyword") String keyword);

    @Query("Select l.quantidade from Livro l where id = :id")
    public Integer quantidadeDoLivro(@Param("id") Long id);

    @Query("SELECT l FROM Livro l where l.titulo like ?1%")
    List<Livro> livroByNome(String titulo);
}
