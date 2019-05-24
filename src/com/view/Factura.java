package com.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.domain.ClienteFrecuente;

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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Factura extends JFrame {

	private JPanel contentPane;
	private JTextField textCantidad1;
	private JTextField textProducto1;
	private JTextField textPrecio1;
	private JTextField textPtotal1;
	private JTextField textCantidad2;
	private JTextField textProducto2;
	private JTextField textPrecio2;
	private JTextField textPtotal2;
	private JTextField textsbtotal;
	private JTextField textIVA;
	private JTextField textTtotal;
	
	
	/**
	 * Create the frame.
	 */
	public Factura()  {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\usuario.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnVentas = new JButton("Cobrar\r\n");
		btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Double precio1,precio2,cant1,cant2,vtp1,vtp2,subtotal,IVA,valorTotal;
				precio1=Double.parseDouble(textPrecio1.getText());
				precio2=Double.parseDouble(textPrecio2.getText());
				cant1=Double.parseDouble(textCantidad1.getText());
				cant2=Double.parseDouble(textCantidad2.getText());
				vtp1=precio1*cant1;
				vtp2=precio2*cant2;
				
				String	valtotproducto1=vtp1+"";
				String	valtotproducto2=vtp2+"";
				
				textPtotal1.setText(valtotproducto1);
				textPtotal2.setText(valtotproducto2);
				
				subtotal=vtp1*vtp2;
				
				String sT = subtotal+"";
				textsbtotal.setText(sT);
				IVA=subtotal*0.19;
				String Iva = IVA+"";
				textIVA.setText(Iva);
				valorTotal=subtotal+IVA;
				String Total = valorTotal+"";
				textTtotal.setText(Total);
				
				
				
				
				
				
				
			
			
			
			
			}
		});
		JLabel lblPaginaPrincipal = new JLabel("Gestion de Servicios");
		lblPaginaPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblCliente = new JLabel("Producto");
		lblCliente.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblProveedor = new JLabel("Precio");
		lblProveedor.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblInventario = new JLabel("Precio total\r\n");
		lblInventario.setFont(new Font("Arial", Font.PLAIN, 20));
		
		textCantidad1 = new JTextField();
		textCantidad1.setColumns(10);
		
		textProducto1 = new JTextField();
		textProducto1.setColumns(10);
		
		textPrecio1 = new JTextField();
		textPrecio1.setColumns(10);
		
		textPtotal1 = new JTextField();
		textPtotal1.setColumns(10);
		
		textCantidad2 = new JTextField();
		textCantidad2.setColumns(10);
		
		textProducto2 = new JTextField();
		textProducto2.setColumns(10);
		
		textPrecio2 = new JTextField();
		textPrecio2.setColumns(10);
		
		textPtotal2 = new JTextField();
		textPtotal2.setColumns(10);
		
		textsbtotal = new JTextField();
		textsbtotal.setColumns(10);
		
		textIVA = new JTextField();
		textIVA.setColumns(10);
		
		textTtotal = new JTextField();
		textTtotal.setColumns(10);
		
		JLabel lblSubtotal = new JLabel("subtotal");
		lblSubtotal.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setFont(new Font("Arial", Font.PLAIN, 20));
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 20));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(242)
							.addComponent(lblPaginaPrincipal, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
							.addGap(143)
							.addComponent(lblTotal))
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(textCantidad1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(textCantidad2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
									.addGap(55))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCantidad, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textProducto2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(textProducto1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textPrecio1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPrecio2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProveedor))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInventario)
								.addComponent(textPtotal2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textPtotal1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
									.addComponent(lblSubtotal)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textTtotal, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textsbtotal, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
						.addComponent(textIVA, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
					.addGap(47))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(642, Short.MAX_VALUE)
					.addComponent(lblIva)
					.addGap(130))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPaginaPrincipal)
							.addGap(132))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCantidad)
								.addComponent(lblCliente, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProveedor, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textCantidad1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPrecio1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPtotal1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textsbtotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSubtotal)
						.addComponent(textProducto1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(lblIva, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCantidad2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textProducto2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPrecio2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPtotal2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textIVA, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(12)
								.addComponent(textTtotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnVentas))
						.addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(104))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
