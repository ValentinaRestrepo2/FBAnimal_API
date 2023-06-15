<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page import="Modelo.BarriosDAO"%>
<%@page import="Modelo.Barrios"%>
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
        <title>Registro | Fundación Bello Animal</title>
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
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <!-- body -->
    <%
        Barrios barrio = new Barrios();
        BarriosDAO barrioDAO = new BarriosDAO();
        String respta = "";
        if (request.getParameter("respta") != null) {
            int r = Integer.parseInt(request.getParameter("respta"));
            if (r == 18151) {
                respta = "El número de documento o correo ya han sido registrados, intenta con otro.";
            } else if (r == 0) {
                respta = "Error al registrar, intenta nuevamente.";
            } else if (r == 155894) {
                respta = "No has seleccionado barrio y/o estado civil.";
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
                                            <li> <a href="login.jsp">Iniciar sesión</a> </li>
                                            <li class="active"> <a href="registro.jsp">Registrarme</a> </li>
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

            <!-- end header 

        </header>
            <!-- 
                    <div class="backgro_mh">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="heding">
                                        <h2 style="font-weight: 700">Registro</h2>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>-->

            <div class="about">
                <br>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <form class="contact_bg mt-1" id="form_register" method="POST" action="ControladorUsuario" style="height:1160px" onsubmit="formRegistroUsuario(event)">
                                <div class="espacio mt-5">
                                    <center><h3 style="margin-bottom: 20px;font-weight: 700;font-size: 24px;color: white">¡Nos alegra que quieras formar parte de nuestra comunidad!</h3></center>
                                </div>
                                <h4 class="text-center" style="font-weight: 500;font-size: 19px;color:white">Completa todos los campos</h4>
                                <p class="font-weight-bold text-center text-danger mb-3 mt-0"><%=respta%></p>
                                <div class="col-md-12">      
                                    <div class="col-md-12 p-0 pt-2">
                                        <input class="contactus" placeholder="Documento de identificación *" type="number" name="identificacion" autocomplete="off"/>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Nombre(s) *" type="text" name="Nombre" id="name_registro" autocomplete="off"/>
                                        </div>

                                        <div class="col-md-6 p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Primer apellido * "  type="text" name="pri_ape" autocomplete="off"/>
                                        </div>

                                        <div class="col-md-6  p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Segundo apellido " type="text" name="seg_ape" autocomplete="off" />
                                        </div>

                                        <div class="col-md-6 p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Celular *" type="number" name="celular" autocomplete="off"/>
                                        </div>
                                        
                                        <% List<Barrios> lista = barrioDAO.listar(); %>
                                        
                                        <div class="form-group col-md-12 p-0 pt-2">
                                            <label for="sel1" style="color: white;font-weight: 700;font-size: 17px">Seleccione su barrio* </label>
                                            <select class="form-control" style="margin-left: 50px" id="sel1" name="select_barrio" autocomplete="off"/>
                                            <option value="0" selected disabled >--Selecciona una opción-- </option>
                                            <%for (int i = 0; i < lista.size(); i++) {%>
                                            <option value="<%=lista.get(i).getId()%>"><%=lista.get(i).getNombre_barrio()%></option>
                                            <%}%>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-12 p-0 pt-2">
                                            <label for="sel1" style="color: white;font-weight: 700;font-size: 17px">Seleccione su estado civil* </label>
                                            <select class="form-control" style="margin-left: 50px" id="sel1" name="select_civil" autocomplete="off"/>
                                            <option value="0" selected disabled >--Selecciona una opción-- </option>
                                            <option value="1">Soltero/a</option>
                                            <option value="2">Casado/a</option>
                                            <option value="3">Divorciado/a</option>
                                            <option value="4">Unión libre</option>
                                            <option value="5">Otro...</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-md-12 p-0 pt-2">
                                        <label for="sel1" style="color: white;font-weight: 700;font-size: 17px">Fecha de nacimiento* </label>
                                        <input class="contactus" placeholder="Fecha de nacimiento *" type="date" autocomplete="off" name="fecha_nac"/>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Dirección de residencia *"  autocomplete="off" type="text" name="direccion"/>
                                        </div>
                                        <div class="col-md-6 p-0 pt-2">
                                            <input class="contactus" style="width: 70%" placeholder="Profesión u oficio *" autocomplete="off" type="text" name="puesto_trabajo"/>
                                        </div>
                                        <div class="col-md-12 pt-2">
                                            <input class="contactus" placeholder="Correo electrónico *" autocomplete="off" type="email" name="email"/>
                                        </div>
                                        <div class="col-md-12 pt-2">
                                            <input class="contactus" placeholder="Contraseña *"  type="password" autocomplete="off" name="password"/>
                                        </div>
                                    </div>
                                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 mt-3">
                                        <input type="hidden" name="accion" value="Registrar">
                                        <button name="accion" class="sendlogin" style="font-size:18px;font-weight: 700">Registrarme</button>
                                    </div>
                                </div>
                                <br>
                                <br>
                                <p style="font-weight: 500;color: white;font-size: 20px">¿Ya estás registrado?<a href="login.jsp" style="font-weight: 900;color: white;font-size: 20px">   Inicia sesión</a></p><br>
                                <br>
                            </form>
                        </div>
                    </div>
                </div>
                <br>
            </div>


            <!--  footer -->
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


            <!-- end Gallery --> 

            <!-- Javascript files-->
            <script src="js/jquery.min.js"></script>
            <script src="js/popper.min.js"></script>
            <script src="js/bootstrap.bundle.min.js"></script>
            <script src="js/jquery-3.0.0.min.js"></script>
            <script src="js/plugin.js"></script>
            <script src="js/formsValidation.js"></script>
            <script src="js/informes.js"></script>
            <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
            <!-- Chatbot -->
            <script src="https://account.snatchbot.me/script.js"></script><script>window.sntchChat.Init(231017);</script> 

            <!-- sidebar -->
            <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
            <script src="js/custom.js"></script>
            <script src="https:cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    </body>
</html>
