package com.tecsup.gestion.model;

public class Paradero {
	
	String empresa;
	String nombre;
	double longitud;
	double latitud;
	
	public Paradero() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Paradero(String empresa, String nombre, double longitud, double latitud) {
		super();
		this.empresa = empresa;
		this.nombre = nombre;
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	
}
