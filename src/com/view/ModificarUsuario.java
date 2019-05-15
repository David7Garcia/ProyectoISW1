package com.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dataconection.DataConnectionUser;
import com.domain.Usuario;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsr;
	private ArrayList<Usuario> Usuarios;
	private ArrayList<Usuario> modifica;
	
	private static DataConnectionUser mc = new DataConnectionUser();
	private JTextField txtDocumentoIdentidad;
	private JTextField txtIdnuevo;
	private JTextField txtNombreNuevo;
	private JTextField txtCargoNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarUsuario frame = new ModificarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					elimina();
				} catch (Exception e2) {
					System.out.println("error Boton eliminar");
				}
			}
		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					modificar();				
					actualizaLista();
					
				} catch (Exception e2) {
					System.out.println("error Boton modificar");
				}
			}
		});
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					actualizaLista();
				} catch (Exception e2) {
					System.out.println("error al buscar");
				}
			}
		});
	
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDocumentoIdentidad = new JLabel("Documento Identidad");
		
		txtDocumentoIdentidad = new JTextField();
		txtDocumentoIdentidad.setColumns(10);
		
		txtIdnuevo = new JTextField();
		txtIdnuevo.setColumns(10);
		
		txtNombreNuevo = new JTextField();
		txtNombreNuevo.setColumns(10);
		
		txtCargoNuevo = new JTextField();
		txtCargoNuevo.setColumns(10);
		
		JLabel lblNuevoId = new JLabel("Nuevo Id");
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre");
		
		JLabel lblNuevoCargo = new JLabel("Nuevo Cargo");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(50)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnModificar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnEliminar))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblDocumentoIdentidad)
									.addGap(36)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnBuscar)
										.addComponent(txtDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtIdnuevo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNuevoId, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNombreNuevo, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNuevoNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(21)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNuevoCargo)
								.addComponent(txtCargoNuevo, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDocumentoIdentidad))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNuevoId)
						.addComponent(lblNuevoNombre)
						.addComponent(lblNuevoCargo))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtIdnuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombreNuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCargoNuevo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnModificar))
					.addContainerGap())
		);
		
		
		tableUsr = new JTable();
		tableUsr.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Cargo","Documento", "Objecte"
			}
		));
		scrollPane.setViewportView(tableUsr);
		contentPane.setLayout(gl_contentPane);
		tableUsr.removeColumn(tableUsr.getColumn("Objecte"));
		try {
			actualizaLista();
		} catch (Exception e) {
			System.out.println("error Metodo Actualizalista");
		}
	}

	void actualizaLista() throws SQLException{
		Usuarios=mc.retornaUsuarioM(Integer.parseInt(txtDocumentoIdentidad.getText()) );
		
		DefaultTableModel modelo = (DefaultTableModel)tableUsr.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Usuario usr : Usuarios) {
			Object [] fila = new Object[numCols]; // Hay cuatro columnas en la tabla
			
			fila[0] = usr.getId();
			fila[1] = usr.getNombre();
			fila[2] = usr.getCargo();
			fila[3] = usr.getDocumentoIdentificacion();
			fila[4] = usr;
			
			modelo.addRow(fila);
				
		}
	}
	
	void modificar() throws SQLException{
		mc.editaUsuario(Integer.parseInt(txtIdnuevo.getText()),txtNombreNuevo.getText(),txtCargoNuevo.getText(),Integer.parseInt(txtDocumentoIdentidad.getText()));
		actualizaLista();
						
		}

	
	void elimina() throws SQLException{
		int resposta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Usuario user = (Usuario)tableUsr.getModel().getValueAt(tableUsr.getSelectedRow(), 4);
			mc.eliminaUsuario(user.getDocumentoIdentificacion());
		}
		actualizaLista();
	}
}

		
