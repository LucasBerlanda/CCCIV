package br.edu.unoesc.controller;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.LivroRepository;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping("/retirada/cadastro")
    public String cadastro(Model model){
        model.addAttribute("list", livroRepository.findAll());
        return "retirada/cadastrar";
    }

    @PostMapping("/retirada/cadastro")
    public String cadastro(Model model, Retirada retirada){
        retiradaService.salvar(retirada);
        return "retirada/cadastrar";
    }

}
