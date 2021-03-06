package com.cmc.eval.servicios;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.AbstractDocument.DefaultDocumentEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.entidades.Cliente;
import com.cmc.eval.entidades.Deuda;
import com.cmc.eval.entidades.Pago;

public class Admin {
	
	private Logger logger = LogManager.getLogger(Admin.class);
	
	private HashMap<String, Cliente> datosPersonales = new HashMap<String, Cliente>();
	private HashMap<String, ArrayList<Pago>> pagos = new HashMap<String, ArrayList<Pago>>();
	private HashMap<String, ArrayList<Deuda>> deudas = new HashMap<String, ArrayList<Deuda>>();
	
	public void cargarInformacion() {
		ArrayList<Cliente> clientes1 = new ArrayList<Cliente>();
		
		try {
			clientes1 = AdminClientes.recuperarTodos();
			if (!clientes1.isEmpty()) {
				for (Cliente cliente : clientes1) {
					if (cliente != null) {
						datosPersonales.put(cliente.getCedula(), cliente);
						pagos.put(cliente.getCedula(), AdminPagos.buscarPago(cliente.getCedula()));
						deudas.put(cliente.getCedula(), AdminDeudas.recuperarDeudas(cliente.getCedula()));
					}
				}
			}
		} catch (ArchivoException e) {
			e.getStackTrace();
			logger.error("Error al leer el archivo de clientes, pagos, dedudas: " + e);
		}
	}
	
	public Cliente recuperarInformacionCompleta(String cedula) {
		double totalPagos = 0;
		double totalDeudas = 0;
		if (datosPersonales.containsKey(cedula)) {
			Cliente cli = datosPersonales.get(cedula);
			cli.setDeudas(deudas.get(cedula));
			cli.setPagos(pagos.get(cedula));
			
			ArrayList<Pago> pagosAux = new ArrayList<Pago>();
			pagosAux.addAll(pagos.get(cedula));
			
			for (Pago pago : pagosAux) {
				if (pago != null) {
					totalPagos = totalPagos + pago.getMonto();
				}
			}
			
			ArrayList<Deuda> deudaAux = new ArrayList<Deuda>();
			deudaAux.addAll(deudas.get(cedula));
			
			for (Deuda deuda : deudaAux) {
				if (deuda != null) {
					totalDeudas = totalDeudas + deuda.getMonto();
				}
			}
			cli.setTotalDeudas(totalDeudas);
			cli.setTotalPagos(totalPagos);
			cli.setSaldo(totalDeudas - totalPagos);
			return cli;
		}
		return null;
	}
	
	public HashMap<String, Cliente> getDatosPersonales() {
		return datosPersonales;
	}
	public void setDatosPersonales(HashMap<String, Cliente> datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	public HashMap<String, ArrayList<Pago>> getPagos() {
		return pagos;
	}
	public void setPagos(HashMap<String, ArrayList<Pago>> pagos) {
		this.pagos = pagos;
	}
	public HashMap<String, ArrayList<Deuda>> getDeudas() {
		return deudas;
	}
	public void setDeudas(HashMap<String, ArrayList<Deuda>> deudas) {
		this.deudas = deudas;
	}
	
	
			

}
