package paneles.empleados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import clases.conexionBD;

import paneles.empleados.ModificarEmpleado;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MostrarEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JTable table;

	private conexionBD conexionBD = new conexionBD();
	private JTextField TextFieldCodigo;
	/**
	 * Create the frame.
	 */
	
	public MostrarEmpleados() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarEmpleados.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney(Mostrar Empleados)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object a[][] = conexionBD.consultarEmpleados();
		
		table = new JTable();
		table.setBounds(384, 87, 486, 199);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
			
			a,
			new String [] {
					"Nombre", "Apellido", "Telefono", "Domicilio", "Fecha_nacimiento", "NSS", "Correo", "Sexo", "Sueldo", "Horario", "Hora_entrada", "Hora_salida", "Codigo",
			}
			
			
		));

		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(12, 60, 1128, 334);
		contentPane.add(panel);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setBounds(12, 13, 85, 19);
		contentPane.add(lblEmpleados);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setBounds(1200, 79, 85, 19);
		contentPane.add(lblNewLabel);
		
		TextFieldCodigo = new JTextField();
		TextFieldCodigo.setBounds(1285, 77, 116, 22);
		contentPane.add(TextFieldCodigo);
		TextFieldCodigo.setColumns(10);
		
		JButton btnBuscar = new JButton("Modificar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String arra[]= new String [15];
				arra = conexionBD.consultarCodigo(TextFieldCodigo.getText());
				ModificarEmpleado modificarEmpleado = new ModificarEmpleado(arra);
				modificarEmpleado.setVisible(true);
			}
		});
		btnBuscar.setBounds(1200, 115, 97, 25);
		contentPane.add(btnBuscar);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(1200, 365, 97, 25);
		contentPane.add(btnAtras);
	}
}
