package br.edu.unoesc.controller;

import br.edu.unoesc.model.Livro;
import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/novoUsuario/cadastro")
    public String novoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/usuario/cadastrar";
    }

    @PostMapping("/novoUsuario/cadastro")
    public String novoUsuario(@Valid Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "/usuario/cadastrar";
        }
        try {
            usuarioService.salvar(usuario);
            return "redirect:/login";
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("erro", "Usuário já existente com esse CPF!");
        }
        return "/usuario/cadastrar";
    }
    
    
    @GetMapping("/perfil/usuario")
    public String perfilUsuario(Model model) {
        model.addAttribute("perfil", new Livro());
        Usuario usuario = usuarioService.getUsuarioLogado();
        
        return "/usuario/perfil";
    }
}
