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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dataconection.DataConnectionUser;
import com.domain.Usuario;

public class ConsultaUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsr;
	private ArrayList<Usuario> Usuarios;
	private static DataConnectionUser mc = new DataConnectionUser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaUsuario frame = new ConsultaUsuario();
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
	public ConsultaUsuario() {
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
		final ModificarUsuario Modificar = new ModificarUsuario();
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Modificar.setVisible(true);
					dispose();
					}}
		);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					crearUsuario ca = new crearUsuario(true, null);
					ca.setVisible(true);
					//
					actualizaLista();
				} catch (Exception e2) {
					System.out.println("error3");
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnCrear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnModificar)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEliminar))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEliminar)
						.addComponent(btnModificar)
						.addComponent(btnCrear))
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
		Usuarios=mc.retornaUsuario();
		
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
	
	void elimina() throws SQLException{
		int resposta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Usuario user = (Usuario)tableUsr.getModel().getValueAt(tableUsr.getSelectedRow(), 4);
			mc.eliminaUsuario(user.getDocumentoIdentificacion());
		}
		actualizaLista();
	}
}
