package com.domain;
public class Producto {

	String id;
	String nombre;
	Float precio;
	int version;
	Float valorImpuesto;
	
	//constructor
	
	public Producto(String id, String nombre, Float precio, int version, Float valorImpuesto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.version = version;
		this.valorImpuesto = valorImpuesto;
	}

	// metodos get and set
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Float getPrecio() {
		return (float) precio;
	}
	public void setPrecio(float i) {
		this.precio = i;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Float getValorImpuesto() {
		return valorImpuesto;
	}
	public void setValorImpuesto(Float valorImpuesto) {
		this.valorImpuesto = valorImpuesto;
	}
	
	// Metodo imprimir
	public String ImprimirProducto() {
		return "Producto [id= "+id+" nombre= "+ nombre+ " precio= " + precio+" version= "+ version + "valor impuesto=" + valorImpuesto +  "]";
	}



}
