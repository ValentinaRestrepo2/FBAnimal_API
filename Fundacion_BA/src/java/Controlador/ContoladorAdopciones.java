package Controlador;

import Modelo.Adopcion;
import Modelo.AdopcionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ZENBOOK
 */
public class ContoladorAdopciones extends HttpServlet {

    private final AdopcionDAO addao = new AdopcionDAO();
    private final Adopcion ado = new Adopcion();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
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
                List<Adopcion> datos = addao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("Listar_adopciones.jsp").forward(request, response);
                break;
            case "Nuevo":
                request.getRequestDispatcher("registrar_adopcion.jsp").forward(request, response);
                break;
            case "Registrar":
                String id_usuario = request.getParameter("id_usuario_bd");
                String id_mascotas = request.getParameter("id_mascota");

                String nombrefamiliar = request.getParameter("nombrefamiliar");
                String ocupacionfamiliar = request.getParameter("ocupacionfamiliar");
                String celularfamiliar = request.getParameter("celularfamiliar");
                String tuvo_mascotas = request.getParameter("tuvo_mascotas");

                String nom_mascotas_tuvo = request.getParameter("nom_mascotas_tuvo");
                String motivo_adopcion = request.getParameter("motivo_adopcion");
                String tiene_mascota = request.getParameter("tiene_mascota");
                String estrato = request.getParameter("estrato");
                String tipo_vivienda = request.getParameter("tipo_vivienda");
                String propia_vivienda = request.getParameter("propia_vivienda");
                String vivo_con = request.getParameter("vivo_con");
                String rango_salarial = request.getParameter("rango_salarial");

                ado.setId_usuario(id_usuario);
                ado.setId_mascota(id_mascotas);
                ado.setNombre_familiar(nombrefamiliar);
                ado.setOcupacion_familiar(ocupacionfamiliar);
                ado.setCelular_familiar(celularfamiliar);
                ado.setTipo_tuvo_mascota(tuvo_mascotas);
                ado.setNum_tuvo_mascota(nom_mascotas_tuvo);
                ado.setMotivo_adopcion(motivo_adopcion);
                ado.setTiene_mascota(tiene_mascota);
                ado.setEstrato_vivienda(estrato);
                ado.setTipo_vivienda(tipo_vivienda);
                ado.setPropia_vivienda(propia_vivienda);
                ado.setCantidad_familia(vivo_con);
                ado.setRango_salarial(rango_salarial);
                int agrego = addao.enviarSolicitudAdopcion(ado);
                System.out.println("***--------*****");
                System.out.println(nombrefamiliar + " - "
                        + ocupacionfamiliar + " - " + celularfamiliar
                        + " - " + tuvo_mascotas + " - " + nom_mascotas_tuvo
                        + " - " + motivo_adopcion + " - " + tiene_mascota
                        + " - " + estrato + " - " + tipo_vivienda + " - " + propia_vivienda
                        + " - " + vivo_con + " - " + rango_salarial + " - " + id_mascotas + " - " + id_usuario
                );

                if (agrego == 1) {
                    response.sendRedirect("adopciones_visitante.jsp");
                } else {
                    response.sendRedirect("mascotas_visitante.jsp");
                }
                System.out.println(agrego);
                System.out.println("***--------*****");
                //request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            case "Editar":
                String ide = request.getParameter("id");
//                Adopcion adopc = addao.listarId(ide);
//                request.setAttribute("adopcion", adopc);
                request.getRequestDispatcher("Editar_Adopcion.jsp").forward(request, response);
                break;
            case "Actualizar":
                String id_adop1 = request.getParameter("txtidadop1");
                String id_adoptante1 = request.getParameter("txtidadoptante1");
                String id_mascotas1 = request.getParameter("txtidmascota1");
                String fecha1 = request.getParameter("txtfecha1");
                String aprobacion1 = request.getParameter("txtaprobacion1");
//                ado.setId(id_adop1);
//                ado.setId_adoptante(id_adoptante1);
//                ado.setId_mascota(id_mascotas1);
//                ado.setFecha_adopcion(fecha1);
//                ado.setAprobacion(aprobacion1);
//                addao.actualizar(ado);
                request.getRequestDispatcher("ControladorAdopcion?accion=Listar").forward(request, response);
                break;
            case "Eliminar":
                String id2 = request.getParameter("id");
//                addao.eliminar(id2);
                request.getRequestDispatcher("ControladorAdopcion?accion=Listar").forward(request, response);
                break;
            case "cancelarSolicitud":
                String id_solicitud = request.getParameter("id_solicitud");
                int elimino = addao.cancelarSolicitudAdopcion(id_solicitud);
                if (elimino == 1) {
                    response.sendRedirect("adopciones_visitante.jsp");
                }
                break;
            case "cancelarSolicitudAdmin":
                id_solicitud = request.getParameter("id_solicitud");
                elimino = addao.cancelarSolicitudAdopcion(id_solicitud);
                if (elimino == 1) {
                    response.sendRedirect("listar_adopciones.jsp");
                }
                break;
            case "verSolicitudAdopcion":
                String idreview = request.getParameter("id_usuario_bd");
                response.sendRedirect("verSolicitudAdopcion.jsp?k=" + idreview + "&m="+request.getParameter("id_mascota_bd"));
                break;
            case "rechazarSolicitudAdmin":
                id_solicitud = request.getParameter("id_solicitud");
                elimino = addao.rechazarSolicitudAdmin(id_solicitud);
                if (elimino == 1) {
                    response.sendRedirect("listar_adopciones.jsp");
                }
                break;
            case "AprobarSolicitudAdmin":
                id_solicitud = request.getParameter("id_solicitud");
                String id_mascota = request.getParameter("id_mascota");
                System.out.println("idMascota: "+id_mascota);
                elimino = addao.AprobarSolicitudAdmin(id_solicitud);
                addao.cambiarEstadoMascota(id_mascota);
                if (elimino == 1) {
                    response.sendRedirect("listar_adopciones.jsp");
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
