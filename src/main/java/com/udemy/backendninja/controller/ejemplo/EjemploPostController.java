package com.udemy.backendninja.controller.ejemplo;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.component.ejemplo.HolaComponent;
import com.udemy.backendninja.model.ejemplo.Persona;

@Controller
@RequestMapping("/post")
public class EjemploPostController {

	private static final Log LOGGER = LogFactory.getLog(EjemploPostController.class);
	
	private static final String VIEW = "ejemplo/ejemplo_post_form";
	private static final String RESULTADO_VIEW = "ejemplo/ejemplo_post_resultado";
	
	@Autowired
	@Qualifier("holaComponente")
	private HolaComponent holaComponent;
	
	//Redireccion forma uno
	/*
	 * @GetMapping("/") public String redireccionar() { return
	 * "redirect:/post/mostrarform"; }
	 */
	
	@GetMapping("/")
	public RedirectView redireccionar() {
		return new RedirectView("/post/mostrarform");
	}
	
	@GetMapping("/mostrarform")
	public String mostrarForm(Model model) {
		/*
		 * LOGGER.info("Trasa de información"); LOGGER.warn("Trasa de peligro");
		 * LOGGER.error("Trasa de error");
		 */
		holaComponent.holaComponent();
		LOGGER.debug("Trasa debug"); //Solo cuando esta en modo debug
		model.addAttribute("persona", new Persona());
		return VIEW;
	}
	
	@PostMapping("/addpersona")
	public ModelAndView addPersona(@ModelAttribute("persona") Persona persona) {
		LOGGER.info("Metodo: 'addPersona' -- Parametros: '" + persona + "'");
		ModelAndView mav = new ModelAndView(RESULTADO_VIEW);
		mav.addObject("persona", persona);
		LOGGER.info("Template: '" + RESULTADO_VIEW + "' Datos: '" + persona + "'");
		return mav;
	}
	
	@PostMapping("/addpersonav2")
	public ModelAndView addPersonaV2(@Valid @ModelAttribute("persona") Persona persona, BindingResult bindingResult) {
		
		ModelAndView mav = new ModelAndView();
		
		if(bindingResult.hasErrors()) {
			mav.setViewName(VIEW);
		}else {
			mav.setViewName(RESULTADO_VIEW);
			mav.addObject("persona", persona);
		}
		return mav;
	}
	
	
}
