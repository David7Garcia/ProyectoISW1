package com.view;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

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
	 * Crea el frame.
	 */
	public ConsultaUsuario() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\usuario.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JButton button = new JButton("<-- Atras");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new paginaPrincipal().setVisible(true);
			}
		});
		
		JLabel lblUsuariosExistentes = new JLabel("Usuarios Existentes");
		lblUsuariosExistentes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnCrear, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(81))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(274)
					.addComponent(lblUsuariosExistentes)
					.addContainerGap(286, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(button)
					.addGap(37)
					.addComponent(lblUsuariosExistentes)
					.addGap(29)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCrear, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
						.addComponent(btnModificar, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
					.addGap(64))
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
		tableUsr.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 25));
		tableUsr.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
