package com.udemy.backendninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.service.ejemplo.CursoService;

@Controller
@RequestMapping("/contactos")
public class ContactoController {

	@Autowired
	@Qualifier("cursoServiceImp")
	private CursoService cursoService;

	private static final String CONTACTOS_VIEW = "estudiantes";

	@GetMapping("/list")
	public ModelAndView mostrarContactos() {
		ModelAndView mav = new ModelAndView(CONTACTOS_VIEW);
		mav.addObject("curso", new Curso());
		mav.addObject("cursos", cursoService.listAllCursosV2());
		return mav;
	}

}
