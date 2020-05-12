package com.udemy.backendninja.component.ejemplo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("holaComponente")
public class HolaComponent {

	private static final Log LOG = LogFactory.getLog(HolaComponent.class);
	
	public void holaComponent() {
		LOG.info("Hola desde compoenente");
	}
}
