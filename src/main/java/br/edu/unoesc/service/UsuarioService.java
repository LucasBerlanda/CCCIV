package br.edu.unoesc.service;




import br.edu.unoesc.model.Usuario;

public interface UsuarioService extends Crud<Usuario> {

	Usuario getById(Long id);
	
	Usuario getUsuarioLogado();
}
