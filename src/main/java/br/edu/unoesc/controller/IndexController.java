package br.edu.unoesc.controller;

import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


//spring.resources.static-locations=classpath:/custom/
@Controller
public class IndexController{

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private LivroService livroService;
  
    
    
    @GetMapping("/")
    public String index(Model model){
    	
    	model.addAttribute("pessoasCadastradas", pessoaService.quantidade());
        model.addAttribute("livrosCadastradas", livroService.quantidade());
        model.addAttribute("quantidadeTotalLivros", livroService.quantidadeTotal());
        model.addAttribute("lista", livroService.buscaLivrosDisponiveis());
        
        return "index";
    }

}
/**
 * grupos de 3
 * mini-biblioteca:
 * cadastro de exemplares -> ok
 * cadastro de pessoas -> ok
 * retiradas e devoluções de exemplares por pessoas -> ok
 * saldo de exemplares - nao deixar retirar livro que nao tem disponibilidade -> ok
 * lista de exemplares emprestados -> ok
 * lista de livros disponíveis -> ok
 * arrumar validação de input no cadastro de devoluções -> ok
 * editar quantidade disponivel de livros ->
 * arrumar icone de qt de livros no dashboard -> ok

 * arrumar cadastro de usuário -> ok
 * arrumar login de usuário -> ok
 */