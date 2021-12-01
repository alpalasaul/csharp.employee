package com.cmc.eval.test;

import com.cmc.eval.entidades.Cliente;
import com.cmc.eval.servicios.Admin;

public class TestInfo {
	
	public static void main(String[] args) {
		Admin admin=new Admin();
		admin.cargarInformacion();
		System.out.println(admin.getDatosPersonales());
		System.out.println(admin.getPagos());
		System.out.println(admin.getDeudas());
		System.out.println("\n=============================================================================\n");
		Cliente cli = admin.recuperarInformacionCompleta("1714616123");
		System.out.println(cli);
		
	}

}
