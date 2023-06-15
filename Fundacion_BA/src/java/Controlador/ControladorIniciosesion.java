/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Usuario;
import Modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author ZENBOOK
 */
public class ControladorIniciosesion extends HttpServlet {

    UsuarioDAO dao = new UsuarioDAO();
    Usuario u = new Usuario();
    HttpSession cerrar_sesion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
        String accion = request.getParameter("accion");
        switch (accion) {
            case "logout":
                cerrar_sesion = request.getSession();
                cerrar_sesion.removeAttribute("datosUser");
                cerrar_sesion.invalidate();
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "key":
                request.getRequestDispatcher("perfil.jsp").forward(request, response);
                break;

            default:
                request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String accion = request.getParameter("accion");
        HttpSession nueva_sesion;
        String password = "";
        String passActual = "";
        String idDesencrip = "";
        int rspta = 0;
        switch (accion) {
            case "Login":
                String idLogin = request.getParameter("Identificacion");
                String passLogin = request.getParameter("password");
                System.out.println(passLogin + "_Passlogin");
                u.setId(idLogin);
                u.setPassword(passLogin);
                try {
                    rspta = dao.validar(u);

                    System.out.println("Soy rspta )= " + rspta);
                    if (rspta != 0) {
                        u = dao.listarId(idLogin);
                    } else {
                        return;
                    }
                } catch (Exception ex) {
                    System.out.println("Error al login: " + ex);
                }

                if (idLogin.isEmpty() || passLogin.isEmpty()) {
                    rspta = 2;
                    response.sendRedirect("login.jsp?rspta=" + rspta);

                } else if (idLogin.isEmpty() && passLogin.isEmpty()) {
                    rspta = 2;
                    response.sendRedirect("login.jsp?rspta=" + rspta);
                } else if (rspta == 4) {
                    response.sendRedirect("login.jsp?rspta=" + rspta);
                } else {

                    nueva_sesion = request.getSession();
                    System.out.println("datosuser: " + u.getNombre());
                    System.out.println("FECHA NACIMIENTO: " + u.getFecha_nacimiento());
                    //DATOS ENVIAR
                    System.out.println("eqeqeq- - "+ u.getId_usuario_bd());
                    nueva_sesion.setAttribute("id_usuario_bd", u.getId_usuario_bd());
                    nueva_sesion.setAttribute("datosUser", u.getNombre());
                    nueva_sesion.setAttribute("primerApellido", u.getPrimer_apellido());
                    nueva_sesion.setAttribute("segApellido", u.getSegundo_apellido());
                    nueva_sesion.setAttribute("idDesencriptado", u.getId());
                    nueva_sesion.setAttribute("idEncriptado", dao.Encriptar(u.getId()));
                    nueva_sesion.setAttribute("direccion", u.getDireccion());
                    nueva_sesion.setAttribute("puesto", u.getPuesto_trabajo());
                    nueva_sesion.setAttribute("email", u.getCorreo());
                    nueva_sesion.setAttribute("fecha", u.getFecha_nacimiento());
                    nueva_sesion.setAttribute("celular", u.getCelular());
                    nueva_sesion.setAttribute("estado_civil", u.getEstado_civil());
                    nueva_sesion.setAttribute("barrio", u.getBarrio());
                    nueva_sesion.setAttribute("typeusuario", u.getTipo_usuario());
                    switch (u.getTipo_usuario()) {
                        case 2:
                            response.sendRedirect("inicio_usuario.jsp");
                            break;
                        case 1:
                            response.sendRedirect("Maestras.jsp");
                            break;
                        default:
                            response.sendRedirect("index.jsp");
                            break;
                    }
                }

                break;

            case "ActualizarContra":
                password = request.getParameter("pass");
                passActual = request.getParameter("passactual");
                idDesencrip = request.getParameter("idDesencrip");
                String contraActualValidar = request.getParameter("contraActual");
                try {
                    rspta = dao.validarPassword(passActual, idDesencrip);
                    if (rspta == 0) {
                        response.sendRedirect("contra_visitante.jsp?rspta=2");
                    } else if (rspta == 1) {
                        System.out.println("Estas en lo correcto");
                        u.setId(idDesencrip);
                        u.setPassword(password);
                        if (dao.actualizarPassword(u) == 1) {
                            response.sendRedirect("contra_visitante.jsp?rspta=1");
                        } else {
                            response.sendRedirect("contra_visitante.jsp?rspta=4");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Error al login: " + ex);
                }

                break;
            case "ActualizarContraAdmin":
                password = request.getParameter("pass");
                passActual = request.getParameter("passactual");
                idDesencrip = request.getParameter("idDesencrip");
                contraActualValidar = request.getParameter("contraActual");
                try {
                    rspta = dao.validarPassword(passActual, idDesencrip);
                    if (rspta == 0) {
                        response.sendRedirect("contra_admin.jsp?rspta=2");
                    } else if (rspta == 1) {
                        System.out.println("Estas en lo correcto");
                        u.setId(idDesencrip);
                        u.setPassword(password);
                        if (dao.actualizarPassword(u) == 1) {
                            response.sendRedirect("contra_admin.jsp?rspta=1");
                        } else {
                            response.sendRedirect("contra_admin.jsp?rspta=4");
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Error al login: " + ex);
                }

                break;
            case "ActualizarPerfil": 
                try {
                String nom = request.getParameter("Nombre");
                String pa = request.getParameter("pri_ape");
                String sa = request.getParameter("seg_ape");
                String correo = request.getParameter("email");
                String celular = request.getParameter("celular");
                String dir = request.getParameter("direccion");
                String trabajo = request.getParameter("puesto_trabajo");
                int estado_civil = Integer.parseInt(request.getParameter("select_civil"));
                idDesencrip = request.getParameter("idDesencrip");
                u.setId(idDesencrip);
                u.setNombre(nom);
                u.setPrimer_apellido(pa);
                u.setSegundo_apellido(sa);
                u.setCorreo(correo);
                u.setCelular(celular);
                u.setDireccion(dir);
                u.setEstado_civil(estado_civil);
                u.setPuesto_trabajo(trabajo);
                rspta = dao.actualizarUser(u);
                if (rspta == 1) {
                    System.out.println("SE HA ACTUALIADO");
                    cerrar_sesion = request.getSession();
                    cerrar_sesion.removeAttribute("datosUser");
                    cerrar_sesion.invalidate();
                    request.getRequestDispatcher("login.jsp?rspta=84774").forward(request, response);
                }
            } catch (Exception e) {
                System.out.println("Error al actualizar user: " + e);
            }
            break;

            case "eliminarMyCuenta": 
            try {
                idDesencrip = request.getParameter("idDesencrip");
                System.out.println("idDesencripidDesencripidDesencrip: "+idDesencrip);
                rspta = dao.eliminar(idDesencrip);
                if (rspta == 1 || rspta == 0) {
                    response.sendRedirect("listar_usuarios.jsp");
                } else {
                    response.sendRedirect("listar_usuarios.jsp");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error al actualizar user: " + e);
            }
            break;
            
            case "eliminarCountAdmin": 
            try {
                idDesencrip = request.getParameter("idDesencrip");
                System.out.println("");
                rspta = dao.eliminar(idDesencrip);
                System.out.println(rspta + "______");
                if (rspta == 1 || rspta == 0) {
                    System.out.println("Error al eliminar");
                    response.sendRedirect("perfil_admin.jsp");
                } else {
                    System.out.println("Se ha eliminado");
                    cerrar_sesion = request.getSession();
                    cerrar_sesion.removeAttribute("datosUser");
                    cerrar_sesion.invalidate();
                    response.sendRedirect("login.jsp?rspta=894847");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al actualizar user: " + e);
            }
            break;
            
            
            case "eliminarMyCountVisitante": 
            try {
                idDesencrip = request.getParameter("idDesencrip");
                System.out.println("");
                rspta = dao.eliminar(idDesencrip);
                System.out.println(rspta + "______");
                if (rspta == 1 || rspta == 0) {
                    System.out.println("Error al eliminar");
                    response.sendRedirect("perfil_visitante.jsp");
                } else {
                    System.out.println("Se ha eliminado");
                    cerrar_sesion = request.getSession();
                    cerrar_sesion.removeAttribute("datosUser");
                    cerrar_sesion.invalidate();
                    response.sendRedirect("login.jsp?rspta=894847");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al actualizar user: " + e);
            }
            break;
            case "perfiladmin":
                response.sendRedirect("perfil_admin.jsp");
                break;
            default:
                System.out.println("Errror ruta");
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
