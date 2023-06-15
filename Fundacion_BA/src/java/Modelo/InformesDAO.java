/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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

/**
 *
 * @author PC
 */
public class InformesDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List<Informes> listar() {
        List<Informes> lista = new ArrayList<>();
        String sql = "SELECT * FROM MASCOTAS WHERE ID_USUARIO = ?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Informes info = new Informes();
                info.setId_informe(rs.getString(1));
                info.setDescripcion_informe(rs.getString(2));
                info.setMensaje_informe(rs.getString(3));
                info.setMascota_informe(rs.getString(4));
                info.setUsuario_informe(rs.getString(5));
                info.setRespuesta_admin_informe(rs.getString(6));
                lista.add(info);
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los ALL informes en el DAO: " + e);
        }
        return lista;
    }

    public List<Informes> misMascotasAdoptasLista(String id) {
        List<Informes> lista = new ArrayList<>();
        String sql = "SELECT ID_MASCOTA, NOMBRE_M FROM solicitud_adopcion\n"
                + "INNER JOIN usuarios ON solicitud_adopcion.ID_USUARIO = usuarios.USUARIO_ID\n"
                + "INNER JOIN mascotas ON solicitud_adopcion.ID_MASCOTA = mascotas.ID_M WHERE solicitud_adopcion.ID_USUARIO = " + id + " AND solicitud_adopcion.ESTADO = '1'";
        System.out.println(id);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Informes info = new Informes();
                info.setIdMascota(rs.getString(1));
                info.setNombreMascota(rs.getString(2));
                lista.add(info);
            }

            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar mis mascota del usuario adoptadas: " + e);
        }
        return lista;
    }

    public int agregarInforme(Informes informe) {
        int r = 0;
        String sql = "INSERT INTO informe_seguimiento (DESCRIPCION,MENSAJE, ID_MASCOTA, IMAGEN, ID_USUARIO) VALUES (?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, informe.getDescripcion_informe());
            ps.setString(2, informe.getMensaje_informe());
            ps.setString(3, informe.getMascota_informe());
            ps.setString(5, informe.getUsuario_informe());
            ps.setBlob(4, informe.getFoto());
            r = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar informe: " + e);
        }
        return r;
    }

    public List<Informes> misMensajesEnviados(String id) {
        List<Informes> lista = new ArrayList<>();
        String sql = "SELECT ID_INFORME,DESCRIPCION, MENSAJE, ID_MASCOTA, NOMBRE_M, informe_seguimiento.FECHA, NOMBRE_U,RESPUESTA_ADMIN FROM informe_seguimiento\n"
                + "INNER JOIN usuarios ON informe_seguimiento.ID_USUARIO = usuarios.USUARIO_ID\n"
                + "INNER JOIN mascotas ON informe_seguimiento.ID_MASCOTA = mascotas.ID_M WHERE informe_seguimiento.ID_USUARIO = " + id;
        System.out.println(id);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Informes info = new Informes();
                info.setId_informe(rs.getString(1));
                info.setDescripcion_informe(rs.getString(2));
                info.setMensaje_informe(rs.getString(3));
                info.setIdMascota(rs.getString(4));
                info.setNombreMascota(rs.getString(5));
                info.setFecha_informe(rs.getString(6));
                info.setNombre(rs.getString(7));
                info.setRespuesta_admin_informe(rs.getString(8));
                lista.add(info);
            }

            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar mis mensaje enviados del usuario mascotas adoptadas: " + e);
        }
        return lista;
    }

    public List<Informes> listarInformesAdmin() {
        List<Informes> lista = new ArrayList<>();
        String sql = "SELECT ID_INFORME,DESCRIPCION, ID_MASCOTA, NOMBRE_M, informe_seguimiento.FECHA, NOMBRE_U FROM informe_seguimiento\n"
                + "INNER JOIN usuarios ON informe_seguimiento.ID_USUARIO = usuarios.USUARIO_ID\n"
                + "INNER JOIN mascotas ON informe_seguimiento.ID_MASCOTA = mascotas.ID_M";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Informes info = new Informes();
                info.setId_informe(rs.getString(1));
                info.setDescripcion_informe(rs.getString(2));
                info.setIdMascota(rs.getString(3));
                info.setNombreMascota(rs.getString(4));
                info.setFecha_informe(rs.getString(5));
                info.setNombre(rs.getString(6));
                lista.add(info);
            }

            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar los mensajes para el ADMIN (Informes): " + e);
        }
        return lista;
    }

    public Informes informeCompletoporId(String id) {
        String sql = "SELECT ID_INFORME,DESCRIPCION, ID_MASCOTA, NOMBRE_M, informe_seguimiento.FECHA, NOMBRE_U, MENSAJE, IMAGEN, APELLIDO_U, RESPUESTA_ADMIN FROM informe_seguimiento\n"
                + "INNER JOIN usuarios ON informe_seguimiento.ID_USUARIO = usuarios.USUARIO_ID\n"
                + "INNER JOIN mascotas ON informe_seguimiento.ID_MASCOTA = mascotas.ID_M where informe_seguimiento.ID_INFORME = " + id;
        Informes info = new Informes();
        System.out.println("informeCompletoporId: " + id);
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                info.setId_informe(rs.getString(1));
                info.setDescripcion_informe(rs.getString(2));
                info.setIdMascota(rs.getString(3));
                info.setNombreMascota(rs.getString(4));
                info.setFecha_informe(rs.getString(5));
                info.setNombre(rs.getString(6));
                info.setMensaje_informe(rs.getString(7));
                info.setPrimer_apellido(rs.getString(9));
                info.setRespuesta_admin_informe(rs.getString(10));
            }

            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR AL LISTAR EL INFORME POR ID ADMIN (Informes): " + e);
        }
        return info;
    }

    public int enviarRespuestaInforme(String mensaje, String id) {
        System.out.println("IDDD: "+id+" MENSAJE: "+mensaje);
        String sql = "UPDATE informe_seguimiento SET informe_seguimiento.RESPUESTA_ADMIN = '" + mensaje + "' WHERE informe_seguimiento.ID_INFORME =" + id;
        int r = 0;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            System.out.println(r);
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR AL EMVIAR RESPUESTA EL INFORME POR ID ADMIN (Informes): " + e);
        }
        return r;
    }
    
    public void listarImg(int img, HttpServletResponse response) {
        String sql = "SELECT * FROM informe_seguimiento WHERE ID_INFORME=" + img;
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
                inputStream = rs.getBinaryStream("IMAGEN");
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

}
