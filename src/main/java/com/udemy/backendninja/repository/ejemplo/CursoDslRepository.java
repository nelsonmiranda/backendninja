package com.udemy.backendninja.repository.ejemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Curso;
import com.udemy.backendninja.entity.QCurso;

@Repository("cursoDslRepository")
public class CursoDslRepository {

	private static final Log LOG = LogFactory.getLog(CursoDslRepository.class);

	@PersistenceContext
	private EntityManager em;

	private QCurso qCurso = QCurso.curso;

	public List<Curso> findCursos(Integer precioMaximo) {

		LOG.info("Método: 'findCursos()'");
		JPAQuery<Curso> query = new JPAQuery<Curso>(em);

		BooleanBuilder predicateBuilder = new BooleanBuilder(qCurso.precio.isNotNull());

		List<Curso> lstCursos = query.select(qCurso).from(qCurso).where(predicateBuilder).fetch();

		return lstCursos;

	}

}
