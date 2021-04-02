package br.edu.unoesc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}
/**
 * 
 * senha de 1 até 9
 *
 * grupos de 3
 * mini-biblioteca:
 * cadastro de exemplares
 * cadastro de pessoas
 * retiradas e devoluções de exemplares por pessoas
 * saldo de exemplares - nao deixar retirar livro que nao tem disponibilidade
 * lista de exemplares emprestados
 * // como desativar o open session in view no application properties
 */