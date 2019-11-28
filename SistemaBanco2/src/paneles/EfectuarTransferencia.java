package paneles;

import clases.conexionTransfe;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class EfectuarTransferencia extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldOrigen;
	private JTextField textFieldDestino;
	private JTextField textFieldMonto;
	private JTextField textFieldRazon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EfectuarTransferencia frame = new EfectuarTransferencia();
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
	public EfectuarTransferencia() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EfectuarTransferencia.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney(Transferencia)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 505, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldOrigen = new JTextField();
		textFieldOrigen.setBounds(120, 28, 116, 22);
		contentPane.add(textFieldOrigen);
		textFieldOrigen.setColumns(10);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setBounds(356, 28, 116, 22);
		contentPane.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		textFieldMonto = new JTextField();
		textFieldMonto.setBounds(356, 63, 116, 22);
		contentPane.add(textFieldMonto);
		textFieldMonto.setColumns(10);
		
		textFieldRazon = new JTextField();
		textFieldRazon.setBounds(120, 63, 116, 22);
		contentPane.add(textFieldRazon);
		textFieldRazon.setColumns(10);
		
		JLabel lblCuentaOrigen = new JLabel("Cuenta origen:");
		lblCuentaOrigen.setBounds(12, 28, 96, 16);
		contentPane.add(lblCuentaOrigen);
		
		JLabel lblCuentaDestino = new JLabel("Cuenta destino:");
		lblCuentaDestino.setBounds(248, 28, 96, 16);
		contentPane.add(lblCuentaDestino);
		
		JLabel lblMonto = new JLabel("Monto:");
		lblMonto.setBounds(248, 63, 56, 16);
		contentPane.add(lblMonto);
		
		JLabel lblRazon = new JLabel("Razon:");
		lblRazon.setBounds(12, 63, 96, 16);
		contentPane.add(lblRazon);
		
		JButton btnEfectuar = new JButton("Efectuar");
		btnEfectuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexionTransfe conexionTransfe = new conexionTransfe();
				boolean aceptada=false;
				try {
					aceptada=conexionTransfe.efectuarTransferencia(textFieldOrigen.getText(), textFieldDestino.getText(), Integer.valueOf(textFieldMonto.getText(),10), textFieldRazon.getText());
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEfectuar.setBounds(187, 110, 97, 25);
		contentPane.add(btnEfectuar);
	}
}
