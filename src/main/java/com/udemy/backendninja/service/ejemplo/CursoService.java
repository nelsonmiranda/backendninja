package com.udemy.backendninja.service.ejemplo;

import java.util.List;

import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.model.ejemplo.CursoModel;

public interface CursoService {

	public abstract List<Curso> listAllCursos();
	
	public abstract List<CursoModel> listAllCursosV2();

	public abstract Curso addCurso(Curso curso);
	
	public abstract CursoModel addCursoV2(CursoModel cursoModel);

	public abstract Curso updateCurso(Curso curso);
	
	public abstract CursoModel updateCursoV2(CursoModel curso);

	public abstract int removeCurso(int id);
	
	public abstract CursoModel findCurso(int id);

}
