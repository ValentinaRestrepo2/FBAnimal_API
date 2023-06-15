package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author ZENBOOK
 */
@MultipartConfig(maxFileSize = 16177215)
public class ControladorMascota extends HttpServlet {

    MascotaDAO mdao = new MascotaDAO();
    Mascota m = new Mascota();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        int rspta = 0;
        String id = "";
        switch (accion) {
            case "Listar":
//                List<Mascota> datos = mdao.listar();
//                if (datos != null) {
//                    request.setAttribute("datos", datos);
//                    request.getRequestDispatcher("listar_mascotas.jsp").forward(request, response);
//                } else {
//                    request.setAttribute("datos", datos);
//                    request.getRequestDispatcher("listar_mascotas.jsp").forward(request, response);
//                }
                response.sendRedirect("listar_mascotas.jsp");
                break;
            case "Registrar":
                //id = request.getParameter("txtid")
                try {
                String nom = request.getParameter("name_mascota");
                String desc = request.getParameter("desc_mascota");
                String raza = request.getParameter("raza_mascota");
                String edad = request.getParameter("edad_mascota");
                String genero_mascota = request.getParameter("genero_mascota");
                Part foto = request.getPart("foto_mascota");
                int vacunado = Integer.parseInt(request.getParameter("select_vacunado"));
                int esterilizado = Integer.parseInt(request.getParameter("select_esterilizado"));
                int disponibilidad = Integer.parseInt(request.getParameter("select_disponibilidad"));
                InputStream inputStream = null;
                if (foto.getSize() > 0) {
                    System.out.println(foto.getName());
                    String n = String.valueOf(foto.getContentType());
                    inputStream = foto.getInputStream();
                }
                try {
                    if (inputStream != null) {
                        m.setNombre(nom);
                        m.setDescripcion(desc);
                        m.setRaza(raza);
                        m.setEdad(edad);
                        m.setVacunado(vacunado);
                        m.setEsterilizado(esterilizado);
                        m.setDisponibilidad(disponibilidad);
                        m.setFoto(inputStream);
                        m.setGenero_mascota(genero_mascota);
                        rspta = mdao.agregar(m);
                    }
                } catch (Exception e) {
                }
                if (rspta == 1) {
                    System.out.println("se ha agregado");
                    response.sendRedirect("listar_mascotas.jsp");
                } else {
                    response.sendRedirect("listar_mascotas.jsp");
                }
            } catch (IOException | NumberFormatException | ServletException e) {
                System.out.println("Error al agregar imagenn: " + e);
            }
            break;
            case "Editar":
                String ide = request.getParameter("id");
                Mascota mas = mdao.listarId(ide);
                request.setAttribute("mascota", mas);
                request.getRequestDispatcher("EditarMascota.jsp").forward(request, response);
                break;

            case "Eliminar":
                try {
                id = request.getParameter("id");
                rspta = mdao.eliminar(id);
                if (rspta == 1) {
                    response.sendRedirect("listar_mascotas.jsp");
                } else {
                    response.sendRedirect("listar_mascotas.jsp");
                }
            } catch (IOException e) {
                System.out.println("Error en el controlador de Eliminar.");
            }
            break;
            case "actualizarMascota": 
                try {
                id = request.getParameter("id");
                String nom = request.getParameter("name_mascota_edit");
                String desc = request.getParameter("desc_mascota_edit");
                String raza = request.getParameter("raza_mascota_edit");
                String edad = request.getParameter("edad_mascota_edit");
                int vacunado = Integer.parseInt(request.getParameter("select_vacunado_edit"));
                int esterilizado = Integer.parseInt(request.getParameter("select_esterilizado_edit"));
                int disponibilidad = Integer.parseInt(request.getParameter("select_disponibilidad_edit"));
                m.setId(id);
                m.setNombre(nom);
                m.setDescripcion(desc);
                m.setRaza(raza);
                m.setEdad(edad);
                m.setVacunado(vacunado);
                m.setEsterilizado(esterilizado);
                m.setDisponibilidad(disponibilidad);
                rspta = mdao.actualizarMascota(m);
                System.out.println("actualizar mascotaa" + rspta);
                if (rspta == 1) {
                    response.sendRedirect("listar_mascotas.jsp");
                } else {
                    response.sendRedirect("listar_mascotas.jsp");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Agregar imagennn ERRROR" + e);
            }
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
