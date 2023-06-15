/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.AnuncioDAO;
import Modelo.Anuncios;
import Modelo.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author ZENBOOK
 */
@MultipartConfig(maxFileSize = 16177215)
public class ControladorAnuncios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    AnuncioDAO adao = new AnuncioDAO();
    Anuncios an = new Anuncios();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorAnuncios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorAnuncios at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("anuncio");
        int rspta = 0;
        switch (accion) {
            case "anuncioList":
                response.sendRedirect("listar_anuncios.jsp");
                break;
            default:
                throw new AssertionError();
        }

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
        String accion = request.getParameter("anuncio");
        HttpSession nueva_sesion;
        int rspta = 0;
        switch (accion) {
            case "anuncioList":
                response.sendRedirect("listar_anuncios.jsp");
                break;
            case "anuncioDelete":
                String id = request.getParameter("id");
                adao.eliminar(id);
                response.sendRedirect("listar_anuncios.jsp");
                break;
            case "anuncioEdit":
                an.setNombre_anuncio(request.getParameter("edit_name_anuncio"));
                an.setDescripcion(request.getParameter("desc_edit_anuncio"));
                an.setCosto(Integer.parseInt(request.getParameter("costo_edit_anuncio")));
                an.setId_anuncio(request.getParameter("id"));
                adao.actualizarMascota(an);
                response.sendRedirect("listar_anuncios.jsp");
                break;
            case "anuncioAdd":
                try {
                nueva_sesion = request.getSession();
                String nom = request.getParameter("nom_anuncio");
                String desc = request.getParameter("desc_anuncio");
                int costo = Integer.parseInt(request.getParameter("costo_anuncio"));
                Part foto = request.getPart("foto_anuncio");
                InputStream inputStream = null;
                if (foto.getSize() > 0) {
                    System.out.println(foto.getName());
                    String n = String.valueOf(foto.getContentType());
                    inputStream = foto.getInputStream();
                }
                try {
                    if (inputStream != null) {
                        an.setNombre_anuncio(nom);
                        an.setDescripcion(desc);
                        an.setCosto(costo);
                        an.setFoto(inputStream);
                        System.out.println("--- __ 22--- " + nueva_sesion.getAttribute("id_usuario_bd"));
                        int id2 = Integer.parseInt((String) nueva_sesion.getAttribute("id_usuario_bd"));
                        rspta = adao.agregar(an,  id2);
                    }
                } catch (Exception e) {
                }
                if (rspta == 1) {
                    response.sendRedirect("listar_anuncios.jsp");
                } else {
                    response.sendRedirect("listar_anuncios.jsp");
                }
            } catch (IOException | NumberFormatException | ServletException e) {
                System.out.println("Error al agregar imagenn: " + e);
            }
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
