package paneles.empleados;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clases.conexionBD;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ModificarEmpleado extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTel;
	private JTextField textFieldDom;
	private JTextField textFieldFecha;
	private JTextField textFieldNSS;
	private JTextField textFieldCorreo;
	private JTextField textFieldSalario;
	private JTextField textFieldEntrada;
	private JTextField textFieldSalida;
	/**
	 * Create the frame.
	 */
	public ModificarEmpleado(String[] arra) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarEmpleado.class.getResource("/imagenes/LogoIcon.png")));
		setTitle("Systemoney (Modificar empleados)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 548, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblModificorEmpleados = new JLabel("MODIFICAR EMPLEADOS");
		lblModificorEmpleados.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblModificorEmpleados.setBounds(134, 13, 262, 36);
		contentPane.add(lblModificorEmpleados);
		
		JLabel label_1 = new JLabel("Datos personales");
		label_1.setBounds(12, 93, 120, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(12, 122, 120, 16);
		contentPane.add(label_2);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setText(arra[0]);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(147, 122, 116, 22);
		contentPane.add(textFieldNombre);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setBounds(275, 125, 120, 16);
		contentPane.add(label_3);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setText(arra[1]);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(404, 122, 116, 22);
		contentPane.add(textFieldApellido);
		
		JLabel label_4 = new JLabel("Telefono:");
		label_4.setBounds(12, 154, 120, 16);
		contentPane.add(label_4);
		
		textFieldTel = new JTextField();
		textFieldTel.setText(arra[2]);
		textFieldTel.setColumns(10);
		textFieldTel.setBounds(147, 151, 116, 22);
		contentPane.add(textFieldTel);
		
		JLabel label_5 = new JLabel("Domicilio:");
		label_5.setBounds(272, 154, 120, 16);
		contentPane.add(label_5);
		
		textFieldDom = new JTextField();
		textFieldDom.setText(arra[3]);
		textFieldDom.setColumns(10);
		textFieldDom.setBounds(404, 151, 116, 22);
		contentPane.add(textFieldDom);
		
		JLabel label_6 = new JLabel("Fecha de nacimiento:");
		label_6.setBounds(12, 186, 120, 16);
		contentPane.add(label_6);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setText(arra[4]);
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(147, 183, 116, 22);
		contentPane.add(textFieldFecha);
		
		JLabel label_7 = new JLabel("NSS:");
		label_7.setBounds(275, 186, 120, 16);
		contentPane.add(label_7);
		
		textFieldNSS = new JTextField();
		textFieldNSS.setText(arra[5]);
		textFieldNSS.setColumns(10);
		textFieldNSS.setBounds(404, 183, 116, 22);
		contentPane.add(textFieldNSS);
		
		JLabel label_8 = new JLabel("Correo:");
		label_8.setBounds(12, 221, 120, 16);
		contentPane.add(label_8);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setText(arra[6]);
		textFieldCorreo.setColumns(10);
		textFieldCorreo.setBounds(147, 218, 116, 22);
		contentPane.add(textFieldCorreo);
		
		JLabel label_9 = new JLabel("Sexo:");
		label_9.setBounds(275, 221, 120, 16);
		contentPane.add(label_9);
		
		JRadioButton radioButtonF = new JRadioButton("F");
		radioButtonF.setBounds(404, 214, 45, 25);
		contentPane.add(radioButtonF);
		
		JRadioButton radioButtonM = new JRadioButton("M");
		radioButtonM.setBounds(466, 214, 45, 25);
		contentPane.add(radioButtonM);
		
		if(arra[7].equals("F"))
			radioButtonF.setSelected(true);
		else
			radioButtonM.setSelected(true);
		JLabel label_10 = new JLabel("Salario:");
		label_10.setBounds(12, 253, 120, 16);
		contentPane.add(label_10);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setText(arra[8]);
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(147, 256, 116, 22);
		contentPane.add(textFieldSalario);
		
		JLabel label_11 = new JLabel("Horario:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_11.setBounds(12, 282, 120, 16);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("Hora de entrada:");
		label_12.setBounds(138, 306, 120, 16);
		contentPane.add(label_12);
		
		textFieldEntrada = new JTextField();
		textFieldEntrada.setText(arra[10]);
		textFieldEntrada.setColumns(10);
		textFieldEntrada.setBounds(138, 328, 116, 22);
		contentPane.add(textFieldEntrada);
		
		JLabel label_13 = new JLabel("Hora de salida:");
		label_13.setBounds(270, 306, 120, 16);
		contentPane.add(label_13);
		
		textFieldSalida = new JTextField();
		textFieldSalida.setText(arra[11]);
		textFieldSalida.setColumns(10);
		textFieldSalida.setBounds(270, 328, 116, 22);
		contentPane.add(textFieldSalida);
		
		JLabel label_14 = new JLabel("Dias:");
		label_14.setBounds(138, 363, 120, 16);
		contentPane.add(label_14);
		
		JCheckBox checkBoxL = new JCheckBox("L");
		checkBoxL.setBounds(106, 392, 45, 25);
		
		JCheckBox checkBoxM = new JCheckBox("M");
		checkBoxM.setBounds(155, 392, 45, 25);
		
		JCheckBox checkBoxI = new JCheckBox("I");
		checkBoxI.setBounds(204, 392, 45, 25);
		
		JCheckBox checkBoxJ = new JCheckBox("J");
		checkBoxJ.setBounds(253, 392, 45, 25);
		
		JCheckBox checkBoxV = new JCheckBox("V");
		checkBoxV.setBounds(302, 392, 45, 25);
		
		JCheckBox checkBoxS = new JCheckBox("S");
		checkBoxS.setBounds(351, 392, 45, 25);
		
		JCheckBox checkBoxD = new JCheckBox("D");
		checkBoxD.setBounds(400, 392, 45, 25);
		String dias= arra[9];
		for(int i=0;dias.length()>i;i++) {
			if( (dias.charAt(i)) == 'L')
				checkBoxL.setSelected(true);
			if( (dias.charAt(i)) == 'M')
				checkBoxM.setSelected(true);
			if( (dias.charAt(i)) == 'I')
				checkBoxI.setSelected(true);
			if( (dias.charAt(i)) == 'J')
				checkBoxJ.setSelected(true);
			if( (dias.charAt(i)) == 'V')
				checkBoxV.setSelected(true);
			if( (dias.charAt(i)) == 'S')
				checkBoxS.setSelected(true);
			if( (dias.charAt(i)) == 'D')
				checkBoxD.setSelected(true);
			//System.out.println(dias.charAt(i));
		}
		
		contentPane.add(checkBoxL);
		contentPane.add(checkBoxM);
		contentPane.add(checkBoxI);
		contentPane.add(checkBoxJ);
		contentPane.add(checkBoxV);
		contentPane.add(checkBoxS);
		contentPane.add(checkBoxD);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				conexionBD conexionBD = new conexionBD();
				
				String nombre=textFieldNombre.getText();
				String apellido=textFieldApellido.getText();
				String telefono=textFieldTel.getText();
				String domicilio=textFieldDom.getText();
				String fecha_nac=textFieldFecha.getText();
				String nss=textFieldNSS.getText();
				String correo=textFieldCorreo.getText();
				String sexo="";
				if(radioButtonF.isSelected()) {
					sexo="F";
				}else{
					if(radioButtonM.isSelected()) {
						sexo="M";
					}
				}
				String sueldo=textFieldSalario.getText();
				String horario="";
				String h_entrada=textFieldEntrada.getText();
				String h_salida=textFieldSalida.getText();
				
				if(checkBoxL.isSelected())
					horario+="L";
				if(checkBoxM.isSelected())
					horario+="M";
				if(checkBoxI.isSelected())
					horario+="I";
				if(checkBoxJ.isSelected())
					horario+="J";
				if(checkBoxV.isSelected())
					horario+="V";
				if(checkBoxS.isSelected())
					horario+="S";
				if(checkBoxD.isSelected())
					horario+="D";
				try {
					conexionBD.modificarEmpleado(nombre, apellido, telefono, domicilio, fecha_nac, nss, correo, sexo, sueldo, horario, h_entrada, h_salida, arra[12]);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnModificar.setBounds(202, 459, 126, 25);
		contentPane.add(btnModificar);
	}
}
