package br.edu.unoesc.repository;

import br.edu.unoesc.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByCpf(String cpf);
}
