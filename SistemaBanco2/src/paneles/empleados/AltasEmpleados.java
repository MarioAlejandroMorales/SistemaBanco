package paneles.empleados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class AltasEmpleados extends JFrame {
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldNss;
	private JTextField textFieldFechaNac;
	private JLabel lblSalario;
	private JTextField textFieldSalario;
	private JLabel lblHorario;
	private JLabel lblHEntrada;
	private JTextField textFieldHEntrada;
	private JLabel lblHSalida;
	private JTextField textFieldHSalida;
	private JLabel lblDias;
	private conexionBD conexionBD = new conexionBD();
	private JTextField textFieldApellido;
	private JLabel lblTelefono;
	private JTextField textFieldTelefono;
	private JTextField textFieldDomicilio;
	private JLabel lblDomicilio;
	private JLabel lblCorreo;
	private JTextField textFieldCorreo;
	private JLabel lblNip;
	private JTextField textFieldNip;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;


	/**
	 * Create the frame.
	 */
	public AltasEmpleados() {
		setTitle("Systemoney (Altas Empleados)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0,0,599,650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("ALTAS DE EMPLEADOS");
		label.setFont(new Font("Tahoma", Font.PLAIN, 23));
		label.setBounds(167, 13, 246, 36);
		contentPane.add(label);
		
		label_1 = new JLabel("Datos personales");
		label_1.setBounds(12, 93, 120, 16);
		contentPane.add(label_1);
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 122, 120, 16);
		contentPane.add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(147, 122, 116, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApelido = new JLabel("Apellido:");
		lblApelido.setBounds(275, 125, 120, 16);
		contentPane.add(lblApelido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(404, 122, 116, 22);
		contentPane.add(textFieldApellido);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(12, 160, 120, 16);
		contentPane.add(lblTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(147, 157, 116, 22);
		contentPane.add(textFieldTelefono);
		
		lblDomicilio = new JLabel("Domicilio:");
		lblDomicilio.setBounds(272, 160, 120, 16);
		contentPane.add(lblDomicilio);
		
		textFieldDomicilio = new JTextField();
		textFieldDomicilio.setColumns(10);
		textFieldDomicilio.setBounds(404, 157, 116, 22);
		contentPane.add(textFieldDomicilio);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(12, 192, 120, 16);
		contentPane.add(lblFechaDeNacimiento);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setColumns(10);
		textFieldFechaNac.setBounds(147, 189, 116, 22);
		contentPane.add(textFieldFechaNac);
		
		JLabel lblDni = new JLabel("NSS:");
		lblDni.setBounds(275, 192, 120, 16);
		contentPane.add(lblDni);
		
		textFieldNss = new JTextField();
		textFieldNss.setColumns(10);
		textFieldNss.setBounds(404, 189, 116, 22);
		contentPane.add(textFieldNss);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(12, 227, 120, 16);
		contentPane.add(lblCorreo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(147, 224, 116, 22);
		contentPane.add(textFieldCorreo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(275, 227, 120, 16);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(404, 220, 45, 25);
		contentPane.add(rdbtnF);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(466, 220, 45, 25);
		contentPane.add(rdbtnM);
		
		
		label_2 = new JLabel("Datos proporcionados para la empresa");
		label_2.setBounds(12, 273, 282, 16);
		contentPane.add(label_2);
		
		lblSalario = new JLabel("Salario:");
		lblSalario.setBounds(22, 302, 120, 16);
		contentPane.add(lblSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(147, 302, 116, 22);
		contentPane.add(textFieldSalario);
		
		lblHorario = new JLabel("Horario:");
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHorario.setBounds(97, 331, 120, 16);
		contentPane.add(lblHorario);
		
		lblHEntrada = new JLabel("Hora de entrada:");
		lblHEntrada.setBounds(129, 358, 120, 16);
		contentPane.add(lblHEntrada);
		
		textFieldHEntrada = new JTextField();
		textFieldHEntrada.setColumns(10);
		textFieldHEntrada.setBounds(129, 380, 116, 22);
		contentPane.add(textFieldHEntrada);
		
		lblHSalida = new JLabel("Hora de salida:");
		lblHSalida.setBounds(261, 358, 120, 16);
		contentPane.add(lblHSalida);
		
		textFieldHSalida = new JTextField();
		textFieldHSalida.setColumns(10);
		textFieldHSalida.setBounds(261, 380, 116, 22);
		contentPane.add(textFieldHSalida);
		
		lblDias = new JLabel("Dias:");
		lblDias.setBounds(129, 415, 120, 16);
		contentPane.add(lblDias);
		
		JCheckBox chckbxL = new JCheckBox("L");
		chckbxL.setBounds(97, 444, 45, 25);
		contentPane.add(chckbxL);
		
		JCheckBox chckbxM = new JCheckBox("M");
		chckbxM.setBounds(146, 444, 45, 25);
		contentPane.add(chckbxM);
		
		JCheckBox chckbxI = new JCheckBox("I");
		chckbxI.setBounds(195, 444, 45, 25);
		contentPane.add(chckbxI);
		
		JCheckBox chckbxJ = new JCheckBox("J");
		chckbxJ.setBounds(244, 444, 45, 25);
		contentPane.add(chckbxJ);
		
		JCheckBox chckbxV = new JCheckBox("V");
		chckbxV.setBounds(293, 444, 45, 25);
		contentPane.add(chckbxV);
		
		JCheckBox chckbxS = new JCheckBox("S");
		chckbxS.setBounds(342, 444, 45, 25);
		contentPane.add(chckbxS);
		
		JCheckBox chckbxD = new JCheckBox("D");
		chckbxD.setBounds(391, 444, 45, 25);
		contentPane.add(chckbxD);
		
		lblNip = new JLabel("Nip:");
		lblNip.setBounds(275, 302, 120, 16);
		contentPane.add(lblNip);
		
		textFieldNip = new JTextField();
		textFieldNip.setColumns(10);
		textFieldNip.setBounds(404, 299, 116, 22);
		contentPane.add(textFieldNip);
		
		JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTelefono.getText();
				String domicilio=textFieldDomicilio.getText();
				String fecha_nac=textFieldFechaNac.getText();
				String nss=textFieldNss.getText();
				String correo=textFieldCorreo.getText();
				String sexo="";
				if(rdbtnF.isSelected()) {
					sexo="F";
				}else{
					if(rdbtnM.isSelected()) {
						sexo="M";
					}
				}
				String sueldo=textFieldSalario.getText();
				String horario="";
				String hora_entrada=textFieldHEntrada.getText();
				String hora_salida=textFieldHSalida.getText();
				
				if(chckbxL.isSelected())
					horario+="L";
				if(chckbxM.isSelected())
					horario+="M";
				if(chckbxI.isSelected())
					horario+="I";
				if(chckbxJ.isSelected())
					horario+="J";
				if(chckbxV.isSelected())
					horario+="V";
				if(chckbxS.isSelected())
					horario+="S";
				if(chckbxD.isSelected())
					horario+="D";
				Random r = new Random();
				int codigo_r = r.nextInt(10000);
				String codigo=String.valueOf(codigo_r);
				String nip=textFieldNip.getText();
				
				try {
					conexionBD.insertEmpleado(nombre, apellido, telefono, domicilio, fecha_nac, nss, correo, sexo, sueldo, horario, hora_entrada, hora_salida, codigo, nip);
					JOptionPane.showInternalMessageDialog(contentPane, "El codigo es: "+codigo);
					dispose();
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDarDeAlta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDarDeAlta.setBounds(227, 541, 126, 25);
		contentPane.add(btnDarDeAlta);
		
	}
}
