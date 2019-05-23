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

import com.dataconection.DataConnectionCrud;
import com.domain.ClienteFrecuente;
import com.domain.Proveedor;
import com.domain.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class ConsultaProveedor extends JFrame {

	private JPanel contentPane;
	private JTable tablePrv;
	private ArrayList<Proveedor> Proveedor;
	private static DataConnectionCrud mc = new DataConnectionCrud();

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
	public ConsultaProveedor() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\usuario.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		final ModificarProveedor Modificar = new ModificarProveedor();
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
					CrearProveedor ca = new CrearProveedor(true, null);
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
				new PaginaPrincipal().setVisible(true);
			}
		});
		
		JLabel lblUsuariosExistentes = new JLabel("Proveedores Existentes");
		lblUsuariosExistentes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
								.addGap(81)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblUsuariosExistentes)
							.addGap(252))))
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
		
		
		tablePrv = new JTable();
		tablePrv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nit", "Nombre", "Correo","Direccion","telefono", "Objecte"
			}
		));
		scrollPane.setViewportView(tablePrv);
		contentPane.setLayout(gl_contentPane);
		tablePrv.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 25));
		tablePrv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tablePrv.removeColumn(tablePrv.getColumn("Objecte"));
		try {
			actualizaLista();
		} catch (Exception e) {
			System.out.println("error Metodo Actualizalista");
		}
	}

	void actualizaLista() throws SQLException{
		Proveedor =mc.retornaProveedor();
		
		DefaultTableModel modelo = (DefaultTableModel)tablePrv.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Proveedor Prv : Proveedor) {
			Object [] fila = new Object[numCols]; // Hay cuatro columnas en la tabla
			
			fila[0] = Prv.getNit();
			fila[1] = Prv.getNombre();
			fila[2] = Prv.getCorreo();
			fila[3] = Prv.getDireccion();
			fila[4] = Prv.getTelefono();
			
			modelo.addRow(fila);
				
		}
	}
	
	
	void elimina() throws SQLException{
		int resposta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Proveedor user = (Proveedor)tablePrv.getModel().getValueAt(tablePrv.getSelectedRow(), 4);
			mc.eliminaUsuario(user.getNit());
		}
		actualizaLista();
	}
}
