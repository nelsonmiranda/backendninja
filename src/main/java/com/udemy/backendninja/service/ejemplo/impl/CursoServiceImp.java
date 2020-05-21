package com.udemy.backendninja.service.ejemplo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.controller.ejemplo.CursoController;
import com.udemy.backendninja.converter.ejemplo.CursoConverter;
import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.model.ejemplo.CursoModel;
import com.udemy.backendninja.repository.ejemplo.CursoJpaRepository;
import com.udemy.backendninja.service.ejemplo.CursoService;

@Service("cursoServiceImp")
public class CursoServiceImp implements CursoService {

	private static final Log LOG = LogFactory.getLog(CursoServiceImp.class);

	@Autowired
	@Qualifier("cursoJpaRepository")
	private CursoJpaRepository cursoJpaRepository;

	@Autowired
	@Qualifier("cursoConverter")
	private CursoConverter cursoConverter;

	@Override
	public List<Curso> listAllCursos() {
		LOG.info("Método: 'listAllCursos'");
		return cursoJpaRepository.findAll();
	}

	@Override
	public Curso addCurso(Curso curso) {
		LOG.info("Método: 'addCurso' -- Parámetros: '" + curso.toString() + "'");
		return cursoJpaRepository.save(curso);
	}

	@Override
	public Curso updateCurso(Curso curso) {
		return cursoJpaRepository.save(curso);
	}

	@Override
	public int removeCurso(int id) {
		cursoJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public List<CursoModel> listAllCursosV2() {
		LOG.info("Método: 'listAllCursosV2 From Converter'");
		List<CursoModel> lstModelCursos = new ArrayList<CursoModel>();
		List<Curso> lstCursos = cursoJpaRepository.findAll();

		lstCursos.forEach((objCurso) -> {
			lstModelCursos.add(cursoConverter.entityToModel(objCurso));
		});

		return lstModelCursos;
	}

	@Override
	public CursoModel addCursoV2(CursoModel cursoModel) {
		LOG.info("Método: 'addCursoV2 From Converter'");
		Curso curso = cursoConverter.modelToEntity(cursoModel);
		CursoModel objCursoModel = cursoConverter.entityToModel(cursoJpaRepository.save(curso));
		return objCursoModel;
	}

	@Override
	public CursoModel findCurso(int id) {
		return cursoConverter.entityToModel(cursoJpaRepository.findById(id).orElse(new Curso()));
	}

	@Override
	public CursoModel updateCursoV2(CursoModel curso) {
		
		return cursoConverter.entityToModel(cursoJpaRepository.save(cursoConverter.modelToEntity(curso)));
	}
	
	
}
