package Modelo;

import Modelo.Conexion;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.*;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.tomcat.util.codec.binary.Base64;
//import org.apache.tomcat.util.codec.binary.Base64;

public class UsuarioDAO {

    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion c = new Conexion();
    private Connection con;

    public String Encriptar(String cadena) {
        String encriptacion = "";
        String secretKey = "HOOELEL";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavePassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainTextBytes = cadena.getBytes("utf-8");
            byte[] buf = cifrado.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo salió mal");
        }
        return encriptacion;
    }

    public String Desencriptar(String cadenaEncriptada) {
        String desencriptacion = "";
        String secretKey = "GHGOGOG";
        try {
            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = decipher.doFinal(message);
            desencriptacion = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo salió mal");
        }
        return desencriptacion;
    }

    public List listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT usuario_id, id_u, nombre_u, apellido_u, apellido2_u, correo_u, fecha_u, celular_u, direccion_u, contrasena_u, puesto_u, barrio.NOMBRE_BARRIO, tipo_u, civil_u\n"
                + "FROM usuarios\n"
                + "INNER JOIN barrio ON usuarios.barrio_u = barrio.id_barrio;";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                System.out.println(rs.getString(13) + rs.getString(4) + rs.getString(5) + rs.getString(6) );
                u.setId(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setPrimer_apellido(rs.getString(4));
                u.setSegundo_apellido(rs.getString(5));
                u.setCorreo(rs.getString(6));
                u.setFecha_nacimiento(rs.getString(7));
                u.setCelular(rs.getString(8));
                u.setDireccion(rs.getString(9));
                u.setPassword(rs.getString(10));
                u.setEstado_civil(rs.getInt(14));
                u.setNombre_barrio(rs.getString(12));
                u.setTipo_usuario(rs.getInt(13));
                u.setPuesto_trabajo(rs.getString(11));
                lista.add(u);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error SQL listar: " + e);
        }
        return lista;
    }

    public int agregar(Usuario u) {
        int r = 0;
        String sql = "INSERT INTO usuarios (ID_U, NOMBRE_U, APELLIDO_U, APELLIDO2_U, CORREO_U, FECHA_U, CELULAR_U, DIRECCION_U,CONTRASENA_U, PUESTO_U, BARRIO_U, CIVIL_U) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println("Validar numero=" + validarNoExiste(u));

        System.out.println(u.getEstado_civil() + " ------- " + u.getBarrio());
        if (u.getEstado_civil() == 0 || u.getBarrio() == 0) {
            System.out.println("Aqui estoy...");
            r = 155894;
            return r;
        }
        if (!validarNoExiste(u)) {
            try {
                System.out.println(u.getEstado_civil() + " ------- " + u.getBarrio());
                con = c.conectar();
                ps = con.prepareStatement(sql);
                ps.setString(1, u.getId());
                ps.setString(2, u.getNombre());
                ps.setString(3, u.getPrimer_apellido());
                ps.setString(4, u.getSegundo_apellido());
                ps.setString(5, u.getCorreo());
                ps.setDate(6, Date.valueOf(u.getFecha_nacimiento()));
                ps.setString(7, u.getCelular());
                ps.setString(8, u.getDireccion());
                ps.setString(9, u.getPassword());
                ps.setString(10, u.getPuesto_trabajo());
                ps.setInt(11, u.getBarrio());
                ps.setInt(12, u.getEstado_civil());
                r = ps.executeUpdate();
                System.out.println(r + " ___ ");
                if (r == 1) {
                    r = 1;
                } else {
                    r = 0;
                }
                rs.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println("Error agregar: " + e);
            }
        } else {
            r = 18151;
        }
        System.out.println(r + "_soy R");
        return r;

    }

    public int validar(Usuario u) {
        int r = 0;
        String sql = "SELECT * FROM usuarios WHERE ID_U=? AND CONTRASENA_U=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getId());
            ps.setString(2, u.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
                u.setId(rs.getString(2));
                u.setPassword(rs.getString(6));
            }
            if (r == 1) {
                return 3;
            } else {
                return 4;
            }
        } catch (SQLException e) {
            System.out.println("Error en validar: " + e);
        }
        return r;
    }

    public boolean validarNoExiste(Usuario u) {
        int r = 0;
        boolean retornar = true;
        String sql = "SELECT * FROM usuarios WHERE ID_U=? OR CORREO_U=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getId());
            ps.setString(2, u.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 2;
            }
            if (r == 2) {
                retornar = true;
            } else if (r == 0) {
                retornar = false;
            }
            ps.close();
        } catch (SQLException e) {
            System.out.println("Error validar No existe: " + e);
        }
        return retornar;
    }

    public Usuario listarId(String id) {
        String sql = "SELECT * FROM usuarios WHERE ID_U=" + id;
        Usuario u = new Usuario();
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setId_usuario_bd(rs.getString(1));
                u.setId(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setPrimer_apellido(rs.getString(4));
                u.setSegundo_apellido(rs.getString(5));
                u.setCorreo(rs.getString(6));
                u.setCelular(rs.getString(8));
                u.setFecha_nacimiento(rs.getString(7));
                u.setDireccion(rs.getString(9));
                u.setPassword(rs.getString(10));
                u.setPuesto_trabajo(rs.getString(11));
                u.setEstado_civil(rs.getInt(14));
                u.setBarrio(rs.getInt(12));
                u.setTipo_usuario(rs.getInt(13));
            }
            ps.close();
            System.out.println(u.getPassword());
        } catch (SQLException e) {
            System.out.println("Error al listar por ID: " + e);
        }
        return u;
    }

    public int actualizar(Usuario u) {
        int r = 0;
        String sql = "UPDATE usuarios SET ID_U=?, NOMBRE_U=?, APELLIDO_U=?, APELLIDO2_U=?, CORREO_U=?, FECHA_U=?, CELULAR_U=?, DIRECCION_U=?,CONTRASENA_U=? WHERE ID_U =?";
        System.out.println(u.getPassword() + "___" + u.getId());
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(u.getId());
            System.out.println(u.getPassword());
            ps.setString(1, u.getId());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getPrimer_apellido());
            ps.setString(4, u.getSegundo_apellido());
            ps.setString(5, u.getCorreo());
            ps.setString(6, u.getFecha_nacimiento());
            ps.setString(7, u.getCelular());
            ps.setString(8, u.getDireccion());
            ps.setString(9, u.getPassword());
            ps.setString(10, u.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Errorrrr en actualizar: " + e);
        }
        return r;
    }

    public int actualizarUser(Usuario u) {
        int r = 0;
        String sql = "UPDATE usuarios SET NOMBRE_U=?, APELLIDO_U=?, APELLIDO2_U=?,CORREO_U=?, CELULAR_U=?, DIRECCION_U=?, CIVIL_U=?, PUESTO_U=?  WHERE ID_U =?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPrimer_apellido());
            ps.setString(3, u.getSegundo_apellido());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getCelular());
            ps.setString(6, u.getDireccion());
            ps.setInt(7, u.getEstado_civil());
            ps.setString(8, u.getPuesto_trabajo());
            ps.setString(9, u.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Errorrrr en actualizarrr: " + e);
        }
        return r;
    }

    public int actualizarUserxAdmin(Usuario u) {
        int r = 0;
        String sql = "UPDATE usuarios SET NOMBRE_U=?, APELLIDO_U=?, APELLIDO2_U=?,CORREO_U=?,  CELULAR_U=?, DIRECCION_U=?, CIVIL_U=?, PUESTO_U=?,TIPO_U=?, FECHA_U=?, CONTRASENA_U=?  WHERE ID_U =?";
        try {
            
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getPrimer_apellido());
            ps.setString(3, u.getSegundo_apellido());
            ps.setString(4, u.getCorreo());
            ps.setString(5, u.getCelular());
            ps.setString(6, u.getDireccion());
            ps.setInt(7, u.getEstado_civil());
            ps.setString(8, u.getPuesto_trabajo());
            ps.setInt(9, u.getTipo_usuario());
            ps.setString(10, u.getFecha_nacimiento());
            ps.setString(11, u.getPassword());
            ps.setString(12, u.getId());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Errorrrr en actualizarrr: " + e);
        }
        return r;
    }

    public int actualizarPassword(Usuario u) {
        int r = 0;
        String sql = "UPDATE usuarios SET CONTRASENA_U=? WHERE ID_U =?";
        System.out.println(u.getPassword() + "___" + u.getId());
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(u.getId());
            System.out.println(u.getPassword());
            ps.setString(2, u.getId());
            ps.setString(1, u.getPassword());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 1;
            } else {
                r = 0;
            }
            ps.close();
        } catch (Exception e) {
            System.out.println("Errorrrr en actualizar: " + e);
        }
        return r;
    }

    public int eliminar(String id) {
        int r = 0;
        System.out.println("soy idddd" + id);
        String sql = "DELETE FROM usuarios WHERE ID_U=" + id;
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            System.out.println(ps.executeUpdate() + "_____EQEqeq");
            System.out.println(r + "______eliminarrrrr");
            if (r == 1) {
                r = r + 1;
            } else {
                r = 0;
            }
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR" + e);
        }
        return r;
    }

    public List busqueda(String nomBuscar) {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios WHERE NOMBRE_U LIKE" + "'%" + nomBuscar + "%'"
                + " OR APELLIDO_U LIKE" + "'%" + nomBuscar + "%'"
                + " OR APELLIDO2_U LIKE" + "'%" + nomBuscar + "%'";
        try {
            con = c.conectar();
            System.out.println(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setPrimer_apellido(rs.getString(4));
                u.setSegundo_apellido(rs.getString(5));
                u.setCorreo(rs.getString(6));
                u.setFecha_nacimiento(rs.getString(7));
                u.setCelular(rs.getString(8));
                u.setDireccion(rs.getString(9));
                u.setPassword(rs.getString(10));
                u.setEstado_civil(rs.getInt(11));
                u.setBarrio(rs.getInt(12));
                u.setTipo_usuario(rs.getInt(13));
                u.setPuesto_trabajo(rs.getString(14));
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL listar: " + e);
        }
        return lista;
    }

    public boolean recuperarClave(Usuario u) {
        int r = 0;
        boolean retornar = true;
        String sql = "SELECT * FROM usuarios WHERE ID_U=?";
        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, u.getId());
            ps.setString(2, u.getCorreo());
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 2;
            }
            if (r == 2) {
                retornar = true;
            } else if (r == 0) {
                retornar = false;
            }
        } catch (SQLException e) {
            System.out.println("Error validar No existe: " + e);
        }
        return retornar;
    }

    String LLAVE = "X1SD4TBVMKL3RF24";

    // Clave de encriptación / desencriptación
    public SecretKeySpec CrearCalve(String llave) {
        try {
            byte[] cadena = llave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            cadena = md.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            SecretKeySpec secretKeySpec = new SecretKeySpec(cadena, "AES");
            return secretKeySpec;
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println("Error en crearClave: " + e);
            return null;
        }

    }

    // Encriptar
//    private String Encriptars(String encriptar) {
//
//        try {
//            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
//
//            byte[] cadena = encriptar.getBytes("UTF-8");
//            byte[] encriptada = cipher.doFinal(cadena);
//            String cadena_encriptada = com.sun.org.apache.xml.internal.security.utils.Base64.encode(encriptada);
//            return cadena_encriptada;
//
//        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
//            return "Error al encriptar :"+e;
//        }
//    }
//
//    // Des-encriptación
//    private String Desencriptars(String desencriptar) {
//
//        try {
//            SecretKeySpec secretKeySpec = CrearCalve(LLAVE);
//            Cipher cipher = Cipher.getInstance("AES");
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
//
//            byte[] cadena = com.sun.org.apache.xml.internal.security.utils.Base64.decode(desencriptar);
//            byte[] desencriptacioon = cipher.doFinal(cadena);
//            String cadena_desencriptada = new String(desencriptacioon);
//            return cadena_desencriptada;
//
//        } catch (Base64DecodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
//            System.out.println(e);
//            return "";
//        }
    public int validarPassword(String pass, String id) {
        int r = 0;
        String sql = "SELECT * FROM usuarios WHERE CONTRASENA_U=? AND ID_U=?";
        System.out.println("Soy pass validar: " + pass);
        try {
            con = c.conectar();
            System.out.println(sql);
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                r = r + 1;
            }
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println("Error en validarPassword: " + e);
        }
        return r;
    }
}
