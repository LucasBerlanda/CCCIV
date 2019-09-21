package br.edu.unoesc.repository;

import br.edu.unoesc.model.Retirada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiradaRepository extends JpaRepository<Retirada, Long> {
    Retirada findByid(Long id);
}