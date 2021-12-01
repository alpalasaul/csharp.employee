package com.cmc.eval.entidades;

import java.util.Date;

public class Deuda {
	
	private String cedulaCliente;
	private double monto;
	private Date fecha;
	
	public Deuda(String cedulaCliente, double monto, Date fecha) {
		this.cedulaCliente = cedulaCliente;
		this.monto = monto;
		this.fecha = fecha;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Deuda [cedulaCliente=" + cedulaCliente + ", monto=" + monto + ", fecha=" + fecha + "]";
	}

}
