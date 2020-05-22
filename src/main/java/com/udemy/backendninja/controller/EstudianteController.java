package com.udemy.backendninja.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udemy.backendninja.entity.Estudiante;
import com.udemy.backendninja.entity.Usuario;
import com.udemy.backendninja.service.EstudianteService;

// TODO: Auto-generated Javadoc
/**
 * The Class EstudianteController.
 */
@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(EstudianteController.class);
	
	/** The Constant ESTUDIANTE_VIEW. */
	private static final String ESTUDIANTE_VIEW = "estudiantes";

	/** The estudiante service. */
	@Autowired
	@Qualifier("estudianteServiceImpl")
	private EstudianteService estudianteService;
	
	/**
	 * List estudiantes.
	 *
	 * @param model the model
	 * @return the string
	 */
	@PreAuthorize("hasRole('Administrador')") //Save in database ROLE_Administrador
	@GetMapping("/list")
	public String listEstudiantes(Model model) {
		//User usuario = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//model.addAttribute("usuario", usuario.getUsername());
		model.addAttribute("estudiantes", estudianteService.listEstudiantes());
		model.addAttribute("estudiante", new Estudiante());
		
		return ESTUDIANTE_VIEW;
	}
	
	/**
	 * Creates the.
	 *
	 * @param request the request
	 * @return the string
	 */
	@PreAuthorize("hasRole('Administradors')")
	@PostMapping(name = "create")
	public String  create(HttpServletRequest request) {
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre(request.getParameter("nombre"));
		estudiante.setNombre(request.getParameter("apellido"));
		estudiante.setNombre(request.getParameter("edad"));
		estudianteService.saveEstudiante(estudiante);
		LOG.info("Guardado exitosamente!" );
		return "redirect:/estudiantes/list";
	}
	
	/**
	 * Adds the estudiante.
	 *
	 * @param estudiante the estudiante
	 * @param bindingResult the binding result
	 * @return the string
	 */
	@PreAuthorize("hasRole('Administrador')") //Save in database ROLE_Administrador
	@PostMapping("/add")
	public String addEstudiante(@Valid @ModelAttribute(name = "estudiante") Estudiante estudiante, BindingResult bindingResult) {
		
		LOG.info("-- Método: 'addEstudiante()' -- Parámetros: estudiante: '" + estudiante.toString() + "'");
		
		if(!bindingResult.hasErrors()) {
			estudianteService.saveEstudiante(estudiante);
			LOG.info("Guardado exitosamente!" );
		}else {
			LOG.error("Modelo tiene errores");
		}
		
		return "redirect:/estudiantes/list";
	}
	
	/**
	 * Adds the estudiante.
	 *
	 * @param request the request
	 * @return the string
	 */
	@PostMapping("/update")
	public String addEstudiante(HttpServletRequest request) {
		
		Estudiante estudiante = new Estudiante();
		estudiante.setId(Integer.parseInt(request.getParameter("id")));
		estudiante.setNombre(request.getParameter("nombre"));
		estudiante.setApellido(request.getParameter("apellido"));
		estudiante.setEdad(Integer.parseInt(request.getParameter("edad")));
		estudianteService.saveEstudiante(estudiante);
		
		LOG.info("Guardado exitosamente!" );
		
		return "redirect:/estudiantes/list";
	}
	
	/**
	 * Delete estudiante.
	 *
	 * @param id the id
	 * @return the string
	 */
	@PostMapping("/delete")
	public String deleteEstudiante(@ModelAttribute(name = "id") int id){
		
		if(id > 0) {
			estudianteService.deleteEstudiante(id);
			LOG.info("Eliminado exitosamente!" );
		}else {
			LOG.error("id es menor o igual a cero");
		}
		
		return "redirect:/estudiantes/list";
	}
	
	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the estudiante
	 */
	@GetMapping("/find/{id}")
	@ResponseBody
	public Estudiante find(@PathVariable("id") int id) {
		Estudiante estudiante = estudianteService.findById(id);
		LOG.info("-- Método: 'find()' -- Parámetros: estudiante: '" + estudiante.toString() + "'");
		return estudiante;
	}
	
}
