package com.cmc.eval.servicios;

import java.util.ArrayList;

import javax.swing.text.AbstractDocument.DefaultDocumentEvent;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.entidades.Cliente;
import com.cmc.eval.entidades.Deuda;
import com.cmc.eval.entidades.Pago;

public class AdminClientes {
	
	public static final String NOMBRE_ARCHIVO = "clientes.txt";
	
	public static ArrayList<Cliente> recuperarTodos() throws ArchivoException {
		AdminArchivos adminArchivos = new AdminArchivos(NOMBRE_ARCHIVO);
		ArrayList<String> listaRecuperada = new ArrayList<String>();
		listaRecuperada.addAll(adminArchivos.leer());
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String linea = "";
		String[] separado;
		Cliente cli = null;
		for (int i = 0; i < listaRecuperada.size(); i++) {
			if (listaRecuperada != null) {
				linea = listaRecuperada.get(i);
				separado = linea.split("-"); // posiblemente toque cambiar mas adelante
				cli = new Cliente(separado[0], separado[1], separado[2]); // cedula nombre apellido (String)
				clientes.add(cli);
			}
		}
		return clientes;
	}
	
	public static Cliente buscarPorCedula(String cedula) throws ArchivoException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.addAll(recuperarTodos());
		for (Cliente cliente : clientes) {
			if (cliente != null) {
				if (cliente.getCedula().equals(cedula)) {
					return cliente;
				}
			}
		}
		return null;
	}
	
	public static Cliente consultarEstado(String cedula) throws ArchivoException {
		double totalDeduas = 0;
		double totalPagos = 0;
		Cliente cli = buscarPorCedula(cedula);
		ArrayList<Deuda> deudas = new ArrayList<Deuda>();
		ArrayList<Pago> pagos = new ArrayList<Pago>();
		deudas.addAll(AdminDeudas.recuperarDeudas(cedula));
		pagos.addAll(AdminPagos.buscarPago(cedula));
		
		cli.setPagos(pagos);
		cli.setDeudas(deudas);
		
		for (Pago pago : pagos) {
			if (pago != null) {
				if (pago.getCedula().equals(cedula)) {
					totalPagos = totalPagos + pago.getMonto();
				}
			}
		}
		
		for (Deuda deuda : deudas) {
			if (deuda != null) {
				if (deuda.getCedulaCliente().equals(cedula)) {
					totalDeduas = totalDeduas + deuda.getMonto();
				}
			}
		}
		
		cli.setTotalDeudas(totalDeduas);
		cli.setTotalPagos(totalPagos);
		cli.setSaldo(totalDeduas - totalPagos);
		
		return cli;

	}

}
