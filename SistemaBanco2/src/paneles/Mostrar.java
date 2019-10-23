package paneles;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Mostrar extends JFrame {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


	/**
	 * Create the frame.
	 */
	public Mostrar() {
		setTitle("Systemoney");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		ImageIcon icoPeli = new ImageIcon("D:\\Biblioteca\\Documentos\\Java\\Cine\\src\\imagenes\\Polimex.png");
		Image imgPeli = icoPeli.getImage(); //convertimos icon en una imagen
		Image otraimg = imgPeli.getScaledInstance(202,227,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroico = new ImageIcon(otraimg);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(otroico);
		lblLogo.setBounds(10, 39, 287, 277);
		contentPane.add(lblLogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 206, 26);
		contentPane.add(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAltas = new JMenuItem("Altas");
		mnEmpleados.add(mntmAltas);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mnEmpleados.add(mntmMostrar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(122, 143, 56, 16);
		contentPane.add(lblNewLabel);
		
		JMenuItem mntmCartelera = new JMenuItem("Cartelera");
		mntmCartelera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel.setText("hola");
			}
		});
		menuBar.add(mntmCartelera);
		
		
	}
}
