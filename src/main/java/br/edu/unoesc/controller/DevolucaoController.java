package br.edu.unoesc.controller;

import br.edu.unoesc.model.Devolucao;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Retirada;
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

    @Autowired
    private LivroService livroService;

    @Autowired
    private RetiradaService retiradaService;

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("devolucao", new Devolucao());
        model.addAttribute("exemplar", new Livro());
        return "devolucao/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("devolucao") Devolucao devolucao, BindingResult result, Model model) throws Exception{
        if (result.hasErrors()) {
            model.addAttribute("devolucao", devolucao);
            model.addAttribute("exemplar", new Livro());
            return "devolucao/cadastrar";
        }
        Long idLivro = devolucao.getLivro().getId();
        Long idPessoa = devolucao.getPessoa().getId();
        Integer qtLivrosEmprestados = retiradaService.temQuantidade(idPessoa, idLivro);
        Integer qtDevolucao = devolucao.getQuantidade();
        try {
            if ( qtLivrosEmprestados >= qtDevolucao) {
                devolucaoService.salvar(devolucao);
                livroService.devolverLivro(devolucao.getLivro(), qtDevolucao);
                retiradaService.devolverLivroDaRetirada(idLivro, idPessoa ,qtDevolucao);

                return "redirect:/";
            }
        } catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("erro", "Não foi possível fazer a devolução!");
        }
        return "devolucao/cadastrar";
    }
}
