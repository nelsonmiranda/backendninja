package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	private static final String LOGIN_VIEW = "login";

	@GetMapping("/login")
	public String login(Model model, @RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false ) String logout) {
		LOG.info("-- Método: 'login()' -- Parámetros: error: '" + error + "' --  logout: '" + logout + "'");
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("-- Return: VIEW: '" + LOGIN_VIEW + "'");
		return LOGIN_VIEW;
	}

	@GetMapping({"/loginsuccess", "/"})
	public String logincheck() {
		LOG.info("-- Método: 'logincheck()'");
		LOG.info("-- Return: VIEW: '" + LOGIN_VIEW + "'");
		return "redirect:/estudiantes/list";
	}
	
//	@GetMapping("/")
//	public String redireccionar() {
//		return "redirect:/login";
//	}
	
//	@GetMapping("/login")
//	public String login(Model model, @RequestParam(name = "error", required = false) String error,
//			@RequestParam(name = "logout", required = false ) String logout) {
//		LOG.info("-- Método: 'login()' -- Parámetros: error: '" + error + "' --  logout: '" + logout + "'");
//		model.addAttribute("usuarioCredential", new UsuarioCredential());
//		model.addAttribute("error", error);
//		model.addAttribute("logout", logout);
//		LOG.info("-- Return: VIEW: '" + LOGIN_VIEW + "'");
//		return LOGIN_VIEW;
//	}
//	
//	@PostMapping("/logincheckv2")
//	public String logincheckv2(@ModelAttribute(name = "usuarioCredential") UsuarioCredential usuarioCredential) {
//		LOG.info("-- Método: 'logincheck()' -- Parámetros: usuarioCredential: '" + usuarioCredential.toString() + "'");
//		if (usuarioCredential.getUsuario().equals("admin") && usuarioCredential.getPassword().equals("admin")) {
//			LOG.info("-- Return: VIEW: '" + USUARIO_VIEW + "'");
//			return "redirect:/estudiantes/list";		
//		}
//		LOG.info("-- Return: VIEW: '" + LOGIN_VIEW + "'");
//		return "redirect:/login?error";
//	}
	
}
