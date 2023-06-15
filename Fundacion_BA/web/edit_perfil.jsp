<%-- 
    Document   : edit_perfil
    Created on : 17-ene-2022, 13:41:08
    Author     : Andrés Marín
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%

    try {
        if (session.getAttribute("datosUser") == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (Exception e) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        System.out.println("No se ha encontrado la sesión, error en intentar ingresar.");
    }
    String coloractivo = "";
    String rspta = "";
    if (request.getParameter("rspta") != null) {
        String colored = "alert alert-danger";
        String colorgreen = "alert alert-success";
        int r = Integer.parseInt(request.getParameter("rspta"));
        System.out.println(r + "cambiar_pass");
        if (r == 1) {
            rspta = "¡Felicidades, se ha cambiado la contraseña!";
            coloractivo = colorgreen;
        } else if (r == 2) {
            rspta = "La contraseña actual no concuerda.";
            coloractivo = colored;
        } else if (r == 3) {
            rspta = "La contraseña es igual a la actual.";
            coloractivo = colored;
        } else {
            System.out.println(rspta + "loginn");
            coloractivo = colored;
            rspta = "Error al actualizar, intentanuevamente.";
        }
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
        <title>Fundación Bello Animal | Perfil</title>
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
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->

            <div class="header">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-2 col-lg-2 col-md-2 col-sm-3 col logo_section">
                            <div class="full">
                                <div class="center-desk">
                                    <div class="logo">
                                        <a href="index.jsp"><img src="images/Logo2.png" width="50" height="50" alt="#" /></a>
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
                            <h2>Editar información</h2>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="p-3 m-3 text-center">
            <h3>¡<span class="font-weight-bold"><%=session.getAttribute("datosUser")%></span> aquí podrias realizar<br> y gestionar todo lo relacionado con tú perfil! </h3>  
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-12">                   
                    <form class="contact_bg" action="ControladorIniciosesion" method="POST">
                        <div class="col-md-12">     
                            <p class="<%=coloractivo%>"><%=rspta%></p>
                            <div class="col-md-12">
                                <input class="contactus" placeholder="Contraseña actual" autocomplete="off" maxlength="30" min="2" type="password" name="passactual" id="name_registro" required>
                            </div>
                            <div class="col-md-12">
                                <input class="contactus" placeholder="Nueva contraseña" autocomplete="off" maxlength="30" min="2" type="password" name="pass" id="name_registro" required>
                            </div>
                            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-3">
                                <input type="hidden" name="idDesencrip" value="<%=session.getAttribute("idDesencriptado")%>">
                                <input type="hidden" name="contraActual" value="<%=session.getAttribute("contraActual")%>">
                                <button type="submit" name="accion" value="ActualizarContra" class="send" >Actualizar</button>
                            </div>
                        </div>
                    </form>
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
                                                <a
                                                    href="https://www.google.com/maps/place/Fundaci%C3%B3n+Bello+Animal/@6.332093,-75.5654649,17z/data=!3m1!4b1!4m5!3m4!1s0x8e442fa7e293574d:0x69a84a5502e8ba26!8m2!3d6.3320935!4d-75.5631885"
                                                    ><i class="fa fa-map-marker" aria-hidden="true"></i>
                                                    Cra. 54b ##47-45, Bello, Antioquia</a
                                                >
                                            </li>
                                            <li>
                                                <a
                                                    href="https://api.whatsapp.com/send?phone=573206400925"
                                                    ><i class="fa fa-phone" aria-hidden="true"></i> +57
                                                    3206400925</a
                                                >
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12">
                                    <ul class="social_link">
                                        <li>
                                            <a href="https://www.facebook.com/fundacionbelloanimal"
                                               ><i class="fa fa-facebook" aria-hidden="true"></i
                                                ></a>
                                        </li>
                                        <li>
                                            <a href="#"
                                               ><i class="fa fa-twitter" aria-hidden="true"></i
                                                ></a>
                                        </li>
                                        <li>
                                            <a
                                                href="https://www.instagram.com/fundacionbelloanimal/?hl=es-la"
                                                ><i class="fa fa-instagram" aria-hidden="true"></i
                                                ></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br />
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

