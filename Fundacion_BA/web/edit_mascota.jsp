<%-- 
    Document   : listar_mascotas
    Created on : 11/01/2022, 8:16:28 p. m.
    Author     : ZENBOOK
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Mascota"%>
<%@page import="Modelo.MascotaDAO"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Listado mascotas | Fundación Bello Animal</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- bootstrap css -->
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">  
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <%
        MascotaDAO mdao = new MascotaDAO();
        Mascota mascota = new Mascota();
        String id = (String) request.getAttribute("id");
        mascota = mdao.listarId(id);
    %>
     <%
        String usuario = (String) session.getAttribute("datosUser");
        if(usuario == null){
            response.sendRedirect("index.jsp");
        }
        %>
    <body class="main-layout contineer_page">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
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
                                        <a href="index.jsp"><img src="images/Logo2.png" width="100" height="100" alt="#" /></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-10 col-lg-10 col-md-10 col-sm-9">

                            <div class="menu-area">
                                <div class="limit-box">
                                    <nav class="main-menu ">
                                        <ul class="menu-area-main">
                                            <li class="active"> <a href="Maestras.jsp">Maestras</a> </li>
                                            <li> <a href="ControladorIniciosesion?accion=key&6Y4T9rFlN=<%=session.getAttribute("idEncriptado")%>"><%=session.getAttribute("datosUser")%></a> </li>
                                            <li> <a href="ControladorIniciosesion?accion=logout" class="text-danger font-weight-bold">Cerrar Sesión</a> </li>
                                        </ul>
                                    </nav>
                                </div> 
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
                            <h2>Editar mascota, <%=mascota.getNombre()%></h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form class="contact_bg mt-1" action="ControladorMascota" method="POST" enctype="multipart/form-data">
                        <!--<p class="font-weight-bold text-center text-danger mb-3 mt-0"></p>-->
                        <div class="row">
                            <div class="col-md-12">
                                <label for="sel1">Nombre de la mascota </label>
                                <input class="contactus" maxlength="50" min="5" placeholder="Nombre de la mascota" type="text" name="name_mascota" value="<%=mascota.getNombre()%>" required>
                            </div>
                            <div class="col-md-12 mt-2">
                                <label for="sel1">Descripción de la mascota </label>
                                <textarea class="contactus h-75" name="desc_mascota"><%=mascota.getDescripcion()%></textarea>
                            </div>
                            <div class="col-md-6 mt-2">
                                <label for="sel1">Raza de la mascota </label>
                                <input class="contactus" maxlength="50" min="5" placeholder="Raza de la mascota" type="text" name="raza_mascota" value="<%=mascota.getNombre()%>" required>
                            </div>
                            <div class="col-md-6 mt-2">
                                <label for="sel1">Edad de la mascota </label>
                                <input class="contactus" placeholder="Edad de la mascota" type="number" maxlength="20" min="2" max="30" name="edad_mascota" value="<%=mascota.getEdad()%>" required >
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 mt-2">
                                <label for="sel1">¿Vacunado?</label>
                                <select class="form-control" name="vacu_mascota" required>
                                    <% if (mascota.getVacunado() == 1) {%>
                                    <option value="1" selected>Vacunado</option>
                                    <option value="2">NO vacunado</option>
                                    <option value="3">Pendiente</option>
                                    <%} else if (mascota.getVacunado() == 2) {%>
                                    <option value="1">Vacunado</option>
                                    <option value="2" selected>NO vacunado</option>
                                    <option value="3">Pendiente</option>
                                    <%} else if (mascota.getVacunado() == 3) {%>
                                    <option value="1">Vacunado</option>
                                    <option value="2">NO vacunado</option>
                                    <option value="3" selected>Pendiente</option>
                                    <%}%>
                                </select>
                            </div>    

                            <div class="col-md-6 mt-2">
                                <label for="sel1">¿Esteril?</label>
                                <select class="form-control" id="sel1" name="esteril_mascota" required>
                                    <% if (mascota.getEsterilizado() == 1) {%>
                                    <option value="1" selected>SÍ</option>
                                    <option value="2">NO</option>
                                    <%} else if (mascota.getEsterilizado() == 2) {%>
                                    <option value="1">SÍ</option>
                                    <option value="2" selected>NO</option> 
                                    <%}%>
                                </select>
                            </div>

                            <div class="col-md-6 mt-2">
                                <label for="sel1">¿Disponibilidad?</label>
                                <select class="form-control" id="sel1" name="dispo_mascota" required>
                                    <% if (mascota.getDisponibilidad() == 1) {%>
                                    <option value="1" selected>Disponible</option>
                                    <option value="2">NO disponible</option>
                                    <option value="3">Adoptado</option>
                                    <option value="4">Fallecido</option>
                                    <%} else if (mascota.getDisponibilidad() == 2) {%>
                                    <option value="1">Disponible</option>
                                    <option value="2" selected>NO disponible</option>
                                    <option value="3">Adoptado</option>
                                    <option value="4">Fallecido</option>
                                    <%} else if (mascota.getDisponibilidad() == 3) {%>
                                    <option value="1">Disponible</option>
                                    <option value="2">NO disponible</option>
                                    <option value="3" selected>Adoptado</option>
                                    <option value="4">Fallecido</option>
                                    <%} else if (mascota.getDisponibilidad() == 4) {%>
                                    <option value="1">Disponible</option>
                                    <option value="2">NO disponible</option>
                                    <option value="3">Adoptado</option>
                                    <option value="4" selected>Fallecido</option>
                                    <%}%>
                                </select>
                            </div>
                            <!--<div class="form-group col-md-6 mt-3">
                                <label for="exampleFormControlFile1">Foto del perfil</label>
                                <input type="file" class="form-control-file" name="foto_mascota" id="exampleFormControlFile1">
                            </div>-->
                            <div>
                                <br>
                                <hr>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-3">
                                    <input type="hidden" name="id" value="<%=mascota.getId()%>">
                                    <button type="submit" name="accion" value="actualizarMascota" class="send">Actualizar</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>


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


