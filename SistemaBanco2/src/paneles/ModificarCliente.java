package paneles;

import clases.Cliente;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionBD;

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

@SuppressWarnings("serial")
public class ModificarCliente extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldCurp;
    private JTextField textFieldTelefono;
    private conexionBD conexionBD = new conexionBD();
    private JLabel lblTelefono;
    private JTextField textFieldDomicilio;
    private JLabel lblDomicilio;
    private JLabel lblCorreo;
    private JTextField textFieldCorreo;
    private JLabel lblModificarCliente;
    private JLabel lblDatosDelCliente;
    private JTextField textFieldFechaNac;

    /**
     * Create the frame.
     */
    public ModificarCliente() {
        setTitle("Systemoney (Altas Clientes)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 549, 473);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblModificarCliente = new JLabel("MODIFICAR CLIENTE");
        lblModificarCliente.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblModificarCliente.setBounds(176, 11, 222, 36);
        contentPane.add(lblModificarCliente);

        lblDatosDelCliente = new JLabel("Modifique los datos del cliente");
        lblDatosDelCliente.setBounds(22, 155, 357, 16);
        contentPane.add(lblDatosDelCliente);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(22, 185, 120, 16);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(157, 185, 251, 22);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        lblTelefono = new JLabel("Fecha de nacimiento:");
        lblTelefono.setBounds(22, 248, 120, 16);
        contentPane.add(lblTelefono);

        lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(22, 218, 120, 16);
        contentPane.add(lblDomicilio);

        textFieldDomicilio = new JTextField();
        textFieldDomicilio.setColumns(10);
        textFieldDomicilio.setBounds(157, 215, 251, 22);
        contentPane.add(textFieldDomicilio);

        JLabel lblFechaDeNacimiento = new JLabel("Tel\u00E9fono:");
        lblFechaDeNacimiento.setBounds(22, 278, 66, 16);
        contentPane.add(lblFechaDeNacimiento);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setColumns(10);
        textFieldTelefono.setBounds(157, 275, 251, 22);
        contentPane.add(textFieldTelefono);

        JLabel lblDni = new JLabel("CURP:");
        lblDni.setBounds(22, 114, 120, 16);
        contentPane.add(lblDni);

        textFieldCurp = new JTextField();
        textFieldCurp.setColumns(10);
        textFieldCurp.setBounds(157, 111, 222, 22);
        contentPane.add(textFieldCurp);

        lblCorreo = new JLabel("Correo electr\u00F3nico:");
        lblCorreo.setBounds(22, 308, 110, 16);
        contentPane.add(lblCorreo);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setColumns(10);
        textFieldCorreo.setBounds(157, 305, 251, 22);
        contentPane.add(textFieldCorreo);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(22, 338, 120, 16);
        contentPane.add(lblSexo);

        ButtonGroup bg = new ButtonGroup();

        JRadioButton rdbtnF = new JRadioButton("F");
        rdbtnF.setBounds(158, 334, 45, 25);
        contentPane.add(rdbtnF);
        bg.add(rdbtnF);

        JRadioButton rdbtnM = new JRadioButton("M");
        rdbtnM.setBounds(205, 334, 45, 25);
        contentPane.add(rdbtnM);
        bg.add(rdbtnM);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String nombre = textFieldNombre.getText();
                String telefono = textFieldTelefono.getText();
                String domicilio = textFieldDomicilio.getText();
                String fecha_nac = textFieldFechaNac.getText();
                String curp = textFieldCurp.getText();
                String correo = textFieldCorreo.getText();
                String sexo = "";
                if (rdbtnF.isSelected()) {
                    sexo = "F";
                } else {
                    if (rdbtnM.isSelected()) {
                        sexo = "M";
                    }
                }
                try {
                    if (conexionBD.modificarCliente(nombre, fecha_nac, domicilio, telefono, curp, correo, sexo)) {
                        JOptionPane.showMessageDialog(null, "Modificación exitosa");
                        textFieldNombre.setText("");
                        textFieldTelefono.setText("");
                        textFieldDomicilio.setText("");
                        textFieldFechaNac.setText("");
                        textFieldCurp.setText("");
                        textFieldCorreo.setText("");
                        rdbtnF.setSelected(false);
                        rdbtnM.setSelected(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: verifique los datos ingresados");
                    }
                } catch (SQLException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Fallo al realizar la modificacion");
                    e.printStackTrace();
                }
            }
        });
        btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnModificar.setBounds(218, 387, 126, 25);
        contentPane.add(btnModificar);

        textFieldFechaNac = new JTextField();
        textFieldFechaNac.setBounds(157, 243, 251, 24);
        contentPane.add(textFieldFechaNac);
        textFieldFechaNac.setColumns(10);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRegresar.setBounds(385, 387, 126, 25);
        contentPane.add(btnRegresar);

        JLabel lblInfo = new JLabel("Ingrese la CURP y haga click en el bot\u00F3n buscar");
        lblInfo.setBounds(22, 84, 357, 16);
        contentPane.add(lblInfo);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Cliente cliente = conexionBD.buscarCliente(textFieldCurp.getText());
                    if (cliente != null) {
                        textFieldNombre.setText(cliente.getNombre());
                        textFieldFechaNac.setText(cliente.getFecha_nac());
                        textFieldDomicilio.setText(cliente.getDomicilio());
                        textFieldTelefono.setText(cliente.getTelefono());
                        textFieldCorreo.setText(cliente.getCorreo());
                        if (cliente.getSexo().equals("M")) {
                            rdbtnM.setSelected(true);
                        } else {
                            rdbtnF.setSelected(true);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un cliente con el CURP ingresado");
                    }
                } catch (SQLException | IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al buscar el cliente");
                }
            }
        });
        btnBuscar.setBounds(406, 111, 89, 23);
        contentPane.add(btnBuscar);
    }
}
