package com.udemy.backendninja.controller.ejemplo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/texto")
public class EjemploTextoController {
	
	public static final String VISTA = "ejemplo/ejemplo_mostrar_texto";

	//Primera forma de retornar una vista
	// Forma corta @GetMapping("ejemploString")
	@RequestMapping(value = "string", method = RequestMethod.GET)
	public String ejemploString(Model model) {
		model.addAttribute("nombre", "Juan");
		return VISTA;
	}

	// Segunda forma de retornar una vista
	@RequestMapping(value = "mav", method = RequestMethod.GET)
	public ModelAndView ejemploMAV() {
		ModelAndView mav = new ModelAndView(VISTA);
		mav.addObject("nombre", "Juan");
		return mav;
	}
	
}
