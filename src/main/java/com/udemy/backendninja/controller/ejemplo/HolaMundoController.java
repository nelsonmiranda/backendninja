package com.udemy.backendninja.controller.ejemplo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hola")
public class HolaMundoController {
	
	@RequestMapping("/mundo")
	public String holamundo() {
		return "ejemplo/holamundo";
	}

}
