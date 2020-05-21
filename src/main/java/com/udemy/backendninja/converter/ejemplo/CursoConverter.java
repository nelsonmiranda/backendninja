package com.udemy.backendninja.converter.ejemplo;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.model.ejemplo.CursoModel;

@Component("cursoConverter")
public class CursoConverter {

	// Entity -- Model
	public CursoModel entityToModel(Curso curso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setId(curso.getId());
		cursoModel.setNombre(curso.getNombre());
		cursoModel.setDescripcion(curso.getDescripcion());
		cursoModel.setPrecio(curso.getPrecio());
		cursoModel.setHoras(curso.getHoras());
		return cursoModel;
	}

	// Model -- Entity
	public Curso modelToEntity(CursoModel cursoModel) {
		Curso curso = new Curso();
		curso.setId(cursoModel.getId());
		curso.setNombre(cursoModel.getNombre());
		curso.setDescripcion(cursoModel.getDescripcion());
		curso.setPrecio(cursoModel.getPrecio());
		curso.setHoras(cursoModel.getHoras());
		return curso;
	}

}
