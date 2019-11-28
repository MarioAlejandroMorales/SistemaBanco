package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.conexionClientes;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MostrarClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private conexionClientes conexionClientes = new conexionClientes();
	private JButton btnRegresar;
	/**
	 * Create the frame.
	 */
	
	public MostrarClientes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarClientes.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Mostrar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1157, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object a[][] = conexionClientes.consultarClientes();
		
		table = new JTable();
		table.setBounds(384, 87, 486, 199);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
			
			a,
			new String [] {
					"Nombre", "Sexo", "Fecha_nacimiento", "Domicilio", "Telefono", "Correo", "CURP"
			}
			
			
		));

		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(12, 60, 1128, 334);
		contentPane.add(panel);
		
		JLabel lblCliente = new JLabel("Clientes");
		lblCliente.setBounds(12, 13, 85, 19);
		contentPane.add(lblCliente);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnRegresar.setBounds(1043, 425, 97, 25);
		contentPane.add(btnRegresar);
	}
}
