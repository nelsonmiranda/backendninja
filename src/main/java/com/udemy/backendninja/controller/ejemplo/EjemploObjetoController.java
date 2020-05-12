package com.udemy.backendninja.controller.ejemplo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.ejemplo.Persona;

@Controller
@RequestMapping("/objeto")
public class EjemploObjetoController {

	public static final String VISTA = "ejemplo/ejemplo_mostrar_objeto";

	@GetMapping("/string")
	public String ejemploString(Model model) {
		model.addAttribute("persona", new Persona("Juan", 25));
		return VISTA;
	}

	@GetMapping("/mav")
	public ModelAndView ejemploMAV() {
		ModelAndView mav = new ModelAndView(VISTA);
		mav.addObject("persona", new Persona("Pedro", 30));
		return mav;
	}

}
