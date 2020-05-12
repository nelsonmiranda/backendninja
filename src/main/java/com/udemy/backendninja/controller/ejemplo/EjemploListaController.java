package com.udemy.backendninja.controller.ejemplo;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.ejemplo.Persona;
import com.udemy.backendninja.service.ejemplo.PeopleServiceInterface;

@Controller
@RequestMapping("lista")
public class EjemploListaController {

	@Autowired
	@Qualifier("peopleService")
	private PeopleServiceInterface peopleServiceInt;
	
	
	private static final String VISTA = "ejemplo/ejemplo_lista_objeto";
	
	@GetMapping("/string")
	public String ejemploString(Model model) {
		model.addAttribute("personas", peopleServiceInt.getListPeople());
		return VISTA;
	}
	
	@GetMapping("/mav")
	public ModelAndView ejemploMAV() {
		ModelAndView mav = new ModelAndView(VISTA);
		mav.addObject("personas", peopleServiceInt.getListPeople());
		return mav;
	}
	

}
