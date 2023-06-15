package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ZENBOOK
 */
public class AnuncioDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public ArrayList<Anuncios> listar() {
        ArrayList<Anuncios> lista = new ArrayList<Anuncios>();
        String sql = "SELECT * FROM anuncios";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                do {
                    Anuncios anuncio = new Anuncios();
                    anuncio.setId_anuncio(rs.getString(1));
                    anuncio.setNombre_anuncio(rs.getString(4));
                    anuncio.setDescripcion(rs.getString(2));
                    anuncio.setCosto(rs.getInt(5));
                    anuncio.setVerFoto(rs.getBytes(3));
                    lista.add(anuncio);
                } while (rs.next());
            }
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las ANUNCIOS en el DAO: " + e);
        }
        return lista;
    }

    public int agregar(Anuncios anu, int id_usuario_bd) {
        int r = 0;
        System.out.println(" eqeqeq - "+id_usuario_bd);
        String sql = "INSERT INTO anuncios (DESC_ANUNCIO,IMG_ANUNCIO, NOM_ANUNCIO,COSTO_ANUNCIO,ID_USUARIO) VALUES (?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, (anu.getDescripcion()));
            ps.setBlob(2, anu.getFoto());
            ps.setString(3, anu.getNombre_anuncio());
            ps.setInt(4, anu.getCosto());
            ps.setInt(5, id_usuario_bd);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al agregar ANUNCIOS: " + e);
        }
        return r;
    }

    public int eliminar(String id) {
        String sql = "DELETE FROM anuncios WHERE ID_ANUNCIO=" + id;
        int r = 0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar en DAO: " + e);
        }
        return r;
    }

    public int actualizarMascota(Anuncios anu) {
        int r = 0;
        String sql = "UPDATE anuncios SET DESC_ANUNCIO=?, NOM_ANUNCIO=?,COSTO_ANUNCIO=? WHERE ID_ANUNCIO =?";
        System.out.println("Entreeee");
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, anu.getDescripcion());
            ps.setString(2, anu.getNombre_anuncio());
            ps.setInt(3, anu.getCosto());
            ps.setString(4, anu.getId_anuncio());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar ANUNCIO en el DAO: " + e.getMessage());
        }
        return r;
    }
}
