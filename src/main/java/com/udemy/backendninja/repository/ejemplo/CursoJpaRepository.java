package com.udemy.backendninja.repository.ejemplo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Curso;

@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso, Serializable> {

	public abstract Curso findByNombre(String nombre);

	public abstract Curso findByNombreAndPrecio(String nombre, int precio);

	public abstract List<Curso> findByNombreOrderByNombre(String nombre);
}
