/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrés Marín
 */
public class ContactoDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public boolean enviarContacto(Contacto contacto) {
        int r = 0;
        String sql = "INSERT INTO contacto (nombre_contacto, correo_contacto,cel_contacto,pqrs_contacto,mensaje_contacto) VALUES (?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, contacto.getNombre());
            ps.setString(2, contacto.getCorreo());
            ps.setString(3, contacto.getCelular());
            ps.setString(4, contacto.getSelect_pqrs());
            ps.setString(5, contacto.getMensaje());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException e) {
            System.out.println("Error al enviarContacto: " + e);
        }
        return true;
    }
    
    public ArrayList<Contacto> listarContacto() {
        ArrayList<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * FROM contacto";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                do {
                    Contacto contacto = new Contacto();
                    contacto.setId(rs.getString(1));
                    contacto.setNombre(rs.getString(2));
                    contacto.setCorreo(rs.getString(3));
                    contacto.setCelular(rs.getString(4));
                    contacto.setSelect_pqrs(rs.getString(5));
                    contacto.setMensaje(rs.getString(6));
                    contacto.setEstado(rs.getString(7));
                    lista.add(contacto);
                } while (rs.next());
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las mensajes de contacto en el DAO: " + e);
        }
        return lista;
    }
    
    public boolean actualizarContacto(String id) {
        int r = 0;
        String sql = "UPDATE contacto SET estado = ? WHERE id_contacto =?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, "2");
            ps.setString(2, id);
            r = ps.executeUpdate();
            if (r == 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Errorrrr en actualizar: " + e);
        }
        return true;
    }
}
