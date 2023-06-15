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
import java.util.List;

/**
 *
 * @author PC
 */
public class RazasDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion c = new Conexion();
    private Connection con;
    
    public List listar() {
        List<Razas> lista = new ArrayList<>();
        String sql = "SELECT * FROM razas";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Razas razas = new Razas();
                razas.setId_raza(rs.getInt(1));
                razas.setNombre_raza(rs.getString(2));
                lista.add(razas);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error SQL listar barrios: " + e);
        }
        return lista;
    }
}

