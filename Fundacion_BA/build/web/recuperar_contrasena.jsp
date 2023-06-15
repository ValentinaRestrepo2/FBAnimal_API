<%-- 
    Document   : recuperar_contrasena
    Created on : 11-ene-2022, 13:41:18
    Author     : Andrés Marín
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="icon" type="image/png" sizes="16x16" href="images/apple-icon-114x114.png">

        <!-- basic -->
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="viewport" content="initial-scale=1, maximum-scale=1" />
        <!-- site metas -->
        <title>Fundación Bello Animal</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css" />
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
        <!-- Tweaks for older IEs-->
        <link
            rel="stylesheet"
            href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
            />
        <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css"
            media="screen"
            />
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script
        ><![endif]-->
    </head>
    <%
        String respuesta = "";
        String coloractivo = "";
        String disnone = "d-none";
        if (request.getParameter("respuesta") != null) {
            String colored = "font-weight-bold text-center text-danger p-3";
            String colorgreen = "font-weight-bold text-center text-success p-3";
            disnone = "d-block";
            int r = Integer.parseInt(request.getParameter("respuesta"));
            if (r == 984991156) {
                respuesta = "¡Felicidades, revisa tú correo electrónico!";
                coloractivo = colorgreen;
            } else {
                respuesta = "Datos incorrectos, el número de documento ingresado no está registrado.";
                coloractivo = colored;
            }
        }
    %>
    <!-- body -->
    <body class="main-layout contineer_page">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->

            <div class="header m-0 pt-3 pb-3">
                <div class="container">
                    <div class="row align-items-center">
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
                                            <li> <a href="index.jsp">Home</a> </li>
                                            <li> <a href="Galeria.jsp">Adoptar</a> </li>
                                            <li> <a href="donaciones.jsp">Donar </a> </li>
                                            <li> <a href="anuncios.jsp">Anuncios</a> </li>
                                            <li> <a href="contacto.jsp">Contacto</a> </li>
                                            <li> <a href="login.jsp">Iniciar sesión</a> </li>
                                            <li> <a href="registro.jsp">Registrarme</a> </li>
                                            <li class="d-none"><a></a></li>
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
                            <h2 style="font-weight: 700">Recuperar contraseña</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="about">
            <div class="col-md-10 col-xl-10 m-auto mt-0 mb-2 <%=disnone%>">
                <p class="<%=coloractivo%>"><%=respuesta%></p><br>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="pt-2"></div>
                        <form
                            class="contact_bg mt-3"
                            style="width: 100%;height:420px;margin-bottom: 20px"
                            id="form_login"
                            action="ControladorUsuario" method="POST"
                            >
                            <div class="espacio mt-5">
                                <center><h3 class="espacio mt-5" style="margin-top: 20px;font-weight: 700;font-size: 24px;color:white">¡Te haremos llegar a tu correo la contraseña registrada!</h3></center>
                            </div>
                            <h4 class="text-center" style="margin-top: 10px;font-weight: 500;font-size: 19px;color: white">Completa el campo con tu documento de identidad</h4>    
                            <div class="col-md-12">
                                <div class="col-md-12">
                                    <input
                                        class="contactus"
                                        placeholder="Documento de identidad *"
                                        type="text"
                                        id="Identificacion__login"
                                        name="Identificacion"
                                        autocomplete="off"
                                        required/>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-5">
                                    <button type="submit" name="accion"  style="font-size:18px;font-weight: 700" value="Recuperar" class="sendlogin">
                                        Enviar correo
                                    </button>
                                </div>
                            </div>
                            <br />
                            <p style="font-weight: 500;color: white;font-size: 20px">¿Aún no estás registrado?<a href="registro.jsp" style="font-weight: 900;color: white;font-size: 20px">  Regístrate</a></p><br>
                            <br />

                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- end Gallery -->


        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <script src="js/validacionesForms.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- Chatbot -->
        <script src="https://account.snatchbot.me/script.js"></script><script>window.sntchChat.Init(231017);</script> 

        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    </body>
</html>

