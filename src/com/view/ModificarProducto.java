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

import com.dataconection.DataConnectionCrud;
import com.domain.Producto;
import com.domain.Proveedor;
import com.domain.Usuario;

public class ModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTable tablePrv;
	private ArrayList<Producto> Producto;
	
	private static DataConnectionCrud mc = new DataConnectionCrud();
	
	
	
	private JTextField txtId;
	private JTextField txtIdNombre;
	private JTextField txtPrecio;

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
	public ModificarProducto() {
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
		
		
		JLabel lblId = new JLabel("Id\r\n:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txtId.setColumns(10);
		
		txtIdNombre = new JTextField();
		txtIdNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtIdNombre.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtPrecio.setColumns(10);
		
		JLabel lblNuevoId = new JLabel("Nuevo Nombre");
		lblNuevoId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNuevoNombre = new JLabel("Nuevo Precio");
		lblNuevoNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnAtras = new JButton("<-- Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new ConsultaProducto().setVisible(true);
			}
		});
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(293)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(226, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNuevoId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtIdNombre, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPrecio, 0, 0, Short.MAX_VALUE)
								.addComponent(lblNuevoNombre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(306))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 371, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 738, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBuscar, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNuevoId)
								.addComponent(lblNuevoNombre))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtIdNombre, 0, 30, Short.MAX_VALUE)
								.addComponent(txtPrecio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(37)
							.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(54)
							.addComponent(btnEliminar, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
					.addGap(81))
		);
		
		
		tablePrv = new JTable();
		tablePrv.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nombre", "Precio", "Objecte"
			}
		));
		tablePrv.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 20));
		tablePrv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setViewportView(tablePrv);
		contentPane.setLayout(gl_contentPane);
		tablePrv.removeColumn(tablePrv.getColumn("Objecte"));
		try {
			actualizaLista();
		} catch (Exception e) {
			System.out.println("error Metodo Actualizalista");
		}
	}

	void actualizaLista() throws SQLException{
		
		Producto=mc.retornaProductoM(Integer.parseInt(txtId.getText()) );
		
		DefaultTableModel modelo = (DefaultTableModel)tablePrv.getModel();
		while (modelo.getRowCount() > 0) modelo.removeRow(0);
		int numCols = modelo.getColumnCount();
		for (Producto Prd : Producto) {
			Object [] fila = new Object[numCols]; 
			
			fila[0] = Prd.getId();
			fila[1] = Prd.getNombre();
			fila[2] = Prd.getPrecio();
			fila[3] = Prd;
			
			modelo.addRow(fila);
			
		}
	}
	
	void modificar() throws SQLException{
		mc.editaProducto(Integer.parseInt(txtId.getText()), txtIdNombre.getText(), Integer.parseInt(txtPrecio.getText()));
		actualizaLista();
						
		}
	void elimina() throws SQLException{
		int respueta = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar?", "Eliminar", JOptionPane.YES_NO_OPTION);
		if (respueta == JOptionPane.YES_OPTION) {
			mc.eliminaProducto((Integer.parseInt(txtId.getText())));
			
		}
		
	}
}

		
