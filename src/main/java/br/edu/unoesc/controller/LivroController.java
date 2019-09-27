package br.edu.unoesc.controller;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/livro/cadastro")
    public String cadastro() {
        return "livro/cadastrar";
    }

    @PostMapping("/livro/cadastro")
    public String cadastro(Model model, Livro livro) {
        this.livroService.salvar(livro);
        return "livro/cadastrar";
    }


}
