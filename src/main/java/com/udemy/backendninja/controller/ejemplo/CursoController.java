package com.udemy.backendninja.controller.ejemplo;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.model.ejemplo.CursoModel;
import com.udemy.backendninja.repository.ejemplo.CursoDslRepository;
import com.udemy.backendninja.service.ejemplo.CursoService;


@Controller
@RequestMapping("/cursos")
public class CursoController {

	private static final Log LOG = LogFactory.getLog(CursoController.class);
	
	private static final String CURSOS_VIEW = "ejemplo/cursos";

	@Autowired
	@Qualifier("cursoServiceImp")
	private CursoService cursoService;

	@Autowired
	@Qualifier("cursoDslRepository")
	private CursoDslRepository cursoDslRepository;
	
	@GetMapping("/listcursos")
	public ModelAndView listAllCursos() {
		LOG.info("Método: 'listAllCursos()'");
		ModelAndView mav = new ModelAndView(CURSOS_VIEW);
		mav.addObject("accion", "new");
		mav.addObject("curso", new CursoModel());
		mav.addObject("cursos", cursoService.listAllCursosV2());
		return mav;
	}
	
	@GetMapping("/listcursosv2")
	public ModelAndView listAllCursosV2() {
		ModelAndView mav = new ModelAndView(CURSOS_VIEW);
		LOG.info("Método: 'listAllCursosV2'");
		mav.addObject("accion", "new");
		mav.addObject("curso", new CursoModel());
		mav.addObject("cursos", cursoDslRepository.findCursos(50));
		return mav;
	}

	@PostMapping("/addcurso")
	public String addCurso(@Valid @ModelAttribute(name = "curso") CursoModel curso, BindingResult bindingResult) {
		LOG.info("Método: 'addCurso()' -- Parámetros: '" + curso.toString() +"'");
		cursoService.addCursoV2(curso);
		return "redirect:/cursos/listcursos";
	}
	
		
	@GetMapping("/{id}/edit")
	public ModelAndView selectCurso(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(CURSOS_VIEW);
		mav.addObject("accion", "update");
		mav.addObject("curso",  cursoService.findCurso(id));
		mav.addObject("cursos", cursoService.listAllCursosV2());
		return mav;
	}
	
	@PostMapping("/updatecurso")
	public String updateCurso(@Valid @ModelAttribute(name = "curso") CursoModel curso, BindingResult bindingResult) {
		cursoService.updateCursoV2(curso);
		return "redirect:/cursos/listcursos";
	}
	
	@GetMapping("/deletecurso")
	public String deleteCurso(@RequestParam(name = "id", defaultValue = "0", required = false) int id) {
		cursoService.removeCurso(id);
		return "redirect:/cursos/listcursos";
	}
	
}
