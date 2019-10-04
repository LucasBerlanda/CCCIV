package br.edu.unoesc.controller;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/retirada")
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

//    public String caregar(Model model){
//        model.addAttribute("list", livroService.listar());
//        model.addAttribute("listPessoa", pessoaService.listar());
//        return "retirada/cadastrar";
//    }

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("retirada", new Retirada());
        return "retirada/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("retirada") Retirada retirada,
                           BindingResult result, Model model){
       if(result.hasErrors()){
           model.addAttribute("retirada", retirada);
           model.addAttribute("cliente", retirada.getPessoa());
           model.addAttribute("exemplar", retirada.getLivro());
           return "retirada/cadastrar";
       }
        retirada.setData(LocalDate.now());
        retiradaService.salvar(retirada);
        return "retirada/cadastrar";
    }

}
