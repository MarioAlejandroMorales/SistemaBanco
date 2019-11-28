package paneles;

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
public class AltasClientes extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldNombre;
    private JTextField textFieldCurp;
    private JTextField textFieldTelefono;
    private conexionClientes conexionClientes = new conexionClientes();
    private JLabel lblTelefono;
    private JTextField textFieldDomicilio;
    private JLabel lblDomicilio;
    private JLabel lblCorreo;
    private JTextField textFieldCorreo;
    private JLabel lblAltasDeClientes;
    private JLabel lblDatosDelCliente;
    private JTextField textFieldFechaNac;

    /**
     * Create the frame.
     */
    public AltasClientes() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(AltasClientes.class.getResource("/imagenes/LogoIcon.png")));
        setTitle("Systemoney (Altas Clientes)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 599, 396);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblAltasDeClientes = new JLabel("ALTAS DE CLIENTES");
        lblAltasDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 23));
        lblAltasDeClientes.setBounds(195, 11, 209, 36);
        contentPane.add(lblAltasDeClientes);

        lblDatosDelCliente = new JLabel("Datos del cliente");
        lblDatosDelCliente.setBounds(12, 93, 120, 16);
        contentPane.add(lblDatosDelCliente);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(12, 122, 120, 16);
        contentPane.add(lblNombre);

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(147, 122, 373, 22);
        contentPane.add(textFieldNombre);
        textFieldNombre.setColumns(10);

        lblTelefono = new JLabel("Fecha de nacimiento:");
        lblTelefono.setBounds(12, 160, 120, 16);
        contentPane.add(lblTelefono);

        lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(272, 160, 120, 16);
        contentPane.add(lblDomicilio);

        textFieldDomicilio = new JTextField();
        textFieldDomicilio.setColumns(10);
        textFieldDomicilio.setBounds(404, 157, 116, 22);
        contentPane.add(textFieldDomicilio);

        JLabel lblFechaDeNacimiento = new JLabel("Tel\u00E9fono:");
        lblFechaDeNacimiento.setBounds(12, 192, 120, 16);
        contentPane.add(lblFechaDeNacimiento);

        textFieldTelefono = new JTextField();
        textFieldTelefono.setColumns(10);
        textFieldTelefono.setBounds(147, 189, 116, 22);
        contentPane.add(textFieldTelefono);

        JLabel lblDni = new JLabel("CURP:");
        lblDni.setBounds(275, 192, 120, 16);
        contentPane.add(lblDni);

        textFieldCurp = new JTextField();
        textFieldCurp.setColumns(10);
        textFieldCurp.setBounds(404, 189, 116, 22);
        contentPane.add(textFieldCurp);

        lblCorreo = new JLabel("Correo electr\u00F3nico:");
        lblCorreo.setBounds(12, 227, 120, 16);
        contentPane.add(lblCorreo);

        textFieldCorreo = new JTextField();
        textFieldCorreo.setColumns(10);
        textFieldCorreo.setBounds(147, 224, 116, 22);
        contentPane.add(textFieldCorreo);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(12, 264, 120, 16);
        contentPane.add(lblSexo);

        ButtonGroup bg = new ButtonGroup();

        JRadioButton rdbtnF = new JRadioButton("F");
        rdbtnF.setSelected(true);
        rdbtnF.setBounds(148, 260, 45, 25);
        contentPane.add(rdbtnF);
        bg.add(rdbtnF);

        JRadioButton rdbtnM = new JRadioButton("M");
        rdbtnM.setBounds(195, 260, 45, 25);
        contentPane.add(rdbtnM);
        bg.add(rdbtnM);

        JButton btnDarDeAlta = new JButton("Dar de alta");
        btnDarDeAlta.addActionListener(new ActionListener() {
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
                    conexionClientes.insertCliente(nombre, fecha_nac, domicilio, telefono, curp, correo, sexo);
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    textFieldNombre.setText("");
                    textFieldTelefono.setText("");
                    textFieldDomicilio.setText("");
                    textFieldFechaNac.setText("");
                    textFieldCurp.setText("");
                    textFieldCorreo.setText("");
                    rdbtnF.setSelected(true);
//					dispose();
                } catch (SQLException | IOException e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(null, "Fallo al realizar el registro");
                    e.printStackTrace();
                }
            }
        });
        btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnDarDeAlta.setBounds(252, 304, 126, 25);
        contentPane.add(btnDarDeAlta);

        textFieldFechaNac = new JTextField();
        textFieldFechaNac.setBounds(147, 155, 116, 24);
        contentPane.add(textFieldFechaNac);
        textFieldFechaNac.setColumns(10);

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                dispose();
            }
        });
        btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnRegresar.setBounds(404, 304, 126, 25);
        contentPane.add(btnRegresar);
    }
}
