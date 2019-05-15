package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.dataconection.*;
import com.domain.Usuario;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;

public class Login extends JFrame {
	
	private JPanel contentPane;
	public static JTextField txt_usuario;
	public static JPasswordField txt_contraseña;
	final paginaPrincipal paginaPrincipal = new paginaPrincipal();

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txt_usuario = new JTextField();
		txt_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			
			

			public void actionPerformed(ActionEvent e) {
				try {
				PreparedStatement ps = DataConnectionUser.con.prepareStatement("Select * from Usuario where Nombre='"+txt_usuario.getText()+"'and Contraseña='"+txt_contraseña.getText()+"'");
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "!!Bienvenido!!");
					paginaPrincipal.setVisible(true);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrectos");	
				}
				}
				catch (Exception login) {
					System.out.println(e);
				}
				
				
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		txt_contraseña = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNombre))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(23)
							.addComponent(lblContrasea)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_contraseña, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
						.addComponent(txt_usuario, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
					.addGap(24))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(104)
					.addComponent(btnEntrar)
					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
					.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txt_usuario, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txt_contraseña, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalir)
						.addComponent(btnEntrar)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
