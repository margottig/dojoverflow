package com.example.dojooverflow.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojooverflow.models.Preguntas;
import com.example.dojooverflow.models.nuevaPregunta;
import com.example.dojooverflow.services.MainService;

import jakarta.validation.Valid;


@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;

	
	@GetMapping("/")
	 public String raiz() {
		return "redirect:/questions";
	}
	
	@GetMapping("/questions")
	 public String questions() {
		return "raiz.jsp";
	}
	
	@GetMapping("/questions/new")
	 public String questionsFormular(@ModelAttribute("question") Preguntas pregunta) {
		return "qformular.jsp";
	}
	

	@PostMapping("/questions/new")
	 public String questionsCreate(@Valid @ModelAttribute("question") nuevaPregunta nuevaPregunta, 
			 BindingResult resultado ) {
//		if(resultado.hasErrors()) {
//			return "qformular.jsp";
//		}
		mainService.crearPregunta(nuevaPregunta);
		return "redirect:/";
	}
	
	
	
}
