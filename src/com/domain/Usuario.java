package com.domain;

public class Usuario {
	
	private int Id;
	private String Nombre;
	private String Cargo;
	private String Contraseña;
	private int DocumentoIdentificacion;
	
	public Usuario(Integer Id, String Nombre, String Cargo,String Contraseña,Integer DocumentoIdentificacion) {
		super();
		this.Id = Id;
		this.Nombre = Nombre;
		this.Cargo = Cargo;
		this.Contraseña = Contraseña;
		this.DocumentoIdentificacion = DocumentoIdentificacion;
		
		
		
	}
	
	public int getId() {
		return Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String Cargo) {
		this.Cargo = Cargo;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String Contraseña) {
		this.Contraseña = Contraseña;
	}
	
	public int getDocumentoIdentificacion() {
		return DocumentoIdentificacion;
	}
	public void setDocumentoIdentificacion(Integer DocumentoIdentificacion) {
		this.DocumentoIdentificacion = DocumentoIdentificacion;
	}


}
