/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Contacto;
import Modelo.ContactoDAO;
import Modelo.Informes;
import Modelo.InformesDAO;
import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Andrés Marín
 */
@MultipartConfig(maxFileSize = 16177215)
public class ControladorVisitante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    MascotaDAO mdao = new MascotaDAO();
    Mascota m = new Mascota();
    Contacto contacto = new Contacto();
    ContactoDAO cdao = new ContactoDAO();
    Informes informe = new Informes();
    InformesDAO informeDAO = new InformesDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorVisitante</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorVisitante at " + request.getContextPath() + "</h1>");
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
        String visitante = request.getParameter("visitante");
        switch (visitante) {
            case "mascotas":
//                ArrayList<Mascota> datos = new ArrayList<>();
//                datos = mdao.listMascostasDisponibles();
//                if (datos != null) {
//                    request.setAttribute("datos", datos);
//                    request.getRequestDispatcher("mascotas_visitante.jsp").forward(request, response);
//                    response.sendRedirect("mascotas_visitante.jsp");
//                } else {
//                    request.setAttribute("datos", datos);
//                    request.getRequestDispatcher("mascotas_visitante.jsp").forward(request, response);
//                }
                response.sendRedirect("mascotas_visitante.jsp");
                break;
            case "anuncio":
                response.sendRedirect("anuncio_visitante.jsp");
                break;

            case "adopcioneslist":
                response.sendRedirect("adopciones_visitante.jsp");
                break;

            case "perfil":
                response.sendRedirect("perfil_visitante.jsp");
                break;

            case "informe":
                response.sendRedirect("informe_visitante.jsp");
                break;

            case "home":
                response.sendRedirect("inicio_usuario.jsp");
                break;

            case "cambiarcontra":
                response.sendRedirect("contra_visitante.jsp");
                break;

            case "donarVisitante":
                response.sendRedirect("donar_visitante.jsp");
                break;

            case "contactoUsuario":
                response.sendRedirect("mensajesdeUsuarios.jsp");
                break;

            case "agregarContactoUsuario":
                contacto.setNombre(nombre);
                contacto.setCorreo(email);
                contacto.setCelular(celular);
                contacto.setSelect_pqrs(select_pqrs);
                contacto.setMensaje(mensaje);
                boolean ans = cdao.enviarContacto(contacto);
                if (ans) {
                    response.sendRedirect("mensajesdeUsuarios.jsp?rspta=2295695");
                } else {
                    response.sendRedirect("mensajesdeUsuarios.jsp?rspta=3051518");
                }
                break;
            case "AdoptarVisitante":
                String idmascotaDoptar = request.getParameter("idmascotaDoptar");
                String nameMascotaAdoptar = request.getParameter("nameMascotaAdoptar");
                request.setAttribute("nameMascotaAdoptar", nameMascotaAdoptar);
                request.setAttribute("idmascotaDoptar", idmascotaDoptar);
                request.getRequestDispatcher("informacionAdoptarMascota.jsp").forward(request, response);
                break;

            case "formularioAdoptarVisitante":
                String idmascotaDopsstar = request.getParameter("idmascotaDoptar");
                String nameMascotaAdossptar = request.getParameter("nameMascotaAdoptar");
                request.setAttribute("nameMascotaAdoptar", idmascotaDopsstar);
                request.setAttribute("idmascotaDoptar", nameMascotaAdossptar);
                request.getRequestDispatcher("formAdoptar_visitante.jsp").forward(request, response);
                break;

            case "enviar_informe":
                String descripcion_informe = request.getParameter("descripcion_informe");
                String mensaje_admin = request.getParameter("mensaje_admin");
                String mascota_informe = request.getParameter("mascota_informe");
                String id_usuario_bd = request.getParameter("id_usuario_bd");
                Part foto = request.getPart("foto_informe");

                InputStream inputStream = null;
                if (foto.getSize() > 0) {
                    System.out.println(foto.getName());
                    String n = String.valueOf(foto.getContentType());
                    inputStream = foto.getInputStream();
                }
                try {
                    if (inputStream != null) {
                        informe.setDescripcion_informe(descripcion_informe);
                        informe.setMensaje_informe(mensaje_admin);
                        informe.setMascota_informe(mascota_informe);
                        informe.setUsuario_informe(id_usuario_bd);
                        informe.setFoto(inputStream);
                        informeDAO.agregarInforme(informe);
                    }
                } catch (Exception e) {
                }

                response.sendRedirect("informe_visitante.jsp");
                break;
            default:
                throw new AssertionError();
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
