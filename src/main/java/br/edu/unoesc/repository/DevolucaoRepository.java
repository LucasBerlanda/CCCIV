package br.edu.unoesc.repository;

import br.edu.unoesc.model.Devolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {

}
