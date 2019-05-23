package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.dataconection.DataConnectionUser;
import com.domain.Usuario;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class crearUsuario extends JDialog {

	private static DataConnectionUser mc = new DataConnectionUser();
	private JPanel contentPane;
	boolean crea;
	Usuario a;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtCargo;
	private JTextField txtContraseña;
	private JTextField textDocumentoIdentificacion;

	/**
	 * Create the frame.
	 */
	public crearUsuario(final boolean crea, Usuario a) {
		setModal(true);
		this.crea=crea;
		this.a=a;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setColumns(10);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNombre.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCargo.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtContraseña = new JTextField();
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtContraseña.setColumns(10);
		
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
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\nuevoUsuario.jpg"));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(179)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel)
										.addGap(87)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNombre)
											.addComponent(lblCargo)
											.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
									.addComponent(lblContraseña))
								.addPreferredGap(ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblDocumentoIdentificion)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGuarda, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(132)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnCancela, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtNombre, 183, 183, Short.MAX_VALUE)
							.addComponent(txtCargo, 183, 183, Short.MAX_VALUE)
							.addComponent(txtContraseña, 183, 183, Short.MAX_VALUE)
							.addComponent(txtId)
							.addComponent(textDocumentoIdentificacion)))
					.addGap(154))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(98)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblId)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCargo))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblContraseña))
							.addGap(17))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(48)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDocumentoIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDocumentoIdentificion))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnGuarda, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancela, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		if(!crea){
			txtId.setEditable(false);
			txtId.setText(a.getId()+"");
			txtNombre.setText(a.getNombre());
			txtCargo.setText(a.getCargo());
			txtContraseña.setText(a.getDocumentoIdentificacion()+"");
		}
	}
	
	void crear() throws Exception{
		mc.insertaUsuario(Integer.parseInt(txtId.getText()), txtNombre.getText(), txtCargo.getText(), txtContraseña.getText(),Integer.parseInt( textDocumentoIdentificacion.getText()));
	}
	
	void modificar() throws Exception{
		mc.editaUsuario(a.getId(), a.getNombre(),a.getCargo(),a.getDocumentoIdentificacion());
	}
	
	void eliminar() throws Exception{
		mc.editaUsuario(a.getId(), a.getNombre(),a.getCargo(),a.getDocumentoIdentificacion());
	}
	
	
}
