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

    @Autowired
    private LivroService livroService;

    @Autowired
    private RetiradaService retiradaService;

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        return "devolucao/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("devolucao") Devolucao devolucao, BindingResult result, Model model) throws Exception{
        if (result.hasErrors()) {
            model.addAttribute("devolucao", devolucao);
            return "devolucao/cadastrar";
        }
        // id do livro selecionado na tela
        Long idLivro = devolucao.getLivro().getId();
        Long idPessoa = devolucao.getPessoa().getId();
//        if(retiradaService.temQuantidade(idPessoa, idLivro)>= devolucao.getQuantidade()){
//            devolucao.setData(LocalDate.now());
//            devolucaoService.salvar(devolucao);
//            livroService.devolverLivro(devolucao.getLivro(), devolucao.getQuantidade());
//            return "devolucao/cadastrar";
//        }
//        else {
//            // voltar para a tela mostrando o erro de quantidade invalida
//            System.out.println("voce nao tem essa quantidade de livros para devolver");
//            return "devolucao/cadastrar";
//        }

        try {
            if (retiradaService.temQuantidade(idPessoa, idLivro) >= devolucao.getQuantidade()) {
                devolucao.setData(LocalDate.now());
                devolucaoService.salvar(devolucao);
                livroService.devolverLivro(devolucao.getLivro(), devolucao.getQuantidade());
                return "devolucao/cadastrar";
            }
        } catch(Exception e) {
               String erro = e.getMessage();
               e.printStackTrace();
               System.out.println(erro);
               model.addAttribute("erro", "O livro ou a o cliente ou a quantidade " +
                       "a ser devolvida não é correta!");
        }
        System.out.println("Depois do cath");
        return "devolucao/cadastrar";
    }
}
