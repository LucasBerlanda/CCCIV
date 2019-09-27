package br.edu.unoesc.repository;

import br.edu.unoesc.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// como desativar o open session in view no application properties
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}