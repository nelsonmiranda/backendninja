package com.udemy.backendninja.controller.ejemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.repository.ejemplo.CursoJpaRepository;

@Controller
@RequestMapping("/vista")
public class EjemploController {

	private static final String VISTA = "ejemplo/ejemplo_mostrar_vista";

	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;

	// Primera forma de retornar una vista
	// Forma corta @GetMapping("ejemploString")
	@RequestMapping(value = "string", method = RequestMethod.GET)
	public String ejemploString() {

		return VISTA;
	}

	// Segunda forma de retornar una vista
	@RequestMapping(value = "mav", method = RequestMethod.GET)
	public ModelAndView ejemploMAV() {
		return new ModelAndView(VISTA);
	}
}
