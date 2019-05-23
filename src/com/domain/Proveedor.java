package com.domain;
public class Proveedor {
	
	int nit;
	String nombre;
	String correo;
	String direccion;
	int telefono;
	
	
	
	public Proveedor(int nit, String nombre, String correo, String direccion, int telefono) {
		super();
		this.nit = nit;
		this.nombre = nombre;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	//get and set
	
	
	public int getNit() {
		return nit;
	}
	public void setNit(int nit) {
		this.nit = nit;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String contacto) {
		this.correo = contacto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	


}
