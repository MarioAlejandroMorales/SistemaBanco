package paneles;

import paneles.empleados.AltasEmpleados;
import paneles.empleados.MostrarEmpleados;
import paneles.AltasClientes;
import paneles.MostrarClientes;
import paneles.ventanaPlanesAhorro;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Toolkit;


@SuppressWarnings("serial")
public class Ventana2 extends JFrame {

	private JPanel contentPane;
	
    private JFrame getFrame(){
        return this;
    }
    
	/**
	 * Create the frame.
	 */
	public Ventana2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana2.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		ImageIcon icoPeli = new ImageIcon(Ventana2.class.getResource("/imagenes/LogoChico.png"));
		Image imgPeli = icoPeli.getImage(); //convertimos icon en una imagen
		Image otraimg = imgPeli.getScaledInstance(426,257,java.awt.Image.SCALE_SMOOTH);
		ImageIcon otroico = new ImageIcon(otraimg);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel(otroico);
		lblLogo.setBounds(10, 39, 426,257);
		contentPane.add(lblLogo);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 455, 26);
		contentPane.add(menuBar);
		
		JMenu mnEmpleados = new JMenu("Empleados");
		menuBar.add(mnEmpleados);
		
		JMenuItem mntmAltas = new JMenuItem("Altas");
		mntmAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltasEmpleados altasEmpleados = new AltasEmpleados(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				altasEmpleados.setVisible(true);
				dispose();
			}
		});
		mnEmpleados.add(mntmAltas);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarEmpleados mostrarEmpleados = new MostrarEmpleados(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				mostrarEmpleados.setVisible(true);
				dispose();
			}
		});
		mnEmpleados.add(mntmMostrar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenuItem menuItem = new JMenuItem("Altas");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltasClientes altasClientes = new AltasClientes(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				altasClientes.setVisible(true);
				dispose();
			}
		});
		mnClientes.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Mostrar");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarClientes mostrarClientes = new MostrarClientes(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				mostrarClientes.setVisible(true);
				dispose();
			}
		});
		mnClientes.add(menuItem_1);
		
		JMenuItem mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCliente modificarClientes = new ModificarCliente(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
				modificarClientes.setVisible(true);
				dispose();
			}
		});
		mnClientes.add(mntmModificar);
		
		JMenuItem mntmCuentas = new JMenuItem("Planes de ahorro y cuentas");
		mntmCuentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPlanesAhorro ventanaPlanesAhorro = new ventanaPlanesAhorro(){
			        //Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
			    };
			    ventanaPlanesAhorro.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmCuentas);
		
		JMenu mnTransferencias = new JMenu("Transferencias");
		menuBar.add(mnTransferencias);
		
		JMenuItem mntmEfectuar = new JMenuItem("Efectuar");
		mntmEfectuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EfectuarTransferencia efectuarTransferencia = new EfectuarTransferencia() {
					//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
				};
				efectuarTransferencia.setVisible(true);
				dispose();
				
			}
		});
		mnTransferencias.add(mntmEfectuar);
		
		JMenuItem mntmMostrar_1 = new JMenuItem("Mostrar");
		mntmMostrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MostrarTransferencias mostrarTransferencias = new MostrarTransferencias() {
					//Con esto cuando llamemos a dispose de vNueva abrimos la principal
			        @Override
			        public void dispose(){
			            //Hacemos visible la principal
			            getFrame().setVisible(true);
			            //Cerramos vNueva
			            super.dispose();
			        }
				};
				mostrarTransferencias.setVisible(true);
				dispose();
			}
		});
		mnTransferencias.add(mntmMostrar_1);
		
		
	}
}
