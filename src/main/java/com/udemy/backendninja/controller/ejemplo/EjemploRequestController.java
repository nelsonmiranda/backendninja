package com.udemy.backendninja.controller.ejemplo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/request")
public class EjemploRequestController {

	private static final String VIEW = "ejemplo/ejemplo_request_forma_uno";

	//Redireccion forma uno
	@GetMapping("/")
	public String redireccionar() {
		return "redirect:/request/request1";
	}
		
	// localhost:8080/request/request1?nm=NELSON
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name = "nm", defaultValue = "NULL", required = false) String nombre) {
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("nombre_model", nombre);
		return mav;
	}

	// localhost:8080/request/request2/NELSON
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String nombre) {
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("nombre_model", nombre);
		return mav;
	}

}
