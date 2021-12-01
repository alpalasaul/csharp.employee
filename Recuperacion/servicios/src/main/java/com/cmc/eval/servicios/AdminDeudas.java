package com.cmc.eval.servicios;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.commons.DateUtil;
import com.cmc.eval.entidades.Deuda;

public class AdminDeudas {
	
	public static final String NOMBRE_ARCHIVO = "deudas.txt";

	private static Logger logger = LogManager.getLogger(AdminDeudas.class);
	
	public static ArrayList<Deuda> recuperarDeudas(String cedula) throws ArchivoException {
		AdminArchivos adminArchivos = new AdminArchivos(NOMBRE_ARCHIVO);
		ArrayList<String> listaRecuperada = new ArrayList<String>();
		listaRecuperada.addAll(adminArchivos.leer());
		ArrayList<Deuda> deudasCliente = new ArrayList<Deuda>();
		String linea = "";
		String[] separado;
		Deuda deu = null;
		for (int i = 0; i < listaRecuperada.size(); i++) {
			if (listaRecuperada != null) {
				linea = listaRecuperada.get(i);
				separado = linea.split("\\*"); // posiblemente toque cambiar mas adelante
				if (separado[0].equals(cedula)) {
					Date date = null;
					try {
						date = DateUtil.convertirDate(separado[2]);
						deu = new Deuda(separado[0], Double.parseDouble(separado[1]), date); // date
						deudasCliente.add(deu);
					} catch (ParseException e) {
						e.printStackTrace();
						logger.error("Error al convertir fecha de String a date", e);
					}
				}
			}
		}
		return deudasCliente;
	}
}