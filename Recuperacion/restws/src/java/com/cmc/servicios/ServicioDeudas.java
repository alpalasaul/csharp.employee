package com.cmc.servicios;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cmc.eval.commons.ArchivoException;
import com.cmc.eval.entidades.Busqueda;
import com.cmc.eval.entidades.Cliente;
import com.cmc.eval.entidades.Deuda;
import com.cmc.eval.servicios.AdminClientes;
import com.cmc.eval.servicios.AdminDeudas;

@Path("/deudas")
public class ServicioDeudas {
	
	private static Logger logger = LogManager.getLogger(ClientesRest.class);
	
	@Path("/buscar")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public static Response cambiar(Busqueda busqueda) {
		Cliente cli = null;
		ArrayList<Deuda> deudas = new ArrayList<Deuda>();
		if (busqueda != null) {
			try {
				cli = AdminClientes.buscarPorCedula(busqueda.getCedula());
				
			} catch (ArchivoException e) {
				e.printStackTrace();
				logger.error("Se ha producido un error en el m?todo AdminClientes.buscarPorCedula");
			}
			try {
				deudas.addAll(AdminDeudas.recuperarDeudas(busqueda.getCedula()));
			} catch (ArchivoException e) {
				e.printStackTrace();
				logger.error("Se ha producido un error en el m?todo AdminClientes.recuperarDeudas");
			}
		}
		cli.setDeudas(deudas);
		
		
		return Response.status(200).entity(cli).build();
	}

}
