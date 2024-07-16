package com.salon.beauty.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.salon.beauty.servicios.UsuariosService;

@Controller
public class WebController {
	
	@Autowired
	private UsuariosService usuariosSevice;
	
	@GetMapping("/")
    public String home() {
		
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "administrador";
    }

    @GetMapping("/user")
    public String user() {
        return "clientes";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }

}
