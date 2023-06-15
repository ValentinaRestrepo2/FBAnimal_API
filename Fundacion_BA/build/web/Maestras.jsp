

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
    String usuario = (String) session.getAttribute("datosUser");
    String id = (String) session.getAttribute("id_usuario_bd");
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
        <title>Fundación Bello Animal | Maestras</title>
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
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <body class="main-layout contineer_page">
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
        </header>
        <div class="backgro_mh">
            <div class="container">
                <div class="heding">
                    <center>
                        <div class="input-group2">
                            <span class="input-group-text" id="basic-addon1" style="background:#23BFD8;align-content: center;border-color: #23BFD8">
                                <svg xmlns="http://www.w3.org/2000/svg" width="55" height="55" fill="currentColor" class="bi bi-chat-square-heart" viewBox="0 0 16 16">
                                <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1h-2.5a2 2 0 0 0-1.6.8L8 14.333 6.1 11.8a2 2 0 0 0-1.6-.8H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12ZM2 0a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h2.5a1 1 0 0 1 .8.4l1.9 2.533a1 1 0 0 0 1.6 0l1.9-2.533a1 1 0 0 1 .8-.4H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2Z"/>
                                <path d="M8 3.993c1.664-1.711 5.825 1.283 0 5.132-5.825-3.85-1.664-6.843 0-5.132Z"/>
                                </svg>&nbsp;&nbsp;&nbsp;
                                <h2 style="font-weight: 700;font-size: 40px;align-content: center">¡Es un gusto que estés aquí <span class="font-weight-bold text-dark"><%=session.getAttribute("datosUser")%> <%=session.getAttribute("primerApellido")%></span>! </h2>
                            </span>
                        </div>
                    </center>
                </div>
            </div>
        </div>
        <div class="fondo5">
            <div class="text-center">
                <br>
                <div class="d-lg-flex d-md-flex justify-content-lg-center justify-content-md-center">
                    <form method="POST" action="ControladorUsuario" class="pr-2">
                        <button type="submit" value="Listar" name="accion" class="backgro-transparente p-3">
                            <img src="images/perfil.png" width="120" height="120" alt="Usuarios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Listado <br>de usuarios</h1>
                    </form>
                    <form method="POST" action="ControladorMascota" class="pr-2">
                        <button type="submit" value="Listar" name="accion" class="backgro-transparente p-3">
                            <img src="images/gatito.png" width="120" height="120" alt="Usuarios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Listado <br>de mascotas</h1>
                    </form>
                    <!--<a href="listar_mascotas.jsp"><img src="images/gatito.png" width="150" height="150" alt="Mascotas" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-->

                    <form method="POST" action="ControladorUsuario" class="pr-2"> 
                        <button type="submit" value="adopcionesList" name="accion" class="backgro-transparente p-3">
                            <img src="images/adopcion.png" width="120" height="120" alt="Adopciones" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Solicitudes <br>de adopción</h1>
                    </form>
                    <form method="POST" action="ControladorInformes" class="pr-2">
                        <button type="submit" value="listarInformesAdmin" name="accion" class="backgro-transparente p-3">
                            <img src="images/informe-medico.png" width="120" height="120" alt="Anuncios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Informes</h1>
                    </form>
                    <form method="POST" action="ControladorAnuncios" class="pr-2">
                        <button type="submit" value="anuncioList" name="anuncio" class="backgro-transparente p-3">
                            <img src="images/anuncio-emergente.png" width="120" height="120" alt="Anuncios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Anuncios</h1>
                    </form>
                    <form action="EstadisticasMascotas" class="pr-2" method="POST">
                        <button type="submit" value="ListarReportes" name="accion" class="backgro-transparente p-3">
                            <img src="images/reporte.png" width="120" height="120" alt="Anuncios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">Reportes</h1>
                    </form>
                    <form method="POST" action="ControladorContacto" class="pr-2">
                        <button type="submit" value="ListarContactos" name="accion" class="backgro-transparente p-3">
                            <img src="images/queja.png" width="120" height="120" alt="Anuncios" />
                        </button>
                        <h1 style="font-weight: 700;font-size: 20px">PQRS</h1>
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
