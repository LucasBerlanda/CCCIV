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

@Controller
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

    @Autowired
    private LivroService livroService;

//    public String caregar(Model model){
//        model.addAttribute("list", livroService.listar());
//        model.addAttribute("listPessoa", pessoaService.listar());
//        return "retirada/cadastrar";
//    }

    @GetMapping("/retirada/cadastro")
    public String cadastro(Model model){
        model.addAttribute("retirada", new Retirada());
        model.addAttribute("exemplar", new Livro());
        return "retirada/cadastrar";
    }

    @PostMapping("/retirada/cadastro")
    public String cadastro(@Valid @ModelAttribute("retirada") Retirada retirada,
                           BindingResult result, Model model){
       if(result.hasErrors()) {
           model.addAttribute("retirada", retirada);
//           model.addAttribute("cliente", retirada.getPessoa());
           model.addAttribute("exemplar", new Livro());
           return "retirada/cadastrar";
       }
        // id do livro selecionado na tela
       Long idLivro = retirada.getLivro().getId();
        if (livroService.validadeQuantidade(idLivro)>= retirada.getQuantidade()){
            retirada.setData(LocalDate.now());
            retiradaService.salvar(retirada);
            livroService.retirarLivro(retirada.getLivro(), retirada.getQuantidade());
            return "redirect:/";
        } else {
            // voltar para a tela mostrando o erro de quantidade invalida
            System.out.println("quantidade invalidade");
            return "retirada/cadastrar";
        }
    }

    @GetMapping("/retirada/alugar/{id}")
    public String alugar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("livro", new Livro());
        Livro livro = livroService.getById(id);
        System.out.println("alugar" + livro);
        model.addAttribute("exemplar", livroService.getById(id));
        model.addAttribute("retirada", new Retirada());
        return "retirada/cadastrar";
    }

}
