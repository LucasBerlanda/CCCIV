package br.edu.unoesc.controller;

import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("lista", livroService.buscaLivrosDisponiveis());
        return "index";
    }
}
/**
 * grupos de 3
 * mini-biblioteca:
 * cadastro de exemplares -> ok
 * cadastro de pessoas -> ok
 * retiradas e devoluções de exemplares por pessoas -> mais ou menos
 * saldo de exemplares - nao deixar retirar livro que nao tem disponibilidade -> quase
 * lista de exemplares emprestados
 * lista de livros disponíveis -> ok
 */