package br.edu.unoesc.controller;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import br.edu.unoesc.model.Pessoa;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/cadastro")
    public String cadastro(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("pessoa") Pessoa pessoa, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("pessoa", pessoa);
            return "pessoa/cadastrar";
        }
        pessoaService.salvar(pessoa);
        return "pessoa/cadastrar";
    }
    @GetMapping("/lista")
    public String lista(Model model) {
        List<Pessoa> pessoas = pessoaService.listar();
        model.addAttribute("lista", pessoas);
        return "pessoa/lista";
    }
    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo) {
        pessoaService.excluir(codigo);
        return "pessoa/lista";
    }

    @RequestMapping(value="clientes", method = RequestMethod.GET)
    @ResponseBody
    public List<AutoCompleteDTO> clientes(HttpServletRequest request){
        String keyword = request.getParameter("term");
        List<AutoCompleteDTO> lista = pessoaService.pesquisa(keyword);
        return lista;
    }
}