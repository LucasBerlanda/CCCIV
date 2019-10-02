package br.edu.unoesc.controller;

import br.edu.unoesc.model.Retirada;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("retirada")
public class RetiradaController {

    @Autowired
    private RetiradaService retiradaService;

    @Autowired
    private LivroService livroService;

    @Autowired
    private PessoaService pessoaService;

    public String caregar(Model model){
        model.addAttribute("list", livroService.listar());
        model.addAttribute("listPessoa", pessoaService.listar());
        return "retirada/cadastrar";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        return caregar(model);
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, Retirada retirada){
        retirada.setData(LocalDate.now());
        retiradaService.salvar(retirada);
        return caregar(model);
    }

}
