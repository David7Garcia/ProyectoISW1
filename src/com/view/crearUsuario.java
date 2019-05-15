package com.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.dataconection.DataConnectionUser;
import com.domain.Usuario;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("Id:");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		
		JLabel lblDocumentoIdentificion = new JLabel("Documento de identificacion:");
		
		textDocumentoIdentificacion = new JTextField();
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
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblDocumentoIdentificion)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(165)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCargo)
										.addComponent(lblContraseña)
										.addComponent(lblNombre))
									.addGap(18)))
							.addComponent(btnGuarda)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancela))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textDocumentoIdentificacion, Alignment.TRAILING)
								.addComponent(txtContraseña, Alignment.TRAILING)
								.addComponent(txtCargo, Alignment.TRAILING)
								.addComponent(txtNombre, Alignment.TRAILING)
								.addComponent(txtId, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblId))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtCargo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNombre)
							.addGap(18)
							.addComponent(lblCargo)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtContraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContraseña))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textDocumentoIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDocumentoIdentificion))
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancela)
						.addComponent(btnGuarda))
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
}
