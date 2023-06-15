package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ZENBOOK
 */
public class EstadisticasDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public String listarRazasXMascotas() {
        String hola = "";
        String sql = "SELECT JSON_OBJECT(\"nombre_mascota\",NOMBRE_M, \"nombre_raza\",nombre_raza) FROM fundacionba2.mascotas join razas on mascotas.RAZA_M = razas.id_raza;";
        String[] v1 = new String[7];
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hola += rs.getString(1) + ",";
            }
            System.out.println("Holaaaaa::::::::::::" + hola + rs);
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return hola;
    }

    public String listarUsuariosxFechaRegistro() {
        String hola = "";
        String sql = "SELECT JSON_OBJECT(\"nombre\",u.NOMBRE_U, \"apellido\",u.APELLIDO_U, \"apellidodos\",u.APELLIDO2_U, \"registro\", u.FECHA_REGISTRO) FROM usuarios u;";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hola += rs.getString(1) + ",";
            }
            System.out.println("Holaaaaa::::::::::::" + hola + rs);
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return hola;
    }

    public String listarAdoptadosYRazas() {
        String hola = "";
        String sql = "SELECT JSON_OBJECT(\"nombre\",NOMBRE_U, \"apellido\",APELLIDO_U, \"correo\", CORREO_U, \"celular\",CELULAR_U, \"nombre_mascota\", NOMBRE_M, \"raza_mascota\",nombre_raza) FROM solicitud_adopcion join mascotas on mascotas.ID_M = solicitud_adopcion.ID_MASCOTA\n"
                + "join usuarios on usuarios.USUARIO_ID = solicitud_adopcion.ID_USUARIO\n"
                + "join razas on razas.id_raza = mascotas.RAZA_M\n"
                + "where mascotas.DISPONI_M = '3';";
        String[] v1 = new String[7];
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                hola += rs.getString(1) + ",";
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return hola;
    }

    public String listarMascotasInformacion() {
        String hola = "";
        String sql = "select DISPONI_M from mascotas";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int adoptados = 0;
            int fallecidos = 0;
            int disponible = 0, nodisponible = 0;
            while (rs.next()) {
                int validate = rs.getInt(1);
                if (validate == 1) {
                    disponible++;
                }
                if (validate == 2) {
                    nodisponible++;
                }
                if (validate == 3) {
                    adoptados++;
                }
                if (validate == 4) {
                    fallecidos++;
                }
            }
            hola = "["+disponible+","+nodisponible+","+adoptados+","+fallecidos+"]";
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return hola;
    }
    
    public String listarCantidaddeContactosSinResponder() {
        String hola = "";
        String sql = "SELECT estado FROM contacto;";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            int respondido = 0, sinrespuesta = 0;
            while (rs.next()) {
                int validate = rs.getInt(1);
                if (validate == 1) {
                    respondido++;
                }
                if (validate == 2) {
                    sinrespuesta++;
                }
            }
            hola = "["+respondido+","+sinrespuesta+"]";
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return hola;
    }

}
