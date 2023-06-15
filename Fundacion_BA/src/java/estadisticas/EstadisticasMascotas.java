/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package estadisticas;

import Modelo.Conexion;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author PC
 */
public class EstadisticasMascotas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/PNG");
        OutputStream out = response.getOutputStream();
        try {
            Conexion c = new Conexion();
            Connection con;
            con = c.conectar();
            PreparedStatement ps = null;
            ResultSet rs = null;

            int adoptados = 0;
            int fallecidos = 0;
            int disponible = 0, nodisponible = 0;
            ps = con.prepareStatement("select DISPONI_M from mascotas");
            rs = ps.executeQuery();

            while (rs.next()) {
                int validate = rs.getInt(1);
                System.out.println("validate:: " + validate);
                if (validate == 1) {
                    disponible++;
                }
                if (validate == 2) {
                    nodisponible++;
                }
                if (validate == 3) {
                    adoptados++;
                }
                if (validate == 4) {
                    fallecidos++;
                }
            }

            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Disponibles: " + String.valueOf(disponible), disponible);
            data.setValue("NO disponibles: " + String.valueOf(nodisponible), nodisponible);
            data.setValue("Adoptados: " + String.valueOf(adoptados), adoptados);
            data.setValue("Fallecidos: " + String.valueOf(fallecidos), fallecidos);

            JFreeChart cha = ChartFactory.createPieChart3D("Información Mascotas", data, true, true, true);
            int ancho = 750;
            int alto = 600;
            ChartUtilities.writeChartAsPNG(out, cha, ancho, alto);

            ps.close();
            rs.close();
            c.desconectar();

        } catch (Exception e) {
            out.close();
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

        String accion = request.getParameter("accion");
        switch (accion) {
            case "ListarReportes":
                response.sendRedirect("estadisticamascotas.jsp");
                break;
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
