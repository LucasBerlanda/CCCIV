package br.edu.unoesc.controller;

import br.edu.unoesc.model.AutoCompleteDTO;
import br.edu.unoesc.model.Livro;
import br.edu.unoesc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/cadastro")
    public String cadastro(Model model) {
        model.addAttribute("livro", new Livro());
        return "livro/cadastrar";
    }

    @PostMapping("/cadastro")
    public String cadastro(@Valid @ModelAttribute("livro") Livro livro, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("livro", livro);
            return "livro/cadastrar";
        }
        livro.setQuantidadeDisponivel(livro.getQuantidade());
        this.livroService.salvar(livro);
        return "livro/cadastrar";
    }
    @GetMapping("/lista")
    public String lista(Model model) {
        List<Livro> livros = livroService.listar();
        model.addAttribute("lista", livros);
        return "livro/lista";
    }

    @GetMapping("/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo) {
        livroService.excluir(codigo);
        return "redirect:/livro/lista";
    }
    @RequestMapping(value="exemplares", method = RequestMethod.GET)
    @ResponseBody
    public List<AutoCompleteDTO> exemplares(HttpServletRequest request){
        String keyword = request.getParameter("term");
        List<AutoCompleteDTO> lista = livroService.pesquisaLivro(keyword);
        return lista;
    }


}
