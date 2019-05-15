package com.dataconection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.domain.Usuario;


public class DataConnectionUser {
	
	public static Connection con;
	
	public DataConnectionUser(){
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
		PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuario WHERE DocumentoIdentidad = ?");
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
		String Insert = "INSERT INTO `usuario` (`Id`,`Nombre`,`Cargo`,`Contraseña`,`DocumentoIdentidad`)VALUES (?,?,?,?,?)";
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
		String Update = "UPDATE `usuario` SET `Id` = ?,`Nombre`=?,`Cargo`=? WHERE `DocumentoIdentidad` =?";
		PreparedStatement ps = con.prepareStatement(Update);
		ps.setInt(1, Id); //es respuesta al primer interogant
		ps.setString(2, NuevoNombre); //es respuesta al segundo interogante
		ps.setString(3, NuevoCargo); //es respuesta al tercer interogant
		ps.setInt(4, DocumentoIdentidad); //es respuesta al cuarto interogant
		
		ps.executeUpdate();
	}
	
	public void eliminaUsuario(int numlic) throws SQLException {
		String seleccio = "DELETE FROM `atleta` WHERE `numllicencia` = ?";
		PreparedStatement ps = con.prepareStatement(seleccio);
		ps.setInt(1, numlic);
		ps.executeUpdate();
	}
}
