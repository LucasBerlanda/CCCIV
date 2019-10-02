package br.edu.unoesc.repository;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// como desativar o open session in view no application properties
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT p.id as id, p.nome as label FROM Pessoa p where nome like %:keyword%")
    public List<AutoCompleteDTO> pesquisa(@Param("keyword") String keyword);

}