package com.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class paginaPrincipal extends JFrame {

	private JPanel contentPane;
	final ConsultaUsuario Usuario = new ConsultaUsuario();
	
	/**
	 * Create the frame.
	 */
	public paginaPrincipal()  {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\usuario.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JButton botonUsuario = new JButton("");

		botonUsuario.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\usuario.jpg"));
		botonUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.setVisible(true);
				dispose();
			}
		});
		
		JButton btnCliente = new JButton("");
		
		btnCliente.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\cliente2.jpg"));
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario.setVisible(true);
				dispose();	
			}
		});
		
		JButton btnProveedor = new JButton("");
	
		btnProveedor.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\Porveedor.jpg"));
		btnProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.setVisible(true);
				dispose();
			}
		});
		
		JButton btnInventario = new JButton("");
		
		btnInventario.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\Inventario.jpg"));
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				dispose();
			}
		});
		
		JButton btnVentas = new JButton("Ventas");
		btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario.setVisible(true);
				dispose();
			}
		});
		JLabel lblPaginaPrincipal = new JLabel("Gestion de Servicios");
		lblPaginaPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblCliente = new JLabel("Cliente\r\n");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblProveedor = new JLabel("Proveedor\r\n");
		lblProveedor.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblInventario = new JLabel("Inventario");
		lblInventario.setFont(new Font("Arial", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(242)
							.addComponent(lblPaginaPrincipal, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 605, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsuario)
									.addGap(75)
									.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(74)
									.addComponent(lblProveedor))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addComponent(botonUsuario, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(btnCliente, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnProveedor, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblInventario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnInventario, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblPaginaPrincipal)
					.addGap(54)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnProveedor, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
							.addComponent(btnInventario, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
						.addComponent(botonUsuario, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
						.addComponent(btnCliente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProveedor, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
