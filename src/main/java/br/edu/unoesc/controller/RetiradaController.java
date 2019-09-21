package br.edu.unoesc.controller;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.repository.LivroRepository;
import br.edu.unoesc.repository.PessoaRepository;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public String caregar(Model model){
        model.addAttribute("list", livroRepository.findAll());
        model.addAttribute("listPessoa", pessoaRepository.findAll());
        return "retirada/cadastrar";
    }

    @GetMapping("/retirada/cadastro")
    public String cadastro(Model model){
        return caregar(model);
    }

    @PostMapping("/retirada/cadastro")
    public String cadastro(Model model, Retirada retirada){
        retirada.setData(LocalDate.now());
        retiradaService.salvar(retirada);
        return caregar(model);
    }

}
