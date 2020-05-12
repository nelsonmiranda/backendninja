package com.udemy.backendninja.service.ejemplo.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.ejemplo.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

	private static final Log LOG = LogFactory.getLog(LogServiceImpl.class);

	@Override
	public void mostrarLog() {
		LOG.info("Hola desde servicio de Log");
	}

}
