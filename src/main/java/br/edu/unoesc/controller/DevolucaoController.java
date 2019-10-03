package br.edu.unoesc.controller;

import br.edu.unoesc.model.Devolucao;
import br.edu.unoesc.service.DevolucaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("devolucao")
public class DevolucaoController {

    @Autowired
    private DevolucaoService devolucaoService;

    public String caregar(Model model){
        return "devolucao/cadastrar";
    }

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        return caregar(model);
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, Devolucao devolucao){
        devolucaoService.salvar(devolucao);
        return caregar(model);
    }

}
