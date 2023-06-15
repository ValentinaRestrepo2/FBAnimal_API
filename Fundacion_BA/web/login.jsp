<%-- Document : Galeria Created on : 27/12/2021, 12:03:11 p. m. Author : ZENBOOK
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Iniciar Sesión | Fundación Bello Animal</title>
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
    <!-- body -->
    <%
        String rspta = "";
        String coloractivo = "";
        if (request.getParameter("rspta") != null) {
            int r = Integer.parseInt(request.getParameter("rspta"));
            System.out.println(r + "loginn");
            if (r == 1) {
                rspta = "Recuerda por favor llenar todos los campos.";
                coloractivo = "font-weight-bold text-center text-danger";
            } else if (r == 2) {
                rspta = "Recuerda por favor llenar todos los campos.";
                coloractivo = "font-weight-bold text-center text-danger";
            } else if (r == 25536) {
                rspta = "Felicidades te has registrado, ingresa por favor.";
                coloractivo = "font-weight-bold text-center text-success";
            } else if (r == 894847) {
                rspta = "Lastima que te vayas, pero hemos eliminado tú cuenta.";
                coloractivo = "font-weight-bold text-center text-success";
            } else if (r == 84774) {
                rspta = "Hemos actualizado tú perfil, pero debes volver iniciar sesión, gracias.";
                coloractivo = "font-weight-bold text-center text-success";
            } else {
                System.out.println(rspta + "loginn");
                rspta = "Datos incorrectos, por favor verifique nuevamente.";
                coloractivo = "font-weight-bold text-center text-danger";
            }
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
                                            <li class="active"> <a href="login.jsp">Iniciar sesión</a> </li>
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

        <div class="login fondo4">
            <div class="container">
                <div class="row display_boxflex">

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <h4 class="text-center" style="font-weight: 700;font-size: 30px ">¡Que bueno tenerte por aquí!</h4>
                        <div class="d-flex justify-content-center align-content-center">
                            <img src="images/21378450.PNG" width="1000px" height="1000px"/>
                        </div>
                    </div>

                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <p class="<%=coloractivo%>" id="error"><%=rspta%></p>
                        <form class="contact_bg mt-3" style="width: 100%; margin-left: 10px;height:430px" id="form_login" action="ControladorIniciosesion" method="POST" name="formlogin" onsubmit="formLogin(event)">
                            <center><h3 style="margin-top: 20px;font-weight: 700;font-size: 22px;color: white">Completa todos los campos</h3></center>

                            <div class="col-md-12">
                                <div class="col-md-12">
                                    <input class="contactus" style="width: 100%" placeholder="Documento de identificación *" type="number" id="Identificacion__login" name="Identificacion" autocomplete="off"/>
                                    <input class="contactus" style="width: 100%" placeholder="Contraseña *" type="password" name="password" id="password__login"/>
                                </div>
                                <br />
                                <p><a href="recuperar_contrasena.jsp" style="font-weight: 500;color: white;font-size: 18px">¿Olvidaste tu contraseña?   <span style="font-weight: 900;color: white">Recupérala</span></a></p>
                                <br />
                                <div class="col-md-12">
                                    <button type="submit" name="accion" value="Login" class="sendlogin" style="font-size:18px;font-weight: 700">
                                        Ingresar
                                    </button>
                                </div>
                            </div>

                            <br />
                            <p style="font-weight: 500;color: white;font-size: 18px">¿Aún no estás registrado?<a href="registro.jsp" style="font-weight: 900;color: white">   Regístrate</a></p><br>
                            <br />
                        </form>
                    </div>
                </div>

            </div>
        </div>

        <!-- finaliza login 
        <div class="espacio mt-5">
            <center><h3 class="espacio mt-5">Completa todos los campos</h3></center>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="text-center">¡Que bueno tenerte por aquí!</h4>
                    <div class="d-flex justify-content-center align-content-center">
                        <img src="images/21378450.jpg" width="250px mt-2"
                              />
                    </div>
                    <p class="<%=coloractivo%>" id="error"><%=rspta%></p>
                    <form
                        class="contact_bg mt-3"
                        id="form_login"
                        action="ControladorIniciosesion" method="POST"
                        name="formlogin"
                        onsubmit="return validar()"
                        >
                        <div class="col-md-12">
                            <div class="col-md-12">
                                <input
                                    class="contactus"
                                    placeholder="Documento de identificación"
                                    type="number"
                                    id="Identificacion__login"
                                    name="Identificacion"
                                    autocomplete="off"
                                    />
                            </div>
                            <div class="col-md-12">
                                <input
                                    class="contactus"
                                    placeholder="Contraseña"
                                    type="password"
                                    name="password"
                                    id="password__login"
                                    />
                            </div>
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-5">
                                <button type="submit" name="accion" value="Login" class="send">
                                    Ingresar
                                </button>
                            </div>
                        </div>
                        <hr />
                        <br />
                        <p><a href="registro.jsp">¿Aún no estas registrado?</a></p><br>
                        <p><a href="recuperar_contrasena.jsp">He olvidado mi contraseña</a></p>
                        <br />
                    </form>
                </div>
            </div>
        </div>
        -->
        <!-- end Gallery -->

        <!-- Javascript files-->
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.0.0.min.js"></script>
        <script src="js/plugin.js"></script>
        <script src="js/formsValidation.js"></script>
        <!-- Chatbot -->
        <script src="https://account.snatchbot.me/script.js"></script><script>window.sntchChat.Init(231017);</script> 
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    </body>
</html>
