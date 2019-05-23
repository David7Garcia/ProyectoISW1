package com.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.dataconection.DataConnectionCrud;
import com.domain.ClienteFrecuente;

public class CrearCliente extends JDialog {

	private static DataConnectionCrud mc = new DataConnectionCrud();
	private JPanel contentPane;
	boolean crea;
	ClienteFrecuente a;
	private JTextField txtNombre;
	private JTextField textDocumentoIdentificacion;

	/**
	 * Create the frame.
	 */
	public CrearCliente(final boolean crea, ClienteFrecuente a) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\usuario.jpg"));
		setModal(true);
		this.crea=crea;
		this.a=a;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setColumns(10);
		
		JLabel lblDocumentoIdentificion = new JLabel("Documento de identificacion:");
		lblDocumentoIdentificion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		textDocumentoIdentificacion = new JTextField();
		textDocumentoIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDocumentoIdentificacion.setColumns(10);
			
		
		JButton btnCancela = new JButton("Cancela");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnGuarda = new JButton("Guarda");
		btnGuarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(crea) crear();
					else modificar();
					
					dispose();
				} catch (Exception e2) {
					
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\nuevoCliente.jpg"));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(184)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblDocumentoIdentificion)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblNombre)))
							.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGuarda, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(136)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textDocumentoIdentificacion)
							.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
						.addComponent(btnCancela, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
					.addGap(134))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(89, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(27)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumentoIdentificion)
						.addComponent(textDocumentoIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuarda, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancela, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addGap(56))
		);
		contentPane.setLayout(gl_contentPane);
		
		if(!crea){
			txtNombre.setText(a.getNombre());
			textDocumentoIdentificacion.setText(a.getDocumentoDeIdentidad()+"");
		}
	}
	
	void crear() throws Exception{
		mc.insertaCliente(txtNombre.getText(), Integer.parseInt( textDocumentoIdentificacion.getText()));
	}
	
	void modificar() throws Exception{
		mc.editaCliente( a.getNombre(),a.getDocumentoDeIdentidad());
	}
	
	void eliminar() throws Exception{
		mc.editaCliente(a.getNombre(),a.getDocumentoDeIdentidad());
	}
	
	
}