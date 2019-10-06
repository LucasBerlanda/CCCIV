package br.edu.unoesc.repository;

import br.edu.unoesc.model.Retirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

    @Query(value = "Select sum(r.quantidade) from Retirada r where pessoa_id = :pessoa_id && livro_id = :livro_id", nativeQuery = true)
    public Integer temQuantidade(@Param("pessoa_id") Long id, @Param("livro_id") Long idLivro);

}