<%-- 
    Document   : listar_adopciones
    Created on : 11/01/2022, 8:25:21 p. m.
    Author     : ZENBOOK
--%>
<%@page import="Modelo.Adopcion"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.AdopcionDAO"%>
<%-- 
    Document   : listar_usuarios
    Created on : 11/01/2022, 8:16:04 p. m.
    Author     : ZENBOOK
--%>


<%@page import="Modelo.UsuarioDAO"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.MascotaDAO"%>
<%@page import="Modelo.Mascota"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
    String usuario = (String) session.getAttribute("datosUser");
    String id = (String) session.getAttribute("id_usuario_bd");
    int typeuser = (int) session.getAttribute("typeusuario");
    if (null == session || usuario == "" || usuario == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="icon" type="image/png" sizes="16x16" href="images/apple-icon-114x114.png">

        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>Solicitudes de adopción | Fundación Bello Animal</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">  
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <script src="js/BuscadorTabla.js" type="text/javascript"></script>
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <%
        UsuarioDAO udao = new UsuarioDAO();
        AdopcionDAO adopcion = new AdopcionDAO();
        Usuario u = new Usuario();
        Adopcion adop = new Adopcion();
    %>
    <body class="main-layout contineer_page">
        <!-- loader  -->
        <!-- end loader -->
        <!-- header -->
        <header>
            <div class="header">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col logo_section">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo">
                                        <a href="Maestras.jsp"><img src="images/Logo2.png" width="100" height="100" alt="#" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-9">
                            <div class="menu-area">
                                <nav class="main-menu">
                                    <ul class="menu-area-main">
                                        <li> <form method="POST" action="ControladorUsuario">
                                                <button type="submit" value="home" name="accion" class="backgro-transparente text-white w_100_menu">
                                                    <a class="d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-house-door-fill" viewBox="0 0 16 16">
                                                        <path d="M6.5 14.5v-3.505c0-.245.25-.495.5-.495h2c.25 0 .5.25.5.5v3.5a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4a.5.5 0 0 0 .5-.5z"/>
                                                        </svg>&nbsp;&nbsp;
                                                        INICIO</a>
                                                </button>
                                            </form>
                                        </li>
                                        <li>
                                            <a style="color: white" class="d-flex align-items-center w_100_menu text-negro-menu">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                                                </svg> &nbsp;&nbsp;Menú</a>
                                            <ul style="background-color: #efefef;width: 180px;border-radius: 20px">
                                                <li> <form method="POST" action="ControladorUsuario" >
                                                        <button type="submit" value="Listar" name="accion" class="w_100_menu backgro-transparente2" >
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-people-fill" viewBox="0 0 16 16">
                                                                <path d="M7 14s-1 0-1-1 1-4 5-4 5 3 5 4-1 1-1 1H7zm4-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                                                <path fill-rule="evenodd" d="M5.216 14A2.238 2.238 0 0 1 5 13c0-1.355.68-2.75 1.936-3.72A6.325 6.325 0 0 0 5 9c-4 0-5 3-5 4s1 1 1 1h4.216z"/>
                                                                <path d="M4.5 8a2.5 2.5 0 1 0 0-5 2.5 2.5 0 0 0 0 5z"/>
                                                                </svg> &nbsp;&nbsp;
                                                                Usuarios</a>
                                                        </button>
                                                    </form></li>
                                                <li> <form method="POST" action="ControladorMascota">
                                                        <button type="submit" value="Listar" name="accion" class="w_100_menu backgro-transparente2">
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-piggy-bank-fill" viewBox="0 0 16 16">
                                                                <path fill-rule="evenodd" d="M7.964 1.527c-2.977 0-5.571 1.704-6.32 4.125h-.55A1 1 0 0 0 .11 6.824l.254 1.46a1.5 1.5 0 0 0 1.478 1.243h.263c.3.513.688.978 1.145 1.382l-.729 2.477a.5.5 0 0 0 .48.641h2a.5.5 0 0 0 .471-.332l.482-1.351c.635.173 1.31.267 2.011.267.707 0 1.388-.095 2.028-.272l.543 1.372a.5.5 0 0 0 .465.316h2a.5.5 0 0 0 .478-.645l-.761-2.506C13.81 9.895 14.5 8.559 14.5 7.069c0-.145-.007-.29-.02-.431.261-.11.508-.266.705-.444.315.306.815.306.815-.417 0 .223-.5.223-.461-.026a.95.95 0 0 0 .09-.255.7.7 0 0 0-.202-.645.58.58 0 0 0-.707-.098.735.735 0 0 0-.375.562c-.024.243.082.48.32.654a2.112 2.112 0 0 1-.259.153c-.534-2.664-3.284-4.595-6.442-4.595zm7.173 3.876a.565.565 0 0 1-.098.21.704.704 0 0 1-.044-.025c-.146-.09-.157-.175-.152-.223a.236.236 0 0 1 .117-.173c.049-.027.08-.021.113.012a.202.202 0 0 1 .064.199zm-8.999-.65A6.613 6.613 0 0 1 7.964 4.5c.666 0 1.303.097 1.893.273a.5.5 0 1 0 .286-.958A7.601 7.601 0 0 0 7.964 3.5c-.734 0-1.441.103-2.102.292a.5.5 0 1 0 .276.962zM5 6.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0z"/>
                                                                </svg> &nbsp;&nbsp;
                                                                Mascotas</a>
                                                        </button> 
                                                    </form>
                                                </li>
                                                <li> <form method="POST" action="ControladorUsuario">
                                                        <button type="submit" value="adopcionesList" name="accion" class="w_100_menu backgro-transparente2" >
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-bookmark-heart-fill" viewBox="0 0 16 16">
                                                                <path d="M2 15.5a.5.5 0 0 0 .74.439L8 13.069l5.26 2.87A.5.5 0 0 0 14 15.5V2a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v13.5zM8 4.41c1.387-1.425 4.854 1.07 0 4.277C3.146 5.48 6.613 2.986 8 4.412z"/>
                                                                </svg>&nbsp;&nbsp;
                                                                Solicitudes</a>
                                                        </button>
                                                    </form>
                                                </li>
                                                <li> <form method="POST" action="ControladorContacto ">
                                                        <button type="submit" value="ListarContactos" name="accion" class="w_100_menu backgro-transparente2" >
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-chat-fill" viewBox="0 0 16 16">
                                                                <path d="M8 15c4.418 0 8-3.134 8-7s-3.582-7-8-7-8 3.134-8 7c0 1.76.743 3.37 1.97 4.6-.097 1.016-.417 2.13-.771 2.966-.079.186.074.394.273.362 2.256-.37 3.597-.938 4.18-1.234A9.06 9.06 0 0 0 8 15z"/>
                                                                </svg>&nbsp;&nbsp;
                                                                PQRS</a>
                                                        </button>
                                                    </form>
                                                </li>
                                                <li> <form method="POST" action="ControladorAnuncios ">
                                                        <button type="submit" value="anuncioList" name="anuncio" class="w_100_menu backgro-transparente2" >
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
                                                                <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
                                                                </svg>&nbsp;&nbsp;
                                                                Anuncios</a>
                                                        </button>
                                                    </form>
                                                </li>
                                                <li> <form method="POST" action="ControladorInformes">
                                                        <button type="submit" value="listarInformesAdmin" name="accion" class="w_100_menu backgro-transparente2" >
                                                            <a class="d-flex w_100_menu">
                                                                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-card-list" viewBox="0 0 16 16">
                                                                <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h13zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2h-13z"/>
                                                                <path d="M5 8a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7A.5.5 0 0 1 5 8zm0-2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm0 5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1-.5-.5zm-1-5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zM4 8a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0zm0 2.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
                                                                </svg>&nbsp;&nbsp;
                                                                Informes</a>
                                                        </button>
                                                    </form>
                                                </li>
                                                <li></li>
                                            </ul>
                                        </li>
                                        <li class="active"><form method="POST" action="ControladorIniciosesion "> 
                                                <button type="submit" value="perfiladmin" name="accion" class="backgro-transparente text-white w_100_menu">
                                                    <a class="d-flex align-items-center">
                                                        <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person-fill text-center" viewBox="0 0 16 16">
                                                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                                                        </svg>&nbsp;&nbsp;
                                                        <%=session.getAttribute("datosUser")%>
                                                    </a>
                                                </button>
                                            </form></li>
                                        <li class="w_100_menu"> <a class="d-flex w_100_menu " href="ControladorIniciosesion?accion=logout" class="text-danger font-weight-bold"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-box-arrow-right color-azul font-weight-bold" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                                <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                                                </svg></a> </li>
                                    </ul>
                                </nav>

                            </div> 
                        </div>
                    </div>
                </div>
            </div>
            <!-- end header inner -->

            <!-- end header -->
        </header>
        <div class="backgro_mh">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="heding">
                            <h2 style="font-weight: 700">Solicitudes de adopción</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="fondo6" style="margin-top: 0px">
            <div class="container">
                <div class="col-xl-12">
                    <div class="row">
                        <div class="form-inline mt-3 pb-3"> 
                            <div class="input-group">
                                <span class="input-group-text" id="basic-addon1">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                                    </svg>
                                </span>
                                <input type="search" name="txtBuscar" class="form-control" id="searchTerm" onkeyup="doSearch()" placeholder="Buscar ">
                            </div>
                        </div>                        
                        <table class="tabla2 table table-responsive table-hover">
                            <thead>
                                <tr>
                                    <th>Cod. Solicitud</th>
                                    <th>Cod. Mascota</th>
                                    <th>Nombre mascota</th>
                                    <th>Nombre adoptante</th>
                                    <th>Correo</th>
                                    <th>Celular</th>
                                    <th>Fecha de nacimiento</th>
                                    <th>Fecha de solicitud</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    List<Adopcion> datos;
                                    datos = null;
                                    datos = adopcion.listarSolicitudesAdopcion();
                                    if (datos != null) {
                                        for (Adopcion adopx : datos) {%>
                                <tr>
                                    <td><%=adopx.getId_solicitud()%></td>
                                    <td><%=adopx.getId_mascota()%></td>
                                    <td><%=adopx.getNombre_m()%></td>
                                    <td><%=adopx.getNombre()%> <%=adopx.getPrimer_apellido()%></td>
                                    <td><%=adopx.getCorreo()%></td>
                                    <td><%=adopx.getCelular()%></td>
                                    <td><%=adopx.getFecha_nacimiento()%></td>
                                    <td><%=adopx.getFecha_solicitud()%></td>
                                    <% if (adopx.getEstado().equals("1")) {%>
                                    <td class="text-success font-weight-bold " style="font-size: 17px">Aprobado</td>
                                    <%} else if (adopx.getEstado().equals("2")) {%>
                                    <td class="text-warning font-weight-bold" style="font-size: 17px">Pendiente</td>
                                    <%} else if (adopx.getEstado().equals("3")) {%>
                                    <td class="text-danger font-weight-bold" style="font-size: 17px">Rechazado</td>
                                    <%} else if (adopx.getEstado().equals("4")) {%>
                                    <td class="text-danger font-weight-bold" style="font-size: 17px">Eliminado</td>
                                    <%}%>
                                    <td style="text-align: center; gap: .4rem" class="d-flex align-content-center justify-content-center align-items-center">
                                        <form action="ContoladorAdopciones" method="POST">
                                            <input type="hidden" name="id_solicitud" value="<%=adopx.getId_solicitud()%>">
                                            <button class="btn btn-danger" type="submit" name="accion" value="cancelarSolicitudAdmin">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="18" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
                                                <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
                                                </svg>
                                            </button>                              
                                        </form>
                                        <form action="ContoladorAdopciones" method="POST">
                                            <input type="hidden" name="id_solicitud" value="<%=adopx.getId_solicitud()%>">
                                            <input type="hidden" name="id_usuario_bd" value="<%=adopx.getId_usuario_bd()%>">
                                            <input type="hidden" name="id_mascota_bd" value="<%=adopx.getId_mascota()%>">
                                            <button class="btn btn-dark" type="submit" name="accion" value="verSolicitudAdopcion">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-eye" viewBox="0 0 16 16">
                                                <path d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.133 13.133 0 0 1 1.66-2.043C4.12 4.668 5.88 3.5 8 3.5c2.12 0 3.879 1.168 5.168 2.457A13.133 13.133 0 0 1 14.828 8c-.058.087-.122.183-.195.288-.335.48-.83 1.12-1.465 1.755C11.879 11.332 10.119 12.5 8 12.5c-2.12 0-3.879-1.168-5.168-2.457A13.134 13.134 0 0 1 1.172 8z"/>
                                                <path d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
                                                </svg>
                                            </button>                              
                                        </form>
                                    </td>
                                </tr>
                                <%}
                                } else {%>
                            <h3 class="font-weight-bold text-center pt-5">No hay anuncios agregados en el momento...</h3>
                            <%}%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-5">
                            <div class="row">
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <div class="address">
                                        <ul class="loca">
                                            <li>

                                                <p style="font-size: 20px;font-weight: bold">
                                                    Somos una organización <br>
                                                    no lucrativa, dedicada a <br> 
                                                    promover el bienestar <br>
                                                    animal mediante la <br>
                                                    protección y el <br>
                                                    compromiso 
                                                    <i class="fa fa-heart-o" aria-hidden="true"></i></p>
                                            </li>
                                            <li>
                                                <a style="font-weight: 600">
                                                    <i class="fa fa-envelope-o" aria-hidden="true"></i>
                                                    Correo de contacto
                                                </a>
                                                <br>
                                                <a>
                                                    fundacionbello@hotmail.com
                                                </a>
                                                <br>
                                                <br>
                                                <a href="https://api.whatsapp.com/send?phone=573206400925"
                                                   style="font-weight: 600"><i class="fa fa-phone" aria-hidden="true"></i>
                                                    Télefono de contacto</a>
                                                <br>
                                                <a href="https://api.whatsapp.com/send?phone=573206400925"> 
                                                    +57 320 6400925</a>
                                            </li>

                                            <li>
                                                <a href="https://www.google.com/maps/place/Fundaci%C3%B3n+Bello+Animal/@6.332093,-75.5654649,17z/data=!3m1!4b1!4m5!3m4!1s0x8e442fa7e293574d:0x69a84a5502e8ba26!8m2!3d6.3320935!4d-75.5631885"
                                                   style="font-weight: 600"><i class="fa fa-map-marker" aria-hidden="true"></i>  Dirección</a>
                                                <br>
                                                <a href="https://www.google.com/maps/place/Fundaci%C3%B3n+Bello+Animal/@6.332093,-75.5654649,17z/data=!3m1!4b1!4m5!3m4!1s0x8e442fa7e293574d:0x69a84a5502e8ba26!8m2!3d6.3320935!4d-75.5631885"
                                                   >Cra. 54B # 47 - 45 <br> Bello - Antioquia</a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <ul class="social_link">

                                        <li>
                                            <a href="https://www.facebook.com/fundacionbelloanimal"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                        </li>
                                        <li>
                                            <a href="https://api.whatsapp.com/send?phone=573206400925"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-whatsapp" viewBox="0 0 16 16">
                                                <path d="M13.601 2.326A7.854 7.854 0 0 0 7.994 0C3.627 0 .068 3.558.064 7.926c0 1.399.366 2.76 1.057 3.965L0 16l4.204-1.102a7.933 7.933 0 0 0 3.79.965h.004c4.368 0 7.926-3.558 7.93-7.93A7.898 7.898 0 0 0 13.6 2.326zM7.994 14.521a6.573 6.573 0 0 1-3.356-.92l-.24-.144-2.494.654.666-2.433-.156-.251a6.56 6.56 0 0 1-1.007-3.505c0-3.626 2.957-6.584 6.591-6.584a6.56 6.56 0 0 1 4.66 1.931 6.557 6.557 0 0 1 1.928 4.66c-.004 3.639-2.961 6.592-6.592 6.592zm3.615-4.934c-.197-.099-1.17-.578-1.353-.646-.182-.065-.315-.099-.445.099-.133.197-.513.646-.627.775-.114.133-.232.148-.43.05-.197-.1-.836-.308-1.592-.985-.59-.525-.985-1.175-1.103-1.372-.114-.198-.011-.304.088-.403.087-.088.197-.232.296-.346.1-.114.133-.198.198-.33.065-.134.034-.248-.015-.347-.05-.099-.445-1.076-.612-1.47-.16-.389-.323-.335-.445-.34-.114-.007-.247-.007-.38-.007a.729.729 0 0 0-.529.247c-.182.198-.691.677-.691 1.654 0 .977.71 1.916.81 2.049.098.133 1.394 2.132 3.383 2.992.47.205.84.326 1.129.418.475.152.904.129 1.246.08.38-.058 1.171-.48 1.338-.943.164-.464.164-.86.114-.943-.049-.084-.182-.133-.38-.232z"/>
                                                </svg></a>
                                        </li>
                                        <li>
                                            <a href="https://www.instagram.com/fundacionbelloanimal/?hl=es-la"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br />
                </div>
            </div>
        </footer>

        <!-- end footer -->
        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>

    </body>
</html>



