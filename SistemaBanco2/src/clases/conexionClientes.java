package clases;

import java.io.IOException;
import java.sql.*;

public class conexionClientes {

    private Connection con = null;

    public void conectDatabase() {
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "banco";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url + dbName, userName, password);

            /*if(!con.isClosed())
             System.out.println("Successfully conected to MySQL server...");*/
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
    }

    //COPIAR
    public void insertCliente(String nombre, String fecha_nac, String domicilio, String telefono, String curp, String correo, String sexo) throws SQLException, IOException {
        conectDatabase();
        PreparedStatement ps = con.prepareStatement("INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?)");
        ps.setString(1, nombre);
        ps.setString(2, sexo);
        ps.setString(3, fecha_nac);
        ps.setString(4, domicilio);
        ps.setString(5, telefono);
        ps.setString(6, correo);
        ps.setString(7, curp);

        @SuppressWarnings("unused")
        int i = ps.executeUpdate();
        con.close();
    }

    public Object[][] consultarClientes() {
        conectDatabase();
        int i = 0, cont = 0;
        String sql = "SELECT COUNT(*) from cliente";
        Statement stmt;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                cont = rs.getInt(1);
            }
            Object a[][] = new Object[cont][7];
            sql = "SELECT * from cliente";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                for (int j = 1; j <= 7; j++) {
                    a[i][j - 1] = rs.getString(j);
                }
                i++;
            }
            if (a != null) {
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean modificarCliente(String nombre, String fecha_nac, String domicilio, String telefono,
            String curp, String correo, String sexo) throws SQLException, IOException {
        String sql = "UPDATE cliente SET nombre=?, sexo=?, fecha_nac=?, domicilio=?, telefono=?, correo_e=? WHERE curp=?";
        conectDatabase();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, sexo);
            ps.setString(3, fecha_nac);
            ps.setString(4, domicilio);
            ps.setString(5, telefono);
            ps.setString(6, correo);
            ps.setString(7, curp);
            ps.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Cliente buscarCliente(String curp) throws SQLException, IOException {
        Cliente cliente;
        conectDatabase();
        Statement stmt;
        String sql = "SELECT * FROM cliente WHERE curp = '" + curp + "'";
        String nombre;
        String sexo;
        String fecha_nac;
        String domicilio;
        String telefono;
        String correo;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nombre = rs.getString("nombre");
                sexo = rs.getString("sexo");
                fecha_nac = rs.getString("fecha_nac");
                domicilio = rs.getString("domicilio");
                telefono = rs.getString("telefono");
                correo = rs.getString("correo_e");
                cliente = new Cliente(nombre, sexo, fecha_nac, domicilio, telefono, correo, curp);
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    //FIN

}
