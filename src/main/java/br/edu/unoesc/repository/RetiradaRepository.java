package br.edu.unoesc.repository;

import br.edu.unoesc.model.Retirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RetiradaRepository extends JpaRepository<Retirada, Long> {

    @Query("Select r.quantidade from Retirada r where id = :id")
    public Integer temQuantidade(@Param("id") Long id);

}