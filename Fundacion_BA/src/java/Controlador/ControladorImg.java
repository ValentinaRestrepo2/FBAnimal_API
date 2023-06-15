/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Conexion;
import Modelo.Mascota;
import Modelo.MascotaDAO;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrés Marín
 */
public class ControladorImg extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Mascota m = new Mascota();
    MascotaDAO mdao = new MascotaDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/png");

        Conexion con = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            ps = con.conectar().prepareStatement("SELECT FOTO_M FROM MASCOTAS WHERE ID_M = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosIMAGEN = new byte[tamanoInput];
            bos.read(datosIMAGEN, 0, tamanoInput);

            response.getOutputStream().write(datosIMAGEN);
            bos.close();
            ps.close();
            rs.close();
//            con.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println(ex.getMessage());
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
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            mdao.listarImg(id, response);
        } catch (Exception e) {
            System.out.println("Error en IMG listar " + e);
        }
//        Conexion con = new Conexion();
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        byte[] b = null;
//
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            pstm = con.conectar().prepareStatement("SELECT * FROM MASCOTAS WHERE ID_M=10043");
//            System.out.println("SELECT * FROM MASCOTAS WHERE ID_M=" + id);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                b = rs.getBytes(1);
//            }
//
//            InputStream bos = new ByteArrayInputStream(b);
//
//            int tamanInput = bos.available();
//            byte[] datosImagen = new byte[tamanInput];
//            bos.read(datosImagen, 0, tamanInput);
//
//            response.getOutputStream().write(datosImagen);
//            bos.close();
//            pstm.close();
//            rs.close();
//        } catch (IOException | NumberFormatException | SQLException e) {
//            System.out.println("Error en IMG listar " + e);
//        }
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
        processRequest(request, response);
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
