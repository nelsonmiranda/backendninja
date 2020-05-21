package com.udemy.backendninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Estudiante;

@Repository("estudianteRepository")
public interface EstudianteRepository extends JpaRepository<Estudiante, Serializable> {
	
	
}
