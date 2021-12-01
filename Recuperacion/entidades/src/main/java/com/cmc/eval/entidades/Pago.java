package com.cmc.eval.entidades;

public class Pago {
	
	private String cedula;
	private String cliente;
	private double monto;
	private String fechaPago;
	
	public Pago() {
		super();
	}

	public Pago(String cedula, String cliente, double monto, String fechaPago) {
		this.cedula = cedula;
		this.cliente = cliente;
		this.monto = monto;
		this.fechaPago = fechaPago;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Override
	public String toString() {
		return "Pago [cedula=" + cedula + ", cliente=" + cliente + ", monto=" + monto + ", fechaPago=" + fechaPago
				+ "]";
	} 

}
