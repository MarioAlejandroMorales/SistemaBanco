package paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import clases.conexionPlanesAhorro;
import paneles.ventanaApertura;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ventanaPlanesAhorro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	private JTextField tBuscar;
	private conexionPlanesAhorro conexion=new conexionPlanesAhorro();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPlanesAhorro frame = new ventanaPlanesAhorro();
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
	public ventanaPlanesAhorro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaPlanesAhorro.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney(Cuentas)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 841, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		///////////////////////////////////////////////////////////////////////////Configuracion tabla
		tabla = new JTable();
		tabla.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
				}
			));
		scrollPane.setViewportView(tabla);
		//panel.add(tabla);
		///////////////////////////////////////////////////////////////////////////Configuracion tabla
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton bApertura = new JButton("Apertura");
		panel_1.add(bApertura);
		
		JLabel espacioBotones = new JLabel("");
		panel_1.add(espacioBotones);
		
		JLabel espacioBotones2 = new JLabel("");
		panel_1.add(espacioBotones2);
		
		JButton bModificar = new JButton("Modificar");
		bModificar.setEnabled(false);
		panel_1.add(bModificar);
		
		JButton bMostrarCuentas = new JButton("Mostrar Cuentas");
		panel_1.add(bMostrarCuentas);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		tBuscar = new JTextField();
		panel_2.add(tBuscar);
		tBuscar.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton bBuscar = new JButton("Buscar");
		panel_3.add(bBuscar);
		
		JLabel espacioTextoInferior = new JLabel(" ");
		panel_2.add(espacioTextoInferior, BorderLayout.SOUTH);
		
		JLabel espacioTextoSuperior = new JLabel(" ");
		panel_2.add(espacioTextoSuperior, BorderLayout.NORTH);
		
		JLabel espacioVentanaInferior = new JLabel(" ");
		contentPane.add(espacioVentanaInferior, BorderLayout.SOUTH);
		
		/////////////////////////////////////////////////////////////////listeners
		bApertura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//////////////////////btnApertura
				ventanaApertura nVentanaApertura=new ventanaApertura();
				nVentanaApertura.setVisible(true);
			}
		});
		bModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {/////////////////////////btnModificar
				String nCuenta=tabla.getValueAt(tabla.getSelectedRow(), 0).toString(); 
				String propietario=tabla.getValueAt(tabla.getSelectedRow(), 1).toString(); 
				String tCuenta=tabla.getValueAt(tabla.getSelectedRow(), 2).toString(); 
				String intereses=tabla.getValueAt(tabla.getSelectedRow(), 3).toString(); 
				String saldo=tabla.getValueAt(tabla.getSelectedRow(), 4).toString(); 
				String CVV=tabla.getValueAt(tabla.getSelectedRow(), 5).toString();
				
				ventanaModPlanesAhorro vMPA=new ventanaModPlanesAhorro(nCuenta, tCuenta, intereses, propietario, saldo, CVV);
				vMPA.setVisible(true);
			} 
		});
		bMostrarCuentas.addActionListener(new ActionListener() {
			@SuppressWarnings("serial")
			public void actionPerformed(ActionEvent e) {/////////////////////////btnMostrarCuentas
			
				Object a[][]=conexion.mostrarPlanes();
				tabla.setModel(new DefaultTableModel(
		 				a,
						new String [] {
								"N_Cuenta", "Propietario", "Tipo_Cuenta", "Intereses", "Saldo","CVV"}
					){
					boolean[] columnEditables = new boolean[] 
					{
							false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) 
					{
							return columnEditables[column];
					}
					});
				tabla.getColumnModel().getColumn(0).setResizable(false);
				tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
				tabla.getColumnModel().getColumn(1).setResizable(false);
				tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
				tabla.getColumnModel().getColumn(2).setResizable(false);
				tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
				tabla.getColumnModel().getColumn(3).setResizable(false);
				tabla.getColumnModel().getColumn(3).setPreferredWidth(40);
				tabla.getColumnModel().getColumn(4).setResizable(false);
				tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
				tabla.getColumnModel().getColumn(5).setResizable(false);
				tabla.getColumnModel().getColumn(5).setPreferredWidth(40);
				tabla.getTableHeader().setReorderingAllowed(false);
			}
		});
		bBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//////////////////////////btnBuscar
				int nCuenta=0;
				@SuppressWarnings("serial")
				DefaultTableModel model = new DefaultTableModel()
				{
					boolean[] columnEditables = new boolean[] 
					{
							false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) 
					{
							return columnEditables[column];
					}
				};
				model.setRowCount(0);
				tabla.setModel(model);
				try
				{
					nCuenta=Integer.parseInt(tBuscar.getText());
					Object ax[]= conexion.mostrarPlan(nCuenta);
					
					if(ax[0]!=null)
					{
						
						
						model.addColumn("N_Cuenta");
						model.addColumn("Propietario");
						model.addColumn("Tipo_Cuenta");
						model.addColumn("Intereses");	
						model.addColumn("Saldo");
						model.addColumn("CVV");
						model.addRow(ax);
				
						//tabla.setModel(model);
						tabla.getColumnModel().getColumn(0).setResizable(false);
						tabla.getColumnModel().getColumn(0).setPreferredWidth(80);
						tabla.getColumnModel().getColumn(1).setResizable(false);
						tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
						tabla.getColumnModel().getColumn(2).setResizable(false);
						tabla.getColumnModel().getColumn(2).setPreferredWidth(120);
						tabla.getColumnModel().getColumn(3).setResizable(false);
						tabla.getColumnModel().getColumn(3).setPreferredWidth(40);
						tabla.getColumnModel().getColumn(4).setResizable(false);
						tabla.getColumnModel().getColumn(4).setPreferredWidth(80);
						tabla.getColumnModel().getColumn(5).setResizable(false);
						tabla.getColumnModel().getColumn(5).setPreferredWidth(40);
						tabla.getTableHeader().setReorderingAllowed(false);
					}
				}
				catch(Exception bBuscar)
				{
					
				}
			}
		});
		ListSelectionModel seleccion=tabla.getSelectionModel();
		seleccion.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e) {//////////////////////seleccionTablaModificar
				
				if(!seleccion.isSelectionEmpty())
					bModificar.setEnabled(true);
				else
					bModificar.setEnabled(false);
				
				
				
			}
			
		});
		
	}

}
