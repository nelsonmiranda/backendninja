package com.udemy.backendninja.controller.ejemplo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.ejemplo.LogService;

@Controller
@RequestMapping("/log")
public class EjemploLogController {

	private static final String VIEW = "/ejemplo/ejemplo_log";
	
	@Autowired
	@Qualifier("logService")
	private LogService logService;
		
	@GetMapping("/request")
	public RedirectView redireccionar2() {
		return new RedirectView("/post/mostrarform");
	}
		
	@GetMapping("/")
	private String redireccionar() {
		return "redirect:/log/first";
	}
	
	@GetMapping("/first")
	private ModelAndView mostrar() {
		logService.mostrarLog();
		ModelAndView mav = new ModelAndView(VIEW);
		mav.addObject("mensaje", "Hola por parámetro");
		return mav;
	}
	
}
