package paneles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.conexionPlanesAhorro;
import java.awt.Toolkit;

public class ventanaModPlanesAhorro extends JFrame {

	private JPanel contentPane;
	private JTextField textNCuenta;
	private JTextField textTCuenta;
	private JTextField textIntereses;
	private JTextField textCurp;
	private JTextField textCVV;
	private conexionPlanesAhorro conexion= new conexionPlanesAhorro();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaModPlanesAhorro frame = new ventanaModPlanesAhorro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); 
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public ventanaModPlanesAhorro(String nCuenta, String tCuenta, String intereses, String propietario, String saldo, String CVV) {
		setTitle("Systemoney(Modificar cuentas)");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanaModPlanesAhorro.class.getResource("/imagenes/LogoIcon.png")));
		int longCurp=18;
		int longNCuenta=9;
		int longTCuenta=40;
		int longCVV=5;
		int longInt=2;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNCuenta = new JLabel("N. Cuenta");
		lblNCuenta.setBounds(19, 14, 67, 20);
		panel.add(lblNCuenta);
		
		JLabel lblTCuenta = new JLabel("T. Cuenta");
		lblTCuenta.setBounds(19, 48, 67, 20);
		panel.add(lblTCuenta);
		
		JLabel lblIntereses = new JLabel("Intereses");
		lblIntereses.setBounds(19, 82, 67, 20);
		panel.add(lblIntereses);
		
		JLabel lblPropietario = new JLabel("Propietario");
		lblPropietario.setBounds(19, 116, 67, 20);
		panel.add(lblPropietario);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(19, 150, 67, 20);
		panel.add(lblSaldo);
		
		JLabel lblCVV = new JLabel("CVV");
		lblCVV.setBounds(19, 184, 67, 20);
		panel.add(lblCVV);
		
		textNCuenta = new JTextField();
		textNCuenta.setEditable(false);
		textNCuenta.setBounds(96, 14, 300, 20);
		panel.add(textNCuenta);
		textNCuenta.setColumns(10);
		
		textTCuenta = new JTextField();
		textTCuenta.setColumns(10);
		textTCuenta.setBounds(96, 48, 300, 20);
		panel.add(textTCuenta);
		
		textIntereses = new JTextField();
		textIntereses.setColumns(10);
		textIntereses.setBounds(96, 82, 300, 20);
		panel.add(textIntereses);
		
		textCurp = new JTextField();
		textCurp.setEditable(false);
		textCurp.setColumns(10);
		textCurp.setBounds(96, 116, 300, 20);
		panel.add(textCurp);
		
		JTextField textSaldo = new JTextField();
		textSaldo.setColumns(10);
		textSaldo.setBounds(96, 150, 300, 20);
		panel.add(textSaldo);
		
		textCVV = new JTextField();
		textCVV.setColumns(10);
		textCVV.setBounds(96, 184, 300, 20);
		panel.add(textCVV);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_1.add(btnAceptar);
		
		///////////////////////////////////////////////////////////////////////////Asignacion de valores
		textNCuenta.setText(nCuenta);
		textTCuenta.setText(tCuenta);
		textIntereses.setText(intereses);
		textCurp.setText(propietario);
		textSaldo.setText(saldo);
		textCVV.setText(CVV);
		///////////////////////////////////////////////////////////////////////////listeners
		
		textCurp.addKeyListener(new KeyListener(){////////////////////////textCurp18

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (textCurp.getText().length() >= longCurp) 
			        e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		textNCuenta.addKeyListener(new KeyListener(){////////////////////////nCuenta9

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (textNCuenta.getText().length() >= longNCuenta) 
			        e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		textIntereses.addKeyListener(new KeyListener(){////////////////////////Intereses2

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (textIntereses.getText().length() >= longInt) 
			        e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		textCVV.addKeyListener(new KeyListener(){////////////////////////CVV5

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (textCVV.getText().length() >= longCVV) 
			        e.consume();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			
		});
		
		
		btnAceptar.addActionListener(new ActionListener() {//////////////////////boton aceptar
			
			public void actionPerformed(ActionEvent arg0) {
				try 
				{
					
					conexion.modificarPlan(Integer.parseInt(textNCuenta.getText()), 
							textCurp.getText(), textTCuenta.getText(), Integer.parseInt(textIntereses.getText()),
							Float.parseFloat(textSaldo.getText()), Integer.parseInt(textCVV.getText()));
					dispose();
				}
				catch(Exception eer)
				{
					//frame 
					JOptionPane.showMessageDialog(null, "Por favor ingrese datos validos");
				}
			
			}
		
		});////////////////////////////////////////////////////////////////////////////////////boton aceptar
	}
}