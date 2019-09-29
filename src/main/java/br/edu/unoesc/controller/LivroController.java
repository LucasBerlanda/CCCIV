package br.edu.unoesc.controller;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/livro/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livro/cadastrar";
    }

    @PostMapping("/livro/cadastro")
    public String cadastro(@Valid @ModelAttribute("livro") Livro livro, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("livro", livro);
            return "livro/cadastrar";
        }
        this.livroService.salvar(livro);
        return "livro/cadastrar";
    }
    @GetMapping("/livro/lista")
    public String lista(Model model) {
        List<Livro> livros = livroService.listar();
        model.addAttribute("lista", livros);
        return "livro/lista";
    }


}
