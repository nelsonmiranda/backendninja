package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Estudiante;

public interface EstudianteService {
	
	public abstract List<Estudiante> listEstudiantes();
	
	public abstract Estudiante saveEstudiante(Estudiante estudiante);
	
	public abstract Estudiante findById(int id);
	
	public abstract int deleteEstudiante(int id);

}
