package br.com.security.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("springsecurity")
public class WelcomeController {

	
	@GetMapping
	public String welcome() {
		return "bem vindo ao app";
	}
	@GetMapping("/usuarios")
	public String Usuarios() {
		return "Autorizado usuarios e administradores";
	}
	
	@GetMapping("/administradores")
	public String Administradores() {
		return "Autorizado somente administradores";
	}
	
	@GetMapping("/entregadores")
	public String Entregadores() {
		return "Autorizado entregadores, usuarios e dministradores";
	}
}
