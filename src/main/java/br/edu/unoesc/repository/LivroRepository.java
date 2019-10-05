package br.edu.unoesc.repository;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l.id as id, l.titulo as label FROM Livro l where titulo like %:keyword%")
    public List<AutoCompleteDTO> pesquisaLivro(@Param("keyword") String keyword);

    @Query("SELECT l FROM Livro l where l.titulo like ?1%")
    List<Livro> livroByNome(String titulo);
}
