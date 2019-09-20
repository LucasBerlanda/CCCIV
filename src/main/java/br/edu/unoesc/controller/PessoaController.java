package br.edu.unoesc.controller;

import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.unoesc.model.Pessoa;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/cadastro")
    public String cadastro(){
        return "pessoa/cadastrar";
    }

    @PostMapping("/pessoa/cadastro")
    public String cadastro(Model model, Pessoa pessoa) {
        pessoaService.salvar(pessoa);
        return "pessoa/cadastrar";
    }

}