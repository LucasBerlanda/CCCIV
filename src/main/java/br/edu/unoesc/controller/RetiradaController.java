package br.edu.unoesc.controller;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

    @Autowired
    private LivroService livroService;

    @GetMapping("/retirada/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("retirada", new Retirada());
        model.addAttribute("exemplar", new Livro());
        return "retirada/cadastrar";
    }

    @PostMapping("/retirada/cadastro")
    public String cadastro(@Valid @ModelAttribute("retirada") Retirada retirada,
                           BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("retirada", retirada);
            model.addAttribute("exemplar", new Livro());
            return "retirada/cadastrar";
        }
        try {
            Long idLivro = retirada.getLivro().getId(); // id do livro selecionado na tela
            if (livroService.validadeQuantidade(idLivro) >= retirada.getQuantidade()) {
                retiradaService.salvar(retirada);
                livroService.retirarLivro(retirada.getLivro(), retirada.getQuantidade());
                return "redirect:/";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/retirada/cadastro";
    }

    @GetMapping("/retirada/alugar/{id}")
    public String alugar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("livro", new Livro());
        Livro livro = livroService.getById(id);
        model.addAttribute("exemplar", livroService.getById(id));
        model.addAttribute("retirada", new Retirada());
        return "retirada/cadastrar";
    }

}
