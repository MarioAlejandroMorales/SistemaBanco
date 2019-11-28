package paneles;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import clases.conexionBD;
import clases.conexionTransfe;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MostrarTransferencias extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	private conexionTransfe conexionTransfe = new conexionTransfe();
	/**
	 * Create the frame.
	 */
	
	public MostrarTransferencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarTransferencias.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney(Mostrar transferencias)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1203, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object a[][] = conexionTransfe.consultarTransferencia();
		
		table = new JTable();
		table.setBounds(384, 87, 486, 199);
		contentPane.add(table);
		table.setModel(new DefaultTableModel(
			a,
			new String[] {
				"id", "Cuenta destino", "Razon", "Monto", "Cuenta origen"
			}
		));

		JScrollPane panel = new JScrollPane(table);
		panel.setBounds(28, 59, 1128, 334);
		contentPane.add(panel);
	}
}
