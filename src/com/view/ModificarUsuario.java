package com.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.dataconection.DataConnectionUser;
import com.domain.Usuario;

public class ModificarUsuario extends JFrame {

	private JPanel contentPane;
	private JTable tableUsr;
	private ArrayList<Usuario> Usuarios;
	
	private static DataConnectionUser mc = new DataConnectionUser();
	
	
	
	private JTextField txtDocumentoIdentidad;
	private JTextField txtIdnuevo;
	private JTextField txtNombreNuevo;
	private JTextField txtCargoNuevo;

	/**
	 * lanza la interfaz.
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
	 * Crea el frame.
	 */
	public ModificarUsuario() {
		setBackground(new Color(51, 204, 153));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\David7Garcia\\Desktop\\ProyectoISW1-Maestro_Final\\Imagenes\\usuario.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 499);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 204, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 25));
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
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		scrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		JLabel lblDocumentoIdentidad = new JLabel("Documento Identidad:");
		lblDocumentoIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtDocumentoIdentidad = new JTextField();
		txtDocumentoIdentidad.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtDocumentoIdentidad.setColumns(10);
		
		txtIdnuevo = new JTextField();
		txtIdnuevo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtIdnuevo.setColumns(10);
		
		txtNombreNuevo = new JTextField();
		txtNombreNuevo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtNombreNuevo.setColumns(10);
		
		txtCargoNuevo = new JTextField();
		txtCargoNuevo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtCargoNuevo.setColumns(10);
		
		JLabel lblNuevoId = new JLabel("Nuevo Id");
		lblNuevoId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Nombre");
		lblNuevoNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNuevoCargo = new JLabel("Nuevo Cargo");
		lblNuevoCargo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnAtras = new JButton("<-- Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new ConsultaUsuario().setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(103)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(226, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNuevoId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtIdnuevo, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNuevoNombre)
								.addComponent(txtNombreNuevo, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCargoNuevo, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNuevoCargo))
							.addGap(115))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 265, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 738, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDocumentoIdentidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNuevoCargo)
								.addComponent(lblNuevoId)
								.addComponent(lblNuevoNombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtCargoNuevo, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(txtIdnuevo, 0, 30, Short.MAX_VALUE)
								.addComponent(txtNombreNuevo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
					.addGap(81))
		);
		
		
		tableUsr = new JTable();
		tableUsr.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Cargo","Documento", "Objecte"
			}
		));
		tableUsr.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
		tableUsr.setFont(new Font("Tahoma", Font.PLAIN, 17));
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
		int respueta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (respueta == JOptionPane.YES_OPTION) {
			mc.eliminaUsuario((Integer.parseInt(txtDocumentoIdentidad.getText())));
			
		}
		
	}
}

		
