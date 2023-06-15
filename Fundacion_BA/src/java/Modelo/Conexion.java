package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    Connection con;

    // LOCAL EN MYSQL 
    private final String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
    private final String user = "basepoli"; //Usuario de la base de datos
    private final String pass = "basepoli20";//Contraseña de la base de datos
    private final String Driver = "com.mysql.cj.jdbc.Driver";
    private final String urlMySQL = "jdbc:mysql://localhost:3306/fundacionba2";

    public Connection conectar() {

        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(urlMySQL, "root", "administrador");
        } catch (SQLException e) {
            System.out.println("Errr en SQL Conexion: " + e);
        } catch (ClassNotFoundException xq) {
            System.out.println("Error clase: " + xq);
        }

        return con;
    }

    public void desconectar() {
        con = null;
    }
    /*
    // Conexion remota
    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10472659", "sql10472659", "7TC1XNpHMU");
            //con = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10472399", "sql10472399", "CtbNZUurTm");
            con = DriverManager.getConnection("jdbc:mysql://bvsj9r0bkgryiuplcnbc-mysql.services.clever-cloud.com:3306/bvsj9r0bkgryiuplcnbc", "ueglv00wchthukql", "HlhsxU5Pp6ClwxElyV1j"); // Generada el 14 de Febrero.
        } catch (SQLException e) {
            System.out.println("Errr en SQL Conexion: " + e);
        } catch (ClassNotFoundException xq) {
            System.out.println("Error clase: " + xq);
        }
        return con;
    }
    public void desconectar() {
        con = null;
    }
     */
}
