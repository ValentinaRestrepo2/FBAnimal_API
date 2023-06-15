package Modelo;

import Modelo.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public class MascotaDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List<Mascota> listar() {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT ID_M, NOMBRE_M, DESCRIPCION_M, razas.nombre_raza , VACUNADO_M, ESTERIL_M, DISPONI_M, EDAD_M, FOTO_M, GENERO\n" +
        "FROM mascotas\n" +
        "INNER JOIN razas ON mascotas.RAZA_M = razas.id_raza;";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getString(1));
                m.setNombre(rs.getString(2));
                m.setDescripcion(rs.getString(3));
                m.setRaza(rs.getString(4));
                m.setVacunado(rs.getInt(5));
                m.setEsterilizado(rs.getInt(6));
                m.setDisponibilidad(rs.getInt(7));
                m.setEdad(rs.getString(8));
                m.setVerFoto(rs.getBytes(9));
                m.setGenero_mascota(rs.getString(10));
                lista.add(m);
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las mascotas en el DAO: " + e);
        }
        return lista;
    }

    public void listarImg(int img, HttpServletResponse response) {
        String sql = "SELECT * FROM mascotas WHERE ID_M=" + img;
        InputStream inputStream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        response.setContentType("image/*");
        try {
            outputstream = response.getOutputStream();
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("FOTO_M");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputstream);
            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);
            }
            outputstream.close();
            bufferedInputStream.close();
            bufferedOutputStream.close();

            inputStream.close();
        } catch (IOException | SQLException e) {
            System.out.println("Error al mostrar imagen en MasDAO: " + e);
        }
    }

    public ArrayList<Mascota> listMascostasDisponibles() {
        ArrayList<Mascota> lista = new ArrayList<Mascota>();
        String sql = "SELECT ID_M, NOMBRE_M, DESCRIPCION_M, razas.nombre_raza , VACUNADO_M, ESTERIL_M, DISPONI_M, EDAD_M, FOTO_M, GENERO\n" +
        "FROM mascotas\n" +
        "INNER JOIN razas ON mascotas.RAZA_M = razas.id_raza where DISPONI_M = '1'; ";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                do {
                    Mascota m = new Mascota();
                    m.setId(rs.getString(1));
                    m.setNombre(rs.getString(2));
                    m.setDescripcion(rs.getString(3));
                    m.setRaza(rs.getString(4));
                    m.setVacunado(rs.getInt(5));
                    m.setEsterilizado(rs.getInt(6));
                    m.setDisponibilidad(rs.getInt(7));
                    m.setEdad(rs.getString(8));
                    m.setGenero_mascota(rs.getString(10));
                    System.out.println(m.getNombre());
                    lista.add(m);
                } while (rs.next());
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar las mascotas en el DAO: " + e);
        }
        return lista;
    }

    public int agregar(Mascota m) {
        int r = 0;
        String sql = "INSERT INTO mascotas (NOMBRE_M, DESCRIPCION_M,RAZA_M,VACUNADO_M,ESTERIL_M, DISPONI_M, EDAD_M, FOTO_M, GENERO) VALUES (?,?,?,?,?,?,?,?,?)";
        System.out.println(m.getEdad() + " Edadd:");
        System.out.println(m.getFoto() + "FOOTOT");
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.setString(3, m.getRaza());
            ps.setInt(4, m.getVacunado());
            ps.setInt(5, m.getEsterilizado());
            ps.setInt(6, m.getDisponibilidad());
            ps.setString(7, m.getEdad());
            ps.setBlob(8, m.getFoto());
            ps.setString(9, m.getGenero_mascota());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al agregar MAscota: " + e);
        }
        return r;
    }

    public Mascota listarId(String id) {
        String sql = "SELECT * FROM mascotas WHERE ID_M=" + id;
        System.out.println(id);
        Mascota m = new Mascota();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                m.setId(rs.getString(1));
                m.setNombre(rs.getString(2));
                m.setDescripcion(rs.getString(3));
                m.setRaza(rs.getString(4));
                m.setVacunado(rs.getInt(5));
                m.setEsterilizado(rs.getInt(6));
                m.setDisponibilidad(rs.getInt(7));
                m.setEdad(rs.getString(8));
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar por ID: " + e);
        }
        return m;
    }

    public int actualizarMascota(Mascota m) {
        int r = 0;
        String sql = "UPDATE mascotas SET NOMBRE_M=?, DESCRIPCION_M=?,VACUNADO_M=?,ESTERIL_M=?, DISPONI_M=?, EDAD_M=? WHERE ID_M =?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getNombre());
            ps.setString(2, m.getDescripcion());
            ps.setInt(3, m.getVacunado());
            ps.setInt(4, m.getEsterilizado());
            ps.setInt(5, m.getDisponibilidad());
            ps.setString(6, m.getEdad());
            ps.setString(7, m.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar en el DAO: " + e);
        }
        return r;
    }

    public int eliminar(String id) {
        String sql = "DELETE FROM mascotas WHERE ID_M=" + id;
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
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar en DAO: " + e);
        }

        return r;
    }

    public ArrayList busqueda(String strBuscar) {
        ArrayList<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mascotas WHERE NOMBRE_M LIKE" + "'%" + strBuscar + "%'"
                + " OR EDAD_M LIKE" + "'%" + strBuscar + "%'"
                + " OR RAZA_M LIKE" + "'%" + strBuscar + "%'";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota m = new Mascota();
                m.setId(rs.getString(1));
                m.setNombre(rs.getString(2));
                m.setDescripcion(rs.getString(3));
                m.setRaza(rs.getString(4));
                m.setVacunado(rs.getInt(5));
                m.setEsterilizado(rs.getInt(6));
                m.setDisponibilidad(rs.getInt(7));
                m.setEdad(rs.getString(8));
                lista.add(m);
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error SQL listar: " + e);
        }
        return lista;
    }
}
