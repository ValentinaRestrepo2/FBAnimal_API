<%-- 
    Document   : perfil
    Created on : 13-ene-2022, 21:10:38
    Author     : Andrés Marín
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%


    try {
        if (session.getAttribute("datosUser") == null) {
            System.out.println("Id desencriptado en KEY: " + session.getAttribute("idDesencriptado"));
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    } catch (Exception e) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
        System.out.println("No se ha encontrado la sesión, error en intentar ingresar.");
    }
    System.out.println("Id desencriptado en KEY: " + session.getAttribute("idDesencriptado"));

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
        <title>Perfil | <%=session.getAttribute("datosUser")%> <%=session.getAttribute("primerApellido")%> </title>
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
                            <h2>Mi perfil</h2>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <div class="container p-5">
            <div class="row">
                <div class="col-md-6 p-0">
                    <img src="https://scontent.feoh3-1.fna.fbcdn.net/v/t39.30808-6/p843x403/271717380_1097608904393318_4594872102612628090_n.jpg?_nc_cat=1&_nc_rgb565=1&ccb=1-5&_nc_sid=8bfeb9&_nc_eui2=AeHNAsgmyv9xUUR2J1P2rJ0b9xAxP5EtzmT3EDE_kS3OZIlRIl_N_EFX8rL-l_iCqHVNWNTPZyEa6WI-eRwlnA7C&_nc_ohc=6CTNx-gUss4AX_hNUZ1&_nc_ht=scontent.feoh3-1.fna&oh=00_AT91Qr1L1-7IctvNMJ_SkOv8_roRKfZ8auRGF2JwpVEaXA&oe=61E8DBD1" class="rounded mx-auto d-block w-100 h-100" alt="Avatar"/></img>
                </div>
                <div class="col-md-6">
                    <h2 class="font-weight-bold text-center text-uppercase p-sm-3"><%=session.getAttribute("datosUser")%> <%=session.getAttribute("primerApellido")%> <%=session.getAttribute("segApellido")%></h2>

                    <div class="m-2">
                        <p><span class="font-weight-bold">Fecha de nacimiento: </span><%=session.getAttribute("fecha")%></p>
                        <p><span class="font-weight-bold">Correo electronico: </span><%=session.getAttribute("email")%></p>
                        <p><span class="font-weight-bold">Estado civil: </span><%=session.getAttribute("barrio")%></p>
                        <p><span class="font-weight-bold">Barrio de residencia: </span><%=session.getAttribute("estado_civil")%></p>
                        <p><span class="font-weight-bold">Dirección: </span><%=session.getAttribute("direccion")%></p>
                        <p><span class="font-weight-bold">Celular: </span><%=session.getAttribute("celular")%></p>
                        <p><span class="font-weight-bold">Puesto de trabajo: </span><%=session.getAttribute("puesto")%></p>
                    </div>

                    <button type="submit" class="btn btn-info m-2"><a class="text-white" href="edit_perfil.jsp" data-toggle="modal" data-target="#exampleModal">Editar información</a></button>
                    <button type="submit" class="btn btn-dark m-2"><a class="text-white" href="cambiar_contra.jsp">Cambiar Contraseña</a></button>   
                    <form method="POST" action="ControladorIniciosesion" onsubmit="return eliminarCount()">
                        <input type="hidden" name="idDesencrip" value="<%=session.getAttribute("idDesencriptado")%>">
                        <button type="submit" class="btn btn-danger m-2" name="accion" value="eliminarMyCuenta">Eliminar cuenta</button> 
                    </form>

                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title text-info font-weight-bold" id="exampleModalLabel">Editar información</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form onsubmit="validarPerfil()" action="ControladorIniciosesion" method="POST" name="form_perfil">
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Nombre: </label>
                                            <input type="tel" class="form-control" id="recipient-name" name="Nombre" value="<%=session.getAttribute("datosUser")%>"/>
                                        </div>

                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Primer apellido: </label>
                                            <input type="tel" class="form-control" id="recipient-name" name="pri_ape" value="<%=session.getAttribute("primerApellido")%>"/>
                                        </div>

                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Segundo apellido: </label>
                                            <input type="tel" class="form-control" id="recipient-name" name="seg_ape" value="<%=session.getAttribute("segApellido")%>"/>
                                        </div>

                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label font-weight-bold">Barrio: </label>
                                            <div class="col-md-12">
                                                <select id="sel1" name="select_barrio" required>
                                                    <% if (session.getAttribute("barrio").equals(1)) {%>
                                                    <option value="1" selected>Barbosa</option>
                                                    <option value="2" >Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(2)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2" selected>Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(3)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3" selected>Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(4)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4" selected>Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(5)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5" selected>San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(6)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6" selected>Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(7)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7" selected>San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(8)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8" selected>Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(9)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9" selected>Laureles</option>
                                                    <option value="10">Aranjuez</option>
                                                    <%} else if (session.getAttribute("barrio").equals(10)) {%>
                                                    <option value="1">Barbosa</option>
                                                    <option value="2">Bello</option>
                                                    <option value="3">Alfonso López</option>
                                                    <option value="4">Castilla</option>
                                                    <option value="5">San Pablo</option>
                                                    <option value="6">Manrique</option>
                                                    <option value="7">San Javier</option>
                                                    <option value="8">Poblado</option>
                                                    <option value="9">Laureles</option>
                                                    <option value="10" selected>Aranjuez</option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="form-group">
                                            <label for="recipient-name" class="col-form-label font-weight-bold">Estado civil: </label>
                                            <div class="col-md-12">
                                                <select name="select_civil" required>
                                                    <% if (session.getAttribute("estado_civil").equals(1)) {%>
                                                    <option value="1" selected>Soltero/a</option>
                                                    <option value="2">Casado/a</option>
                                                    <option value="3">Divorciado/a</option>
                                                    <option value="4">Unión libre</option>
                                                    <option value="5">Otra...</option>
                                                    <%} else if (session.getAttribute("estado_civil").equals(2)) {%>
                                                    <option value="1">Soltero/a</option>
                                                    <option value="2" selected>Casado/a</option>
                                                    <option value="3">Divorciado/a</option>
                                                    <option value="4">Unión libre</option>
                                                    <option value="5">Otra...</option>
                                                    <%} else if (session.getAttribute("estado_civil").equals(3)) {%>
                                                    <option value="1">Soltero/a</option>
                                                    <option value="2">Casado/a</option>
                                                    <option value="3" selected>Divorciado/a</option>
                                                    <option value="4">Unión libre</option>
                                                    <option value="5">Otra...</option>
                                                    <%} else if (session.getAttribute("estado_civil").equals(4)) {%>
                                                    <option value="1">Soltero/a</option>
                                                    <option value="2">Casado/a</option>
                                                    <option value="3">Divorciado/a</option>
                                                    <option value="4" selected>Unión libre</option>
                                                    <option value="5">Otra...</option>
                                                    <%} else if (session.getAttribute("estado_civil").equals(5)) {%>
                                                    <option value="1">Soltero/a</option>
                                                    <option value="2">Casado/a</option>
                                                    <option value="3">Divorciado/a</option>
                                                    <option value="4">Unión libre</option>
                                                    <option value="5" selected>Otra...</option>
                                                    <%}%>
                                                </select>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Dirección de residencia: </label>
                                            <input type="text" class="form-control" id="recipient-name" name="direccion" value="<%=session.getAttribute("direccion")%>">
                                        </div>

                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Celular: </label>
                                            <input type="tel" class="form-control" id="recipient-name" name="celular" value="<%=session.getAttribute("celular")%>">
                                        </div>

                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold">Correo eletronico: </label>
                                            <input type="email" class="form-control" id="recipient-name" name="email" value="<%=session.getAttribute("email")%>">
                                        </div>

                                        <div class="form-group">
                                            <label for="message-text" class="col-form-label font-weight-bold" >Puesto de trabajo: </label>
                                            <input type="text" class="form-control" id="recipient-name" name="puesto_trabajo" value="<%=session.getAttribute("puesto")%>">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                                            <input type="hidden" name="idDesencrip" value="<%=session.getAttribute("idDesencriptado")%>"/>
                                            <button type="submit" class="btn btn-info" name="accion" value="ActualizarPerfil">Aceptar</button>
                                        </div>
                                    </form>
                                </div>
                                <hr>

                            </div>
                        </div>
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
        <script src="js/validacionesForms.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <!-- Chatbot -->
        <script src="https://account.snatchbot.me/script.js"></script><script>window.sntchChat.Init(231017)</script> 

        <!-- sidebar -->
        <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="js/custom.js"></script>
        <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>

    </body>
</html>

