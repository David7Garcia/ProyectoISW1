package com.domain;
public class Producto {

	int id;
	String nombre;
	int precio;
	
	//constructor
	
	public Producto(int id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	// metodos get and set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecio() {
		return  precio;
	}
	public void setPrecio(int i) {
		this.precio = i;
	}


}
