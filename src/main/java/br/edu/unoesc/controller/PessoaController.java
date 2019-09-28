package br.edu.unoesc.controller;

import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import br.edu.unoesc.model.Pessoa;

import java.util.List;

@Controller
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/cadastro")
    public String cadastro(){
        return "pessoa/cadastrar";
    }

    @PostMapping("/pessoa/cadastro")
    public String cadastro(Model model, Pessoa pessoa) {
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