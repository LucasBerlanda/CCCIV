package br.edu.unoesc.controller;

import br.edu.unoesc.dto.AutoCompleteDTO;
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
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/pessoa/cadastro")
    public String cadastro(Model model){
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa/cadastrar";
    }

    @PostMapping("/pessoa/cadastro")
    public String cadastro(@Valid Pessoa pessoa, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("pessoa", pessoa);
            return "pessoa/cadastrar";
        }
        try {
            pessoaService.salvar(pessoa);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping("/pessoa/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("pessoa", new Pessoa());
        Pessoa pessoa = pessoaService.getById(id);
        model.addAttribute("pessoa", pessoaService.getById(id));
        return "pessoa/cadastrar";
    }

    @GetMapping("/pessoa/lista")
    public String lista(Model model) {
        List<Pessoa> pessoas = pessoaService.listar();
        model.addAttribute("lista", pessoas);
        return "pessoa/lista";
    }

    @GetMapping("/pessoa/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo) {
        try {
            pessoaService.excluir(codigo);
            return "redirect:/pessoa/lista";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/pessoa/lista";
    }

    // manda json pra tela de retirada no combobox
    @RequestMapping(value="/pessoa/clientes", method = RequestMethod.GET)
    @ResponseBody
    public List<AutoCompleteDTO> clientes(HttpServletRequest request){
        String keyword = request.getParameter("term");
        List<AutoCompleteDTO> lista = pessoaService.pesquisaCliente(keyword);
        return lista;
    }
// busca pessoa por nome para lista de pessoas
    @GetMapping("/pessoa/pesquisaNome")
    public String busca(String nome, Model model) {
        model.addAttribute("lista", pessoaService.pessoaByNome(nome));
        System.out.println(pessoaService.pessoaByNome(nome));
        return "pessoa/lista";
    }

// tinha feito assim o editar mas mudei
//    @GetMapping("/pessoa/editar/{id}")
//    public ModelAndView editar(@PathVariable("id") Long id) {
//        ModelAndView model = new ModelAndView("pessoa/cadastrar");
//        Pessoa pessoa = pessoaService.getById(id);
//        model.addObject("pessoa", pessoa);
//        return model;
//    }
}