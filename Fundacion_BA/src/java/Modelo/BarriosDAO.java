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
public class BarriosDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion c = new Conexion();
    private Connection con;
    
    public List listar() {
        List<Barrios> lista = new ArrayList<>();
        String sql = "SELECT * FROM barrio";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Barrios barrio = new Barrios();
                barrio.setId(rs.getInt(1));
                barrio.setNombre_barrio(rs.getString(2));
                lista.add(barrio);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error SQL listar barrios: " + e);
        }
        return lista;
    }
}
