package com.cmc.eval.test;

import com.cmc.eval.entidades.Pago;
import com.cmc.eval.servicios.AdminPagos;

public class TestPagos {
	
	public static void main(String[] args) {
		Pago pago = new Pago("0414616123", "", 100, "2021-03-22");
		
		if (pago != null) {
			AdminPagos.registrarPago(pago);
		}
	}
}