package br.edu.unoesc.controller;

import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.unoesc.model.Pessoa;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/cadastro")
    public String cadastro(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/cadastrar";
    }

    @PostMapping("/pessoa/cadastro")
    public String cadastro(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("pessoa", pessoa);
            return "pessoa/cadastrar";
        }
        pessoaService.salvar(pessoa);
        return "pessoa/cadastrar";
    }
    @GetMapping("/pessoa/lista")
    public String lista(Model model) {
        List<Pessoa> pessoas = pessoaService.listar();
        model.addAttribute("lista", pessoas);
        return "pessoa/lista";
    }
    @PostMapping("/pessoa/excluir")
    public ResponseEntity<String> excluir(Pessoa pessoa) {
        pessoaService.excluir(pessoa);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}