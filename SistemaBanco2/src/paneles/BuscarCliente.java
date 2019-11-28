package paneles;

import clases.Cliente;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionClientes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class BuscarCliente extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldCurp;
    private conexionClientes conexionClientes = new conexionClientes();
    private JLabel lblTelefono;
    private JLabel lblDomicilio;
    private JLabel lblCorreo;
    private JLabel lblBuscarCliente;

    /**
     * Create the frame.
     */
    public BuscarCliente() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarCliente.class.getResource("/imagenes/LogoIcon.png")));
        setTitle("Systemoney (Altas Clientes)");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 469, 473);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblBuscarCliente = new JLabel("BUSCAR CLIENTE");
        lblBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblBuscarCliente.setBounds(131, 11, 191, 36);
        contentPane.add(lblBuscarCliente);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(22, 153, 120, 16);
        contentPane.add(lblNombre);

        lblTelefono = new JLabel("Fecha de nacimiento:");
        lblTelefono.setBounds(22, 215, 120, 16);
        contentPane.add(lblTelefono);

        lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(22, 183, 120, 16);
        contentPane.add(lblDomicilio);

        JLabel lblFechaDeNacimiento = new JLabel("Tel\u00E9fono:");
        lblFechaDeNacimiento.setBounds(22, 245, 66, 16);
        contentPane.add(lblFechaDeNacimiento);

        JLabel lblDni = new JLabel("CURP:");
        lblDni.setBounds(22, 114, 120, 16);
        contentPane.add(lblDni);

        textFieldCurp = new JTextField();
        textFieldCurp.setColumns(10);
        textFieldCurp.setBounds(157, 111, 222, 22);
        contentPane.add(textFieldCurp);

        lblCorreo = new JLabel("Correo electr\u00F3nico:");
        lblCorreo.setBounds(22, 275, 110, 16);
        contentPane.add(lblCorreo);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(22, 307, 120, 16);
        contentPane.add(lblSexo);

        lblNombre.setVisible(false);
        lblFechaDeNacimiento.setVisible(false);
        lblTelefono.setVisible(false);
        lblSexo.setVisible(false);
        lblCorreo.setVisible(false);
        lblDomicilio.setVisible(false);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRegresar.setBounds(296, 382, 126, 25);
        contentPane.add(btnRegresar);

        JLabel lblInfo = new JLabel("Ingrese la CURP y haga click en el bot\u00F3n buscar");
        lblInfo.setBounds(22, 84, 357, 16);
        contentPane.add(lblInfo);

        JLabel lblNombreText = new JLabel("");
        lblNombreText.setBounds(156, 154, 223, 14);
        contentPane.add(lblNombreText);

        JLabel lblDomicilioText = new JLabel("");
        lblDomicilioText.setBounds(156, 184, 223, 14);
        contentPane.add(lblDomicilioText);

        JLabel lblFechaNacText = new JLabel("");
        lblFechaNacText.setBounds(156, 216, 223, 14);
        contentPane.add(lblFechaNacText);

        JLabel lblTelefonoText = new JLabel("");
        lblTelefonoText.setBounds(156, 245, 223, 14);
        contentPane.add(lblTelefonoText);

        JLabel lblCorreoText = new JLabel("");
        lblCorreoText.setBounds(156, 276, 223, 14);
        contentPane.add(lblCorreoText);

        JLabel lblSexoText = new JLabel("");
        lblSexoText.setBounds(156, 308, 223, 14);
        contentPane.add(lblSexoText);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Cliente cliente = conexionClientes.buscarCliente(textFieldCurp.getText());
                    if (cliente != null) {
                        lblNombre.setVisible(true);
                        lblFechaDeNacimiento.setVisible(true);
                        lblTelefono.setVisible(true);
                        lblSexo.setVisible(true);
                        lblCorreo.setVisible(true);
                        lblDomicilio.setVisible(true);
                        lblNombreText.setText(cliente.getNombre());
                        lblFechaNacText.setText(cliente.getFecha_nac());
                        lblDomicilioText.setText(cliente.getDomicilio());
                        lblTelefonoText.setText(cliente.getTelefono());
                        lblCorreoText.setText(cliente.getCorreo());
                        if (cliente.getSexo().equals("M")) {
                            lblSexoText.setText("Masculino");
                        } else {
                            lblSexoText.setText("Femenino");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un cliente con el CURP ingresado");
                    }
                } catch (SQLException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al buscar el cliente");
                }
            }
        });
        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBuscar.setBounds(129, 382, 126, 25);
        contentPane.add(btnBuscar);
    }
}
