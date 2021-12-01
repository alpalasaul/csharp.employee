package com.cmc.eval.test;

import com.cmc.eval.servicios.Admin;

public class TestInformacion {

	public static void main(String[] args) {
		Admin admin=new Admin();
		admin.cargarInformacion();
		System.out.println(admin.getDatosPersonales());
		System.out.println(admin.getPagos());
		System.out.println(admin.getDeudas());
	}

}
