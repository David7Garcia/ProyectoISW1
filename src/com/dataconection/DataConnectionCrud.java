package com.dataconection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.domain.ClienteFrecuente;
import com.domain.Proveedor;
import com.domain.Usuario;


public class DataConnectionCrud {
	
	public static Connection con;
	
	public DataConnectionCrud(){
		performConnection();
	}
	
	public void performConnection() {
		String host = "127.0.0.1";
		String user = "root";
		String pass = "";
		String dtbs = "Tienda";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String newConnectionURL = "jdbc:mysql://" + host + "/" + dtbs
					+ "?" + "user=" + user + "&password=" + pass;
					con = DriverManager.getConnection(newConnectionURL);
		}catch (Exception e) {
			System.out.println("Error en l'obertura de la connexiÃ³.");
		}
		
	}
	
	public void closeConnection() {
		try {
			con.close();
		}catch (Exception e) {
			System.out.println("Error al cerrar conexion");
		}
	}
	
	public ArrayList<Usuario> retornaUsuario() throws SQLException{
		ArrayList<Usuario> ls = new ArrayList<Usuario>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario ORDER BY Id");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Usuario a = new Usuario(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Cargo"), rs.getString("Contraseña"), rs.getInt("DocumentoIdentidad"));
			
			ls.add(a);
		}
		rs.close();
		return ls;
	}
	
	public ArrayList<Usuario> retornaUsuarioM(Integer DocumentoIdentidad) throws SQLException{
		ArrayList<Usuario> ls = new ArrayList<Usuario>();
		PreparedStatement ps = con.prepareStatement("CALL consulta_usuario(?)");
		ps.setInt(1, DocumentoIdentidad);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Usuario a = new Usuario(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Cargo"), rs.getString("Contraseña"), rs.getInt("DocumentoIdentidad"));
			
			ls.add(a);
		}
		rs.close();
		return ls;
	}

	public void insertaUsuario(int Id, String Nombre, String Cargo, String Contraseña, int DocumentoIdentidad) throws SQLException {
		String Insert = "CALL insertar_usuario(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Insert);
		ps.setInt(1, Id); 
		ps.setString(2, Nombre);
		ps.setString(3, Cargo);
		ps.setString(4, Contraseña);
		ps.setInt(5, DocumentoIdentidad);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Usuario Guardado con Exito");
	}
	public void editaUsuario(int Id, String NuevoNombre,String NuevoCargo, int DocumentoIdentidad ) throws SQLException {
		JOptionPane.showMessageDialog(null, "Modificacion Realizada Con Exito");
		String Update = "CALL update_usuario(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Update);
		ps.setInt(1, Id); //es respuesta al primer interogant
		ps.setString(2, NuevoNombre); //es respuesta al segundo interogante
		ps.setString(3, NuevoCargo); //es respuesta al tercer interogant
		ps.setInt(4, DocumentoIdentidad); //es respuesta al cuarto interogant
		
		ps.executeUpdate();
	}
	
	public void eliminaUsuario(int documentoIdentidad) throws SQLException {
		String seleccio = "CALL delete_usuario(?)";
		PreparedStatement ps = con.prepareStatement(seleccio);
		ps.setInt(1, documentoIdentidad);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Usuario eliminado Exitosamente");
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<ClienteFrecuente> retornaCliente() throws SQLException{
		ArrayList<ClienteFrecuente> lsc = new ArrayList<ClienteFrecuente>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente ORDER BY DocumentoIdentidad");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ClienteFrecuente a = new ClienteFrecuente(rs.getString("Nombre"), rs.getInt("DocumentoIdentidad"),rs.getInt("puntos"));
			lsc.add(a);
		}
		rs.close();
		return lsc;
	}
	 
	
	public ArrayList<ClienteFrecuente> retornaClienteM(Integer DocumentoIdentidad) throws SQLException{
		ArrayList<ClienteFrecuente> ls = new ArrayList<ClienteFrecuente>();
		PreparedStatement ps = con.prepareStatement("CALL consulta_cliente(?)");
		ps.setInt(1, DocumentoIdentidad);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			ClienteFrecuente a = new ClienteFrecuente(rs.getString("Nombre"), rs.getInt("DocumentoIdentidad"),rs.getInt("puntos"));
			
			ls.add(a);
		}
		rs.close();
		return ls;
	}

	public void insertaCliente(String Nombre, int DocumentoIdentidad) throws SQLException {
		String Insert = "CALL ingresar_cliente(?,?)";
		PreparedStatement ps = con.prepareStatement(Insert);
		ps.setString(1, Nombre);
		ps.setInt(2, DocumentoIdentidad);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Cliente Guardado con Exito");
	}
	public void editaCliente(String NuevoNombre,int DocumentoIdentidad ) throws SQLException {
		JOptionPane.showMessageDialog(null, "Modificacion Realizada Con Exito");
		String Update = "CALL update_usuario(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Update);
		ps.setString(1, NuevoNombre); //es respuesta al segundo interogante
		ps.setInt(2, DocumentoIdentidad); //es respuesta al cuarto interogant
		
		ps.executeUpdate();
	}
	
	public void eliminaCliente(int documentoIdentidad) throws SQLException {
		String seleccio = "CALL delete_cliente(?)";
		PreparedStatement ps = con.prepareStatement(seleccio);
		ps.setInt(1, documentoIdentidad);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Cliente eliminado Exitosamente");
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Proveedor> retornaProveedor() throws SQLException{
		ArrayList<Proveedor> lsp = new ArrayList<Proveedor>();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM proveedor");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Proveedor a = new Proveedor(rs.getInt("Nit"), rs.getString("Nombre"), rs.getString("Correo"), rs.getString("Direccion"), rs.getInt("Telefono"));
			
			lsp.add(a);
		}
		rs.close();
		return lsp;
	}		
	 
	
	public ArrayList<Proveedor> retornaProveedorM(Integer Nit) throws SQLException{
		ArrayList<Proveedor> ls = new ArrayList<Proveedor>();
		PreparedStatement ps = con.prepareStatement("CALL consulta_proveedor(?)");
		ps.setInt(1, Nit);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Proveedor a = new Proveedor(rs.getInt("Nit"), rs.getString("Nombre"), rs.getString("Correo"), rs.getString("Direccion"), rs.getInt("Telefono"));
			
			ls.add(a);
		}
		rs.close();
		return ls;
	}

	public void insertaProveedor(int Nit,String Nombre,String Correo,String Direccion, long Telefono) throws SQLException {
		String Insert = "CALL insertar_proveedor(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Insert);
		ps.setInt(1, Nit);
		ps.setString(2, Nombre);
		ps.setString(3, Correo);
		ps.setString(4, Direccion);
		ps.setLong(5, Telefono);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Proveedor Guardado con Exito");
	
	}
	
	
	public void editaProveedor(int Nit ,String Nombre,String Correo,String Direccion, int Telefono ) throws SQLException {
		JOptionPane.showMessageDialog(null, "Modificacion Realizada Con Exito");
		String Update = "CALL update_Provedor(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(Update);
		ps.setInt(1, Nit);
		ps.setString(2, Nombre);
		ps.setString(3, Correo);
		ps.setString(4, Direccion);
		ps.setInt(5, Telefono);
		
		ps.executeUpdate();
	}
	
	public void eliminaProveedor(int Nit) throws SQLException {
		String seleccio = "CALL delete_proveedor(?)";
		PreparedStatement ps = con.prepareStatement(seleccio);
		ps.setInt(1, Nit);
		ps.executeUpdate();
		JOptionPane.showMessageDialog(null, "Cliente eliminado Exitosamente");
	}


	
}
