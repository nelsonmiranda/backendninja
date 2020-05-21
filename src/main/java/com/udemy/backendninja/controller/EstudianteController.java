package com.udemy.backendninja.controller;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udemy.backendninja.entity.Estudiante;
import com.udemy.backendninja.service.EstudianteService;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	private static final Log LOG = LogFactory.getLog(EstudianteController.class);
	
	private static final String ESTUDIANTE_VIEW = "estudiantes";

	@Autowired
	@Qualifier("estudianteServiceImpl")
	private EstudianteService estudianteService;
	
	@GetMapping("/list")
	public String listEstudiantes(Model model) {
		model.addAttribute("estudiantes", estudianteService.listEstudiantes());
		model.addAttribute("estudiante", new Estudiante());
		
		return ESTUDIANTE_VIEW;
	}
	
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
	
	@GetMapping("/find/{id}")
	@ResponseBody
	public Estudiante find(@PathVariable("id") int id) {
		Estudiante estudiante = estudianteService.findById(id);
		LOG.info("-- Método: 'find()' -- Parámetros: estudiante: '" + estudiante.toString() + "'");
		return estudiante;
	}
	
}
