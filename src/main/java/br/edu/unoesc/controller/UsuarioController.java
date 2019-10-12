package br.edu.unoesc.controller;

import br.edu.unoesc.model.Usuario;
import br.edu.unoesc.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/novoUsuario/cadastro")
    public String novoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "/novoUsuario/cadastrar";
    }

    @PostMapping("/novoUsuario/cadastro")
    public String novoUsuario(@Valid Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("usuario", usuario);
            return "/novoUsuario/cadastrar";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }
}
