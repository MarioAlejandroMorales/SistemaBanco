package clases;

import java.sql.*;

public class conexionTransfe {
	private Connection con=null;
	int saldo_origen, saldo_destino, monto;
	public void conectDatabase() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "banco";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "";
		
		try{
			Class.forName(driver).newInstance();
			con= DriverManager.getConnection(url+dbName,userName,password);
			
			/*if(!con.isClosed())
				System.out.println("Successfully conected to MySQL server...");*/
		}catch(Exception e) {
			System.err.println("Exception: "+e);
		}
	}
	
	public boolean consultarExistencia(String user) {
		conectDatabase();
		String sql = "SELECT * from planes_ahorro WHERE n_Cuenta='"+user+"'";
		Statement stmt;
		boolean cuenta=false;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cuenta=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuenta;
	}
	
	public int consultarSaldo(String user) {
		conectDatabase();
		String sql = "SELECT * from planes_ahorro WHERE n_Cuenta='"+user+"'";
		Statement stmt;
		//System.out.println(sql);
		int cuenta=0;
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//System.out.println("The records are :"+rs);
			if(rs.next())
				cuenta=rs.getInt("saldo");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cuenta;
	}
	
	public boolean efectuarTransferencia(String cuentaOrigen, String cuentaDestino, int monto, String razon) throws SQLException {
		if(consultarExistencia(cuentaOrigen) && consultarExistencia(cuentaDestino)) {
			saldo_origen=consultarSaldo(cuentaOrigen);
			saldo_destino=consultarSaldo(cuentaDestino);
			
			if((saldo_origen-monto)>=0) {
				saldo_origen-=monto;
				saldo_destino+=monto;
				
				conectDatabase();
				
				PreparedStatement ps=con.prepareStatement("INSERT INTO transferencia VALUES (?, ?, ?, ?, ?)");
				//System.out.println("1");
				ps.setString(1,null);
				ps.setString(2,cuentaDestino);
				ps.setString(3,razon);
				ps.setString(4,String.valueOf(monto));
				ps.setString(5,cuentaOrigen);
				
				@SuppressWarnings("unused")
				int i=ps.executeUpdate();
				//System.out.println(i+" records added");

		        String sql = "UPDATE planes_ahorro SET saldo=? WHERE n_Cuenta=?";
		        //System.out.println(sql);
		        ps = con.prepareStatement(sql);
		        ps.setInt(1, saldo_origen);
		        ps.setString(2, cuentaOrigen);
				ps.executeUpdate();
				
		        sql = "UPDATE planes_ahorro SET saldo=? WHERE n_Cuenta=?";
		        //System.out.println("3");
		        ps = con.prepareStatement(sql);
		        ps.setInt(1, saldo_destino);
		        ps.setString(2, cuentaDestino);
				ps.executeUpdate();
				
				con.close();
				return true;
			}
		}
		
		return false;
	}
	
	public Object[][] consultarTransferencia() {
		conectDatabase();
		
		int i=0, cont=0;
		String sql = "SELECT COUNT(*) from transferencia";
		Statement stmt;
		
		
		
		//System.out.println(sql);
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				cont=rs.getInt(1);
			Object a[][]= new Object [cont][5];
			sql = "SELECT * from transferencia";
			rs = stmt.executeQuery(sql);
			
			//System.out.println("The records are :"+rs);
			while(rs.next()) {
				a[i][0]=rs.getString(1);
				a[i][1]=rs.getString(2);
				a[i][2]=rs.getString(3);
				a[i][3]=rs.getString(4);
				a[i][4]=rs.getString(5);
				i++;
			}
			if(a!=null) {
				return a;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
