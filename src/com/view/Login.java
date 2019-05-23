package com.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dataconection.*;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;


public class Login extends JFrame {
	
	private JPanel contentPane;
	public static JTextField txt_usuario;
	public static JPasswordField txt_contraseña;
	final paginaPrincipal paginaPrincipal = new paginaPrincipal();

	/**
	 * Create the frame.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\fondo.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 371);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Usuario:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txt_usuario = new JTextField();
		txt_usuario.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txt_usuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 30));
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
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		txt_contraseña = new JPasswordField();
		txt_contraseña.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(lblContrasea)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(txt_usuario, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(txt_contraseña, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))))
					.addGap(20))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNombre)
					.addContainerGap(373, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txt_usuario, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblContrasea)
						.addComponent(txt_contraseña, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
