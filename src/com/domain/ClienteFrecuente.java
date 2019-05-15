package com.domain;
import java.util.ArrayList;

public class ClienteFrecuente {
	
	String nombre;
	int documentoDeIdentidad;
	int puntos;
	
	
	public ClienteFrecuente(String nombre, Short documentoDeIdentidad, int puntos) {
		super();
		this.nombre = nombre;
		this.documentoDeIdentidad = documentoDeIdentidad;
		this.puntos = puntos;
	}
	


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDocumentoDeIdentidad(int i) {
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

	
	// Metodo imprimir

		public String ImprimirCliente() {
			return "Producto [nombre= "+ nombre+ " documento identidad= " + documentoDeIdentidad+" puntos= "+ puntos + "]";
		}
		
		
		
		//lista de cliente frecuente
		public ArrayList<ClienteFrecuente> listaClienteFrecuente = new ArrayList<ClienteFrecuente>();
		
		//get and set array list
			public ArrayList<ClienteFrecuente> getListaClienteFrecuente() {
			return listaClienteFrecuente;
		}

			
		public void setListaUsuario(ArrayList<ClienteFrecuente> listaCliente) {
			this.listaClienteFrecuente = listaCliente;
		}


		
			//	Ingresar cliente frecuente a la lista
			public void ingresarCliente(ClienteFrecuente listaCliente){
				
				listaClienteFrecuente.add(listaCliente);
			}

			// Eliminar cliente frecuente a la lista
			public void retirarCliente(ClienteFrecuente listaCliente) {
				
				listaClienteFrecuente.remove(listaCliente);
			}




}
