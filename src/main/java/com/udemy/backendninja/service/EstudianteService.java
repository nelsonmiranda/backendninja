package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Estudiante;

// TODO: Auto-generated Javadoc
/**
 * The Interface EstudianteService.
 */
public interface EstudianteService {
	
	/**
	 * List estudiantes.
	 *
	 * @return the list
	 */
	public abstract List<Estudiante> listEstudiantes();
	
	/**
	 * Save estudiante.
	 *
	 * @param estudiante the estudiante
	 * @return the estudiante
	 */
	public abstract Estudiante saveEstudiante(Estudiante estudiante);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the estudiante
	 */
	public abstract Estudiante findById(int id);
	
	/**
	 * Delete estudiante.
	 *
	 * @param id the id
	 * @return the int
	 */
	public abstract int deleteEstudiante(int id);

}
