package com.domain;
import java.util.ArrayList;

public class ClienteFrecuente {
	
	String nombre;
	int documentoDeIdentidad;
	int puntos;
	
	
	public ClienteFrecuente(String nombre, int documento, int puntos) {
		super();
		this.nombre = nombre;
		this.documentoDeIdentidad = documento;
		this.puntos = puntos;
	}
	


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDocumentoDeIdentidad() {
		return documentoDeIdentidad;
	}
	public void setDocumentoDeIdentidad(int i) {
		this.documentoDeIdentidad = i;
	}
	
	public int getPuntos() {
	return puntos;
	}


	public void setPuntos(int puntos) {
	this.puntos = puntos;
	}
}