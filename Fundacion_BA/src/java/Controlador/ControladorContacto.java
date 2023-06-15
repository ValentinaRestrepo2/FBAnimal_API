/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Contacto;
import Modelo.ContactoDAO;
import Modelo.Correos;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrés Marín
 */
public class ControladorContacto extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String accion;
    Correos mail = new Correos();
    Contacto contacto = new Contacto();
    ContactoDAO cdao = new ContactoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorContacto</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorContacto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String celular = request.getParameter("celular");
        String mensaje = request.getParameter("mensaje");
        String select_pqrs = request.getParameter("select_pqrs");
        accion = request.getParameter("accion");
        switch (accion) {
            case "Contacto":
                contacto.setNombre(nombre);
                contacto.setCorreo(email);
                contacto.setCelular(celular);
                contacto.setSelect_pqrs(select_pqrs);
                contacto.setMensaje(mensaje);
                try {
                    cdao.enviarContacto(contacto);
                    //String mensajeej = "<br> <div> <h3 style=\"color: #0ed1f0\"> ¡Hola administradora, te saluda: <strong>" + contacto.getNombre() + "</strong>! </h3> <br /> <p style=\"color: black\"> <strong>El correo electronico es: </strong><span style=\"color: #0ed1f0\">" + contacto.getCorreo() + "</span> </p> <p style=\"color: black\"> <strong style=\"color: #0ed1f0\">El celular es: </strong><span>" + contacto.getCelular() + "</span> </p> <p style=\"color: black\"> <span style=\"color: #0ed1f0\">Mensaje que te ha dejado: </span>\"" + contacto.getMensaje() + "\" </p> </div>";
                    // mail.Mensajes(email + " | Te ha contactado | " + nombre, "soportefbanimal@gmail.com", mensajeej);
                    mail.Mensajes("Gracias por comunicarte con nosotros | Fundación Bello Animal", email, "<div> <h3 style=\"color: #0ed1f0\"> ¡Gracias por comunicarte nosotros, <strong>" + contacto.getNombre() + "</strong>! </h3> <br /> <p> Para nosotros es muy valiosa tu opinión, quejas, sugerencias, etc. y por lo tanto pronto recibirás una respuesta a la inquietud que tengas. </p> <p> Te esperamos en nuestra aplicación. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación</a ></span > </p> </div>");
                    response.sendRedirect("contacto.jsp");
                } catch (IOException e) {
                    System.out.println(e);
                }
                break;

            case "ListarContactos":
                response.sendRedirect("listarContactos_admin.jsp");
                break;

            case "ContactoIndex":
                contacto.setNombre(nombre);
                contacto.setCorreo(email);
                contacto.setCelular(celular);
                contacto.setSelect_pqrs(select_pqrs);
                contacto.setMensaje(mensaje);

                try {
                    cdao.enviarContacto(contacto);
//                    String mensajeej = "<br> <div> <h3 style=\"color: #0ed1f0\"> ¡Hola administradora, te saluda: <strong>" + contacto.getNombre() + "</strong>! </h3> <br /> <p style=\"color: black\"> <strong>El correo electronico es: </strong><span style=\"color: #0ed1f0\">" + contacto.getCorreo() + "</span> </p> <p style=\"color: black\"> <strong style=\"color: #0ed1f0\">El celular es: </strong><span>" + contacto.getCelular() + "</span> </p> <p style=\"color: black\"> <span style=\"color: #0ed1f0\">Mensaje que te ha dejado: </span>\"" + contacto.getMensaje() + "\" </p> </div>";
//                    mail.Mensajes(email + " | Te ha contactado | " + nombre, "soportefbanimal@gmail.com", mensajeej);
                    mail.Mensajes("Gracias por comunicarte con nosotros | Fundación Bello Animal", email, "<div> <h3 style=\"color: #0ed1f0\"> ¡Gracias por comunicarte nosotros, <strong>" + contacto.getNombre() + "</strong>! </h3> <br /> <p> Para nosotros es muy valiosa tu opinión, quejas, sugerencias, etc. y por lo tanto pronto recibirás una respuesta a la inquietud que tengas. </p> <p> Te esperamos en nuestra aplicación. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación</a ></span > </p> </div>");
                    response.sendRedirect("index.jsp");
                } catch (IOException e) {
                    System.out.println("Error al agregar desde el controlador contacto." + e);
                }
                break;

            case "mensajesContacto":
                request.getRequestDispatcher("mensajesdeUsuarios.jsp").forward(request, response);
                break;

            case "contestadoContacto":
                String id = request.getParameter("id");
                try {
                    boolean ans = cdao.actualizarContacto(id);
                    if (ans) {
                        response.sendRedirect("listarContactos_admin.jsp");
                    } else {
                        request.getRequestDispatcher("Maestras.jsp").forward(request, response);
                    }
                } catch (IOException e) {
                    System.out.println("Error al actualizar.");
                }
                break;

            case "enviarCorreoContactoAdmin":
                id = request.getParameter("id");
                String asunto = request.getParameter("asunto_contacto_admin");
                mensaje = request.getParameter("mail_contacto_admin");
                email = request.getParameter("correo");
                System.out.println("Correoeoee_: " + email);
                try {
                    mail.Mensajes("Respuesta a PQRS | " + asunto + " | Fundación Bello Animal", email, "<div> <p>" + mensaje + "</p> <p> <span style=\"color: #0ed1f0\">Gracias por comunicarte con nosotros.</span> Te esperamos en nuestra aplicación. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación</a ></span > </p> </div>");
                    cdao.actualizarContacto(id);
                    response.sendRedirect("listarContactos_admin.jsp");
                } catch (IOException e) {
                    System.out.println("Error al actualizar.");
                }
                break;

            case "agregarContacto":
                contacto.setNombre(nombre);
                contacto.setCorreo(email);
                contacto.setCelular(celular);
                contacto.setSelect_pqrs(select_pqrs);
                contacto.setMensaje(mensaje);
                
                System.out.println("emaillll:: "+email);

                try {
                    mail.Mensajes("Gracias por comunicarte con nosotros | Fundación Bello Animal", email, "<div> <h3 style=\"color: #0ed1f0\"> ¡Gracias por comunicarte nosotros, <strong>" + contacto.getNombre() + "</strong>! </h3> <br /> <p> Para nosotros es muy valiosa tu opinión, quejas, sugerencias, etc. y por lo tanto pronto recibirás una respuesta a la inquietud que tengas. </p> <p> Te esperamos en nuestra aplicación. <span style=\"color: #0ed1f0\" ><a style=\"color: #0ed1f0\" href=\"https://fundacionbanimal.herokuapp.com/login.jsp\" >Ingresar a la aplicación</a ></span > </p> </div>");
                    cdao.enviarContacto(contacto);
                } catch (Exception e) {
                    System.out.println("Error al agregar desde el controlador contacto." + e);
                }
                break;
            default:
                request.getRequestDispatcher("index.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
