package br.edu.unoesc.controller;

import br.edu.unoesc.model.Devolucao;
import br.edu.unoesc.service.DevolucaoService;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("devolucao")
public class DevolucaoController {

    @Autowired
    private DevolucaoService devolucaoService;

    private LivroService livroService;

    private RetiradaService retiradaService;

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        return "devolucao/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("devolucao") Devolucao devolucao, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("devolucao", devolucao);
            return "devolucao/cadastrar";
        }
        // id do livro selecionado na tela
        Long idLivro = devolucao.getLivro().getId();
        System.out.println(idLivro+" id do livro selecionado");
        System.out.println(devolucao.getQuantidade()+" quantidade digitada do livro");
        if(retiradaService.temQuantidade(idLivro)>= devolucao.getQuantidade()){
            devolucao.setData(LocalDate.now());
            devolucaoService.salvar(devolucao);
            livroService.devolverLivro(devolucao.getLivro(), devolucao.getQuantidade());
            return "devolucao/cadastrar";
        }
        else {
            System.out.println("voce nao tem essa quantidade de livros para devolver");
            return "devolucao/cadastrar";
        }
    }

}
