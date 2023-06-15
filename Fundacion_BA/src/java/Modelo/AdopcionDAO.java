package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZENBOOK
 */
public class AdopcionDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion c = new Conexion();
    Connection con;

    public List listar() {
        List<Adopcion> lista = new ArrayList<>();
        System.out.println("Entreeee");
        String sql = "SELECT * FROM solicitud_adopcion";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adopcion ad = new Adopcion();
                ad.setId_solicitud(rs.getString(1));
                ad.setId_usuario(rs.getString(2));
                ad.setId_mascota(rs.getString(3));
                ad.setCantidad_familia(rs.getString(4));
                ad.setTipo_vivienda(rs.getString(5));
                ad.setMotivo_adopcion(rs.getString(6));
                ad.setEstado(rs.getString(7));
                ad.setNum_tuvo_mascota(rs.getString(8));
                ad.setTipo_tuvo_mascota(rs.getString(9));
                ad.setTiene_mascota(rs.getString(10));
                ad.setEstrato_vivienda(rs.getString(11));
                ad.setRango_salarial(rs.getString(12));

                lista.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return lista;
    }

    public List listarSolicitudesAdopcion() {
        List<Adopcion> lista = new ArrayList<>();
        String sql = "SELECT ID_SOLICITUD, ESTADO, ID_MASCOTA, NOMBRE_U, APELLIDO_U, CORREO_U, CELULAR_U, FECHA_U, FECHA_SOLICITUD, NOMBRE_M, USUARIO_ID\n"
                + "FROM solicitud_adopcion\n"
                + "INNER JOIN usuarios\n"
                + "ON solicitud_adopcion.ID_USUARIO = usuarios.USUARIO_ID INNER JOIN mascotas ON solicitud_adopcion.ID_MASCOTA = mascotas.ID_M WHERE solicitud_adopcion.ESTADO != 4;";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adopcion ad = new Adopcion();
                ad.setId_solicitud(rs.getString(1));
                ad.setEstado(rs.getString(2));
                ad.setId_mascota(rs.getString(3));
                ad.setNombre(rs.getString(4));
                ad.setPrimer_apellido(rs.getString(5));
                ad.setCorreo(rs.getString(6));
                ad.setCelular(rs.getString(7));
                ad.setFecha_nacimiento(rs.getString(8));
                ad.setFecha_solicitud(rs.getString(9));
                ad.setNombre_m(rs.getString(10));
                ad.setId_usuario_bd(rs.getString(11));
                lista.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        System.out.println(lista);
        return lista;
    }

    public int enviarSolicitudAdopcion(Adopcion adop) {
        int r = 0;
        String sql = "INSERT INTO solicitud_adopcion (ID_USUARIO,ID_MASCOTA,"
                + " CANTIDAD_FAMILIA,TIPO_VIVIENDA,"
                + "MOTIVO_ADOPCION, ESTADO,"
                + " NUM_TUVO_MASCOTA, TIPO_TUVO_MASCOTA, TIENE_MASCOTAS, ESTRATO_VIVIENDA,"
                + " RANGO_SALARIAL, NOMBRE_FAMILIAR,OCUPACION_FAMILIAR, "
                + "CELULAR_FAMILIAR, PROPIA_VIVIENDA) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, (adop.getId_usuario()));
            ps.setString(2, (adop.getId_mascota()));
            ps.setString(3, (adop.getCantidad_familia()));
            ps.setString(4, (adop.getTipo_vivienda()));
            ps.setString(5, (adop.getMotivo_adopcion()));
            ps.setString(6, "2");
            ps.setString(7, (adop.getNum_tuvo_mascota()));
            ps.setString(8, (adop.getTipo_tuvo_mascota()));
            ps.setString(9, (adop.getTiene_mascota()));
            ps.setString(10, (adop.getEstrato_vivienda()));
            ps.setString(11, (adop.getRango_salarial()));
            ps.setString(12, (adop.getNombre_familiar()));
            ps.setString(13, (adop.getOcupacion_familiar()));
            ps.setString(14, (adop.getCelular_familiar()));
            ps.setString(15, (adop.getPropia_vivienda()));
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

    public List listarMisSolicitudes(String id) {
        List<Adopcion> lista = new ArrayList<>();
        String sql = "SELECT ID_SOLICITUD, ESTADO, ID_MASCOTA, NOMBRE_M, razas.nombre_raza, EDAD_M FROM solicitud_adopcion \n"
                + "INNER JOIN usuarios ON solicitud_adopcion.ID_USUARIO = usuarios.USUARIO_ID\n"
                + "INNER JOIN mascotas ON solicitud_adopcion.ID_MASCOTA = mascotas.ID_M\n"
                + "INNER JOIN razas ON mascotas.RAZA_M = razas.id_raza \n"
                + "WHERE solicitud_adopcion.ESTADO != '4' AND ID_USUARIO = '" + id + "';";
        try {
            System.out.println(sql);
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Adopcion ad = new Adopcion();
                ad.setId_solicitud(rs.getString(1));
                ad.setEstado(rs.getString(2));
                ad.setId_mascota(rs.getString(3));
                ad.setNombre_m(rs.getString(4));
                ad.setRaza(rs.getString(5));
                ad.setEdad(rs.getString(6));
                lista.add(ad);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        System.out.println(lista);
        return lista;
    }

    public Adopcion verReviewSolicitud(String id, String idMascotas) {
        String sql = "SELECT ID_SOLICITUD, NOMBRE_U, APELLIDO_U,APELLIDO2_U, CORREO_U, CELULAR_U, DIRECCION_U, PUESTO_U, BARRIO_U, CANTIDAD_FAMILIA, TIPO_VIVIENDA, MOTIVO_ADOPCION, ESTADO, NUM_TUVO_MASCOTA, TIPO_TUVO_MASCOTA, TIENE_MASCOTAS, ESTRATO_VIVIENDA,RANGO_SALARIAL, FECHA_SOLICITUD, NOMBRE_FAMILIAR, CELULAR_FAMILIAR, OCUPACION_FAMILIAR, PROPIA_VIVIENDA, ID_MASCOTA \n"
                + "FROM solicitud_adopcion\n"
                + "INNER JOIN usuarios\n"
                + "ON solicitud_adopcion.ID_USUARIO = usuarios.USUARIO_ID INNER JOIN mascotas ON solicitud_adopcion.ID_MASCOTA = mascotas.ID_M WHERE ID_USUARIO = '" + id + "' AND ID_MASCOTA = '" + idMascotas + "'";
        System.out.println(id + " id revire");
        System.out.println(sql);
        Adopcion adop = new Adopcion();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            } else {
                adop.setId_solicitud(rs.getString(1));
                adop.setNombre(rs.getString(2));
                adop.setPrimer_apellido(rs.getString(3));
                adop.setSegundo_apellido(rs.getString(4));
                adop.setCorreo(rs.getString(5));
                adop.setCelular(rs.getString(6));
                adop.setDireccion(rs.getString(7));
                adop.setPuesto_trabajo(rs.getString(8));
                adop.setBarrio(rs.getInt(9));
                adop.setCantidad_familia(rs.getString(10));
                adop.setTipo_vivienda(rs.getString(11));
                adop.setMotivo_adopcion(rs.getString(12));
                adop.setEstado(rs.getString(13));
                adop.setNum_tuvo_mascota(rs.getString(14));
                adop.setTipo_tuvo_mascota(rs.getString(15));
                adop.setTiene_mascota(rs.getString(16));
                adop.setEstrato_vivienda(rs.getString(17));
                adop.setRango_salarial(rs.getString(18));
                adop.setFecha_solicitud(rs.getString(19));
                adop.setNombre_familiar(rs.getString(20));
                adop.setCelular_familiar(rs.getString(21));
                adop.setOcupacion_familiar(rs.getString(22));
                adop.setPropia_vivienda(rs.getString(23));
                adop.setId_mascota(rs.getString(24));
            }
            con.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al listar por ID: " + e);
        }
        return adop;
    }

    public int cancelarSolicitudAdopcion(String idSolitud) {
        int r = 0;
        String sql = "UPDATE solicitud_adopcion SET ESTADO = '4' WHERE ID_SOLICITUD = '" + idSolitud + "';";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar/ocultar anuncio: " + e);
        }
        return r;
    }

    public int rechazarSolicitudAdmin(String idSolitud) {
        int r = 0;
        String sql = "UPDATE solicitud_adopcion SET ESTADO = '3' WHERE ID_SOLICITUD = '" + idSolitud + "';";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al eliminar/ocultar anuncio: " + e);
        }
        return r;
    }

    public int AprobarSolicitudAdmin(String idSolitud) {
        int r = 0;
        String sql = "UPDATE solicitud_adopcion SET ESTADO = '1' WHERE ID_SOLICITUD = '" + idSolitud + "';";

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar/ocultar anuncio: " + e);
        }
        return r;
    }

    public int cambiarEstadoMascota(String idMascota) {
        System.out.println("idMascota: " + idMascota);
        int r = 0;
        String sql = "UPDATE mascotas SET DISPONI_M = '3' WHERE ID_M =  '" + idMascota + "';";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;

            } else {
                r = 0;
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar mascota a adoptada: " + e);
        }
        return r;
    }
}
