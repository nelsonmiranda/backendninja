package com.udemy.backendninja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.entity.Estudiante;
import com.udemy.backendninja.repository.EstudianteRepository;
import com.udemy.backendninja.service.EstudianteService;

@Service("estudianteServiceImpl")
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	@Qualifier("estudianteRepository")
	private EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> listEstudiantes() {
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante saveEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}

	@Override
	public Estudiante findById(int id) {
		return estudianteRepository.findById(id).orElse(null);
	}

	@Override
	public int deleteEstudiante(int id) {
		estudianteRepository.deleteById(id);
		return 0;
	}
	
}
