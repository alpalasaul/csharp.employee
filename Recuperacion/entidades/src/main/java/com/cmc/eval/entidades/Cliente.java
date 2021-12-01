package com.cmc.eval.entidades;

import java.util.ArrayList;

public class Cliente {
	
	private String cedula;
	private String nombre;
	private String apellido;
	private ArrayList<Deuda> deudas = new ArrayList<Deuda>();
	private ArrayList<Pago> pagos = new ArrayList<Pago>();
	private double totalDeudas;
	private double totalPagos;
	private double saldo;
	
	public Cliente(String cedula, String nombre, String apellido) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public ArrayList<Deuda> getDeudas() {
		return deudas;
	}

	public void setDeudas(ArrayList<Deuda> deudas) {
		this.deudas = deudas;
	}
	
	public ArrayList<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(ArrayList<Pago> pagos) {
		this.pagos = pagos;
	}
	
	public double getTotalDeudas() {
		return totalDeudas;
	}

	public void setTotalDeudas(double totalDeudas) {
		this.totalDeudas = totalDeudas;
	}

	public double getTotalPagos() {
		return totalPagos;
	}

	public void setTotalPagos(double totalPagos) {
		this.totalPagos = totalPagos;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", deudas=" + deudas
				+ ", pagos=" + pagos + ", totalDeudas=" + totalDeudas + ", totalPagos=" + totalPagos + ", saldo="
				+ saldo + "]";
	}

	
	
}
