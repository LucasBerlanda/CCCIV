package br.edu.unoesc.controller;

import br.edu.unoesc.model.*;
import br.edu.unoesc.service.LivroService;
import br.edu.unoesc.service.PessoaService;
import br.edu.unoesc.service.RetiradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private RetiradaService retiradaService;


    @GetMapping("/livro/cadastro")
    public String cadastro(Model model){
        model.addAttribute("livro", new Livro());
        return "livro/cadastrar";
    }

    @PostMapping("/livro/cadastro")
    public String cadastro(@Valid Livro livro, BindingResult result, Model model) {
        if(result.hasErrors()){
            model.addAttribute("livro", livro);
            return "livro/cadastrar";
        }
        livroService.salvar(livro);
        return "redirect:/";
    }

    @GetMapping("/livro/editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        model.addAttribute("livro", new Livro());
        Livro livro = livroService.getById(id);
        System.out.println("EDITAR" + livro);
        model.addAttribute("livro", livroService.getById(id));
        return "livro/cadastrar";
    }

    @GetMapping("/livro/lista")
    public String lista(Model model) {
        List<Livro> livros = livroService.listar();
        model.addAttribute("lista", livros);
        return "livro/lista";
    }

    @GetMapping("/livro/excluir/{codigo}")
    public String excluir(@PathVariable Long codigo) {
        livroService.excluir(codigo);
        return "redirect:/livro/lista";
    }
    @RequestMapping(value="/livro/exemplares", method = RequestMethod.GET)
    @ResponseBody
    public List<AutoCompleteDTO> exemplares(HttpServletRequest request){
        String keyword = request.getParameter("term");
        List<AutoCompleteDTO> lista = livroService.pesquisaLivro(keyword);
        return lista;
    }
    @GetMapping("/livro/pesquisaTituloLivro")
    public String busca(String titulo, Model model) {
        model.addAttribute("lista", livroService.livroByNome(titulo));
        return "livro/lista";
    }

    @GetMapping("/livro/pesquisaLivrosDisponiveis")
    public String buscaLivrosDisponiveis(String titulo, Model model) {
        model.addAttribute("lista", livroService.livrosDisponiveisByTitulo(titulo));
        model.addAttribute("pessoasCadastradas", pessoaService.quantidade());
        model.addAttribute("livrosCadastradas", livroService.quantidade());
        return "index";
    }

    @GetMapping("/livro/livrosEmprestados")
    public String livrosEmprestados(Model model){
        List<Object> lista = retiradaService.livrosEmprestados();
        model.addAttribute("lista", lista);
        System.out.println(retiradaService.livrosEmprestados().toString());
        for(int i = 0; i<=lista.size(); i++){
            System.out.println(lista);
        }
        return "livro/livrosEmprestados";
    }

    @GetMapping("/livro/livroEmprestadoByCliente")
    public String livroDisponivelByCliente(String cliente, Model model){
        model.addAttribute("lista", retiradaService.livrosEmprestadosByCliente(cliente));
        return "livro/livrosEmprestados";
    }
    @GetMapping("/livro/livroEmprestadoByLivro")
    public String livroDisponivelTitulo(String titulo, Model model){
        model.addAttribute("lista", retiradaService.livrosEmprestadosByLivro(titulo));
        return "livro/livrosEmprestados";
    }
}
