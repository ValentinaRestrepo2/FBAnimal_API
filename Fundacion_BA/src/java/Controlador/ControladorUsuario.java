/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Correos;
import Modelo.Email;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControladorUsuario extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario u = new Usuario();
    Correos mail = new Correos();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                response.sendRedirect("listar_usuarios.jsp");
                break;
            case "Nuevo":
                response.sendRedirect("registro.jsp");
                break;
            case "Registrar":
                String id = request.getParameter("identificacion");
                String nom = request.getParameter("Nombre");
                String pa = request.getParameter("pri_ape");
                String sa = request.getParameter("seg_ape");
                String correo = request.getParameter("email");
                String fecha = request.getParameter("fecha_nac");
                String celular = request.getParameter("celular");
                String dir = request.getParameter("direccion");
                String pass = request.getParameter("password");
                String trabajo = request.getParameter("puesto_trabajo");
                int barrio = Integer.parseInt(request.getParameter("select_barrio"));
                int estado_civil = Integer.parseInt(request.getParameter("select_civil"));
                u.setId(id);
                u.setNombre(nom);
                u.setPrimer_apellido(pa);
                u.setSegundo_apellido(sa);
                u.setCorreo(correo);
                u.setFecha_nacimiento(fecha);
                u.setCelular(celular);
                u.setDireccion(dir);
                u.setPassword(pass);
                u.setBarrio(barrio);
                u.setEstado_civil(estado_civil);
                u.setPuesto_trabajo(trabajo);
                System.out.println(pass);
                int respta = 0;

                try {
                    respta = dao.agregar(u);
                    System.out.println(respta + "Respuestaaaaaaaaaaa");
                } catch (Exception ex) {
                    System.out.println("Error al registrarme: " + ex);
                }

                switch (respta) {
                    case 18151:
                        response.sendRedirect("registro.jsp?respta=" + respta);
                        break;
                    case 0:
                        response.sendRedirect("registro.jsp?respta=" + respta);
                        break;
                    case 155894:
                        response.sendRedirect("registro.jsp?respta=" + respta);
                        break;
                    case 1:
                        response.sendRedirect("login.jsp?rspta=25536");
                        mail.Mensajes("Te damos la bienvenida a la Fundación Bello Animal", correo, "<div> <h3 style=\"color: #0ed1f0\"> ¡Que alegria tenerte con nosotros, <strong>" + u.getNombre() + " " + u.getPrimer_apellido() + "</strong>! </h3> <br /> <p> Nos encanta que te guste tanto los animales como a nosotros y hayas decidido ser parte de nuestra familia. </p> <p> Somos una fundación sin ánimo de lucro, que busca familia a seres extraordinarios llenos de amor y alegría. Cada día buscamos mejorar la vida de los animales que están en situación de maltrato y/o abandono, dandoles un lugar importante, caluroso y lleno de esperanza en nuestra sociedad. </p> <p> Si quieres hacer una donación voluntaria, ya sea económica o de algunos elementos, sería de gran utilidad para el sostenimiento de nuestros hogares de paso. Adicionalmente, contamos con el Plan Padrino el cual consiste en hacer un acompañamiento de su ahijado(a), dándole una cuota mensual, mediante la cual le garantizamos la alimentación y atenciones veterinarias. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/\" >Conocer el plan padrino</a ></span </p> <p><strong>Conoce las mascotas que tenemos disponibles para adoptar, ellos te necesitan: <a href=\"https://fundacionbanimal.herokuapp.com/Galeria.jsp\">Adoptar mascotas</a></strong></p> <p> Te esperamos en nuestra aplicación. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación</a ></span > </p> </div>");
                        break;
                }
                break;

            case "adopcionesList":
                response.sendRedirect("listar_adopciones.jsp");
                break;

            case "home":
                response.sendRedirect("Maestras.jsp");
                break;

            case "cambiarcontra":
                response.sendRedirect("contra_admin.jsp");
                break;

            case "anuncioList":
                response.sendRedirect("listar_anuncios.jsp");
                break;
            case "Actualizar":
                String id1 = request.getParameter("txtid1");
                String nom1 = request.getParameter("txtnom1");
                String pa1 = request.getParameter("txtpri_ape1");
                String sa1 = request.getParameter("txtseg_ape1");
                String correo1 = request.getParameter("txtcorreo1");
                String fecha1 = request.getParameter("txtfecha1");
                String celular1 = request.getParameter("txtcelu1");
                String dir1 = request.getParameter("txtdir1");
                String pass1 = request.getParameter("txtcontra1");
                u.setId(id1);
                u.setNombre(nom1);
                u.setPrimer_apellido(pa1);
                u.setSegundo_apellido(sa1);
                u.setCorreo(correo1);
                u.setFecha_nacimiento(fecha1);
                u.setCelular(celular1);
                u.setDireccion(dir1);
                u.setPassword(pass1);
                dao.actualizar(u);
                response.sendRedirect("listar_usuarios.jsp");
                break;
            case "Eliminar":
                String id2 = request.getParameter("id");
                dao.eliminar(id2);
                response.sendRedirect("listar_usuarios.jsp");
                break;

            case "Recuperar":
                int respuesta;
                String identifiacion_recuperar = request.getParameter("Identificacion");
                u = dao.listarId(identifiacion_recuperar);
                if ("error".equals(u.getCorreo()) || u.getCorreo() == null) {
                    respuesta = 02514452;
                    response.sendRedirect("recuperar_contrasena.jsp?respuesta=" + respuesta);
                } else {
                    String mensaje = "<br><table style=\" max-width: 600px; padding: 10px; margin: 0 auto; border-collapse: collapse; \" > <tr> <td style=\"border-radius: 30px\"> <div style=\" color: black; margin: 4% 10% 2%; text-align: justify; font-family: sans-serif; \" > <h2 style=\"color: #0ed1f0; margin: 0 0 7px\">¡Hola " + u.getNombre() + " " + u.getPrimer_apellido() + "!</h2> <p style=\"margin: 2px; font-size: 15px\"> Nosotros estamos contigo y te ayudamos a resolver todas tus dudas, problemas e inquitudes, no te preocupes somos tu familia, recuerda que cada vez que se te olvide la contraseña podràs solicitarla mediante el siguiente link: <span style=\"color: #0ed1f0;\"><a style=\"color: #0ed1f0;\" href=\"https://fundacionbanimal.herokuapp.com/recuperar_contrasena.jsp\">recuperar contraseña</a></span> </p> <br><br> <p style=\"margin: 2px; font-size: 15px\"> ¡No te preocupes te ayudamos a recuperar tú contraseña! </p> <div style=\" width: 100%; margin: 20px 0; display: inline-block; text-align: center; \" > <h2 style=\"margin: 2px; font-size: 18px\">La contraseña registrada es: " + u.getPassword() + "</h2> </div> <div style=\"width: 100%; text-align: center\"> <a style=\" text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #3498db; \" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación web</a > </div> <p style=\" color: #b3b3b3; font-size: 12px; text-align: center; margin: 30px 0 0; \" > Fundacion Bello Animal </p> </div> </td> </tr> </table>";
                    mail.Mensajes("Recuperación de contraseña | Fundación Bello Animal", u.getCorreo(), mensaje);
                    respuesta = 984991156;
                    response.sendRedirect("recuperar_contrasena.jsp?respuesta=" + respuesta);
                }
                break;
            case "ActualizarUserxAdmin":
                id1 = request.getParameter("id");
                nom1 = request.getParameter("nom_user_edit");
                pa1 = request.getParameter("ap_user_edit");
                sa1 = request.getParameter("segap_user_edit");
                correo1 = request.getParameter("correo_user_edit");
                fecha1 = request.getParameter("fcha_user_edit");
                celular1 = request.getParameter("celular_user_edit");
                estado_civil = Integer.parseInt(request.getParameter("civil_user_edit"));
                dir = request.getParameter("dir_user_edit");
                trabajo = request.getParameter("trabp_user_edit");
                int typeuser = Integer.parseInt(request.getParameter("tipo_user_edit"));
                pass = request.getParameter("contra_user_edit");
                u.setId(id1);
                u.setNombre(nom1);
                u.setPrimer_apellido(pa1);
                u.setSegundo_apellido(sa1);
                u.setCorreo(correo1);
                u.setCelular(celular1);
                u.setEstado_civil(estado_civil);
                u.setDireccion(dir);
                u.setPuesto_trabajo(trabajo);
                u.setFecha_nacimiento(fecha1);
                u.setTipo_usuario(typeuser);
                u.setPassword(pass);
                dao.actualizarUserxAdmin(u);
                System.out.println("uuuuuuuuuuuuu"+ u);
                response.sendRedirect("listar_usuarios.jsp");
                break;
            default:
                throw new AssertionError();

        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
