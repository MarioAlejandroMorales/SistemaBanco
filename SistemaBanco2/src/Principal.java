import paneles.Ventana2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import clases.conexionBD;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Principal {

	private JFrame frmInicioSesion;
	private JTextField textFieldUsuario;
	private JPasswordField passwordFieldPass;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	private conexionBD conexionBD = new conexionBD();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmInicioSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Ventana2 ventana2 = new Ventana2();
		
		frmInicioSesion = new JFrame();
		frmInicioSesion.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Biblioteca\\Documentos\\Java\\SistemaBanco2\\src\\imagenes\\LogoLogin.png"));
		frmInicioSesion.setTitle("Inicio Sesion");
		frmInicioSesion.setBounds(screenSize.width/2-240, screenSize.height/2-175, 320, 175);
		frmInicioSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(141, 16, 116, 22);
		frmInicioSesion.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		passwordFieldPass = new JPasswordField();
		passwordFieldPass.setBounds(141, 48, 116, 22);
		frmInicioSesion.getContentPane().add(passwordFieldPass);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(59, 19, 70, 16);
		frmInicioSesion.getContentPane().add(lblUsuario);
		
		JLabel lblContrasenia = new JLabel("Contrase\u00F1a:");
		lblContrasenia.setBounds(59, 51, 70, 16);
		frmInicioSesion.getContentPane().add(lblContrasenia);
		
		JButton btnBtnIniciarSesion = new JButton("Iniciar sesion");
		btnBtnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*String usuario = "admin";
				String password = "123";
				String campoPassword = String.valueOf(passwordFieldPass.getPassword()); 
				if(textFieldUsuario.getText().equals(usuario) && campoPassword.equals(password) ) {
					frmInicioSesion.dispose();
					ventana2.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(frmInicioSesion, "Usuario o contraseña invalido.");
				}*/
				String usuario = textFieldUsuario.getText();
				String pass = String.valueOf(passwordFieldPass.getPassword());
				if(conexionBD.consultarLogin(usuario, pass).equals("")) {
					JOptionPane.showMessageDialog(frmInicioSesion, "Usuario o contraseña invalido.");
				}else {
					frmInicioSesion.dispose();
					ventana2.setVisible(true);
				}
			}
		});
		
		
		btnBtnIniciarSesion.setBounds(93, 83, 116, 34);
		frmInicioSesion.getContentPane().setLayout(null);
		frmInicioSesion.getContentPane().add(btnBtnIniciarSesion);
	}
}
