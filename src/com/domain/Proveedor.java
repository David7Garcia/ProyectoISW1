package com.domain;
public class Proveedor {
	
	String id;
	int nit;
	String nombre;
	String contacto;
	String direccion;
	int telefono;
	
	
	//constructor
	public String getId() {
		return id;
	}
	public Proveedor(String id, int nit, String nombre, String contacto, String direccion, int telefono) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.contacto = contacto;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	//get and set
	
	public void setId(String id) {
		this.id = id;
	}
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
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
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
	
	// Metodo imprimir

	public String ImprimirCliente() {
		return "Proveedor [id= "+ id+ " nit= " + nit+" nombre= "+ nombre+ " contacto= "+contacto+" direccion= "+direccion+" telefono= "+telefono+" ]";
	}

}
