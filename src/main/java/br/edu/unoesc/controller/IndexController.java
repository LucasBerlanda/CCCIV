package br.edu.unoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController{
    //spring.resources.static-locations=classpath:/custom/

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
/**
 * grupos de 3
 * mini-biblioteca:
 * cadastro de exemplares
 * cadastro de pessoas
 * retiradas e devoluções de exemplares por pessoas
 * saldo de exemplares - nao deixar retirar livro que nao tem disponibilidade
 * lista de exemplares emprestados
 */