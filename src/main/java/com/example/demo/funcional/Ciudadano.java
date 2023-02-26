package com.example.demo.funcional;

public class Ciudadano {
	
	private String nombreCompleto;
	private String Ciudad;
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	@Override
	public String toString() {
		return "Ciudadano [nombreCompleto=" + nombreCompleto + ", Ciudad=" + Ciudad + "]";
	}
	
	

}
