package br.com.escola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaController {
	
	@RequestMapping("/")
	public String ola(Model model) {
		model.addAttribute("mensagem", "Spring Boot com Thymeleaf");
		return "index";
	}

}
