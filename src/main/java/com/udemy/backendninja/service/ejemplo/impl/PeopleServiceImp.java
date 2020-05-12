package com.udemy.backendninja.service.ejemplo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.ejemplo.Persona;
import com.udemy.backendninja.service.ejemplo.PeopleServiceInterface;

@Service("peopleService")
public class PeopleServiceImp implements PeopleServiceInterface {

	private static final Log LOG = LogFactory.getLog(PeopleServiceImp.class);
	@Override
	public List<Persona> getListPeople() {
		List<Persona> lstPersona = new ArrayList<>();
		lstPersona.add(new Persona("Juan", 25));
		lstPersona.add(new Persona("Pedro", 65));
		lstPersona.add(new Persona("Carmen", 55));
		LOG.info("HOLA DESDE SERVICE");
		return lstPersona;
	}
	
}
