package br.edu.unoesc.controller;

import br.edu.unoesc.model.Pessoa;
import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/cadastro")
    public String cadastro(){
        return "pessoa/cadastro";
    }

    @PostMapping("/pessoa/cadastro")
    public String cadastro(Pessoa pessoa, Model model){
        pessoaService.salvar(pessoa);
        return "pessoa/cadastro";
    }

}
