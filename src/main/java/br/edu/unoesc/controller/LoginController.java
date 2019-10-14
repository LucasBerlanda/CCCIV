package br.edu.unoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String index(Model model){
        return "login";
    }

//    @GetMapping("/logout")
//    public String logout(Model model){
//        return "redirect:/login";
//    }

}
