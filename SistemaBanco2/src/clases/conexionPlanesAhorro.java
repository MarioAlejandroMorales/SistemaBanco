package clases;

import java.sql.*;

import javax.swing.JOptionPane;

public class conexionPlanesAhorro {
	private Connection conexion;
	
	public void conectDatabase() 
	{
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "banco";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try
		{
			Class.forName(driver).newInstance();
			conexion= DriverManager.getConnection(url+dbName,userName,password);
		}
		catch(Exception e) 
		{
			System.err.println("Exception: "+e);
		}
	}//conectDatabase
	
	/*///////////////////////METODOS DE CONSULTA///////////////////////////////////*/
	public void insertarPlan(int n_Cuenta, String propietario, String tipo_Cuenta, int intereses, float saldo, int cvv)
	{
		String sql = "INSERT INTO planes_ahorro(n_Cuenta, idCliente, tipo_Cuenta, intereses, saldo, cvv)"
				+ " VALUES (?,?,?,?,?,?)";
		  
		conectDatabase();
			
		try 
		{
			PreparedStatement preparedStmt;
			preparedStmt = conexion.prepareStatement(sql);
			preparedStmt.setInt(1, n_Cuenta);
			preparedStmt.setString(2, propietario);
			preparedStmt.setString (3, tipo_Cuenta);
			preparedStmt.setInt(4, intereses);
			preparedStmt.setFloat (5, saldo);
			preparedStmt.setInt(6, cvv);
			
			preparedStmt.executeUpdate();
		      
		    conexion.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//insertarPlan
	
	public Object[] mostrarPlan(int idCuenta)
	{
		conectDatabase();
		
		try
		{
			String sql = "SELECT * from planes_ahorro WHERE n_Cuenta="+idCuenta+"";
			Statement st;
			st=conexion.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			Object a[]=new Object[6];
			
			if(rs.next())
			{
				a[0]=rs.getString(1);
				a[1]=rs.getString(2);
				a[2]=rs.getString(3);
				a[3]=rs.getString(4);
				a[4]=rs.getString(5);
				a[5]=rs.getString(6);
			}
			if(a!=null)
			{	
				conexion.close();
				return a;
			}
		}
		catch(Exception e) {
			
		}
		return null;
	}//mostrarPlan
	
	public Object[][] mostrarPlanes()
	{
		conectDatabase();
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) from planes_ahorro";
		Statement stmt;
		try
		{
			stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			Object a[][]= new Object [cont][6];
			sql = "SELECT * from planes_ahorro";
			rs = stmt.executeQuery(sql); 
			
			//System.out.println("The records are :"+rs);
			while(rs.next()) {
				a[i][0]=rs.getString(1);
				a[i][1]=rs.getString(2);
				a[i][2]=rs.getString(3);
				a[i][3]=rs.getString(4);
				a[i][4]=rs.getString(5);
				a[i][5]=rs.getString(6);
				
				i++;
			}
			if(a!=null) {
				conexion.close();
				return a;
			}
			
		}
		catch(Exception e) {
			
		}
		return null;
	}//mostrarPlanes
	
	public void modificarPlan(int n_Cuenta, String idCliente, String tipo_Cuenta, int intereses, float saldo, int cvv)
	{
		String sql = "UPDATE planes_ahorro SET tipo_Cuenta=?, intereses=?, saldo=?, cvv=? WHERE n_Cuenta =?";
		//n_Cuenta, propietario, tipo_Cuenta, intereses, saldo, cvv
		//propietario en tabla clientes se llama curp
		 
		conectDatabase();
		
		try {
			PreparedStatement preparedStmt;
			preparedStmt = conexion.prepareStatement(sql);
			preparedStmt.setString (1, tipo_Cuenta);
			preparedStmt.setInt(2, intereses);
			preparedStmt.setFloat (3, saldo);
			preparedStmt.setInt(4, cvv);
			preparedStmt.setInt(5, n_Cuenta);
			
			preparedStmt.executeUpdate();
		      
		    conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean clienteValido(String curp)
	{
		
		try 
		{
			conectDatabase();
			Object a[]=new Object[1];
			
			
			Statement st;
			String sql = "SELECT curp from cliente WHERE curp = \'"+curp+"\' ";
			st=conexion.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{
				a[0]=rs.getString(1);
			}
			if(a[0]!=null)
			{	
				conexion.close();
				//System.out.println ("curp"+a[0]);
				return true;
			}
		}
		catch(Exception errorClV)
		{
			
		}
		return false;
	}
}
