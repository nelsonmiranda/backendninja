package com.udemy.backendninja.controller.ejemplo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error")
public class EjemploErrorController {

	private static final String VIEW404 = "404";
	private static final String VIEW500 = "500";

	@GetMapping("/404")
	public String error404() {
		return VIEW404;
	}
	
	@GetMapping("/500")
	public ModelAndView error500() {
		ModelAndView mav = new ModelAndView(VIEW500);
		return mav;
	}

}
