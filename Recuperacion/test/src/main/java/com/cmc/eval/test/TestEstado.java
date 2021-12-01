package com.cmc.eval.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.entidades.Cliente;
import com.cmc.eval.servicios.AdminClientes;

public class TestEstado {
	
	private static Logger logger = LogManager.getLogger(TestDeudas.class);

	public static void main(String[] args) {
		Cliente cli = null;
		try {
			cli = AdminClientes.consultarEstado("1714616123");
		} catch (ArchivoException e) {
			e.printStackTrace();
			logger.error("Error en el metodo AdminClientes.consultarEstado");
		}
		System.out.println(cli);

	}

}
