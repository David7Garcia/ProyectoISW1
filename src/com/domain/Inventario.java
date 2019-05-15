package com.domain;

import java.util.ArrayList;


public class Inventario extends Producto{


	Producto producto;


	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	// lista de tipo Array de tipo producto con sus respectivos get and set para acceder a los atributos
	public ArrayList<Producto> listaProductos = new ArrayList<Producto>();
	
	
	public Inventario(String id, String nombre, Float precio, int version, Float valorImpuesto, Producto producto,
			ArrayList<Producto> listaProductos) {
		super(id, nombre, precio, version, valorImpuesto);
		this.producto = producto;
		this.listaProductos = listaProductos;
	}
	

		public ArrayList<Producto> getListaProductos() {
			return listaProductos;
		}
	
		public void setListaProductos(ArrayList<Producto> listaProductos) {
			this.listaProductos = listaProductos;
		}
	
		//	Ingresar prodcuto	
		public void ingresarProducto(Producto produc){
			
			listaProductos.add(produc);
		}

		// Eliminar prodcuto
		public void retirarProducto(Producto produc) {
			
			listaProductos.remove(produc);
		}

		//imprimir inventario
		public String ImprimirInventario() {
			return super.ImprimirProducto() + "INVENTARIO [producto= "+producto+ "]";
		}

		


}
