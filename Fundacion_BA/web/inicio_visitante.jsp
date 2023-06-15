<%-- 
    Document   : inicio_visitante
    Created on : 24-ene-2022, 22:27:33
    Author     : Andrés Marín
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/app.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/0c42bd7069.js" crossorigin="anonymous"></script>

    </head>
    <body>
        <header class="header__visitante">
            <div class="contenedor">
                <nav class="header__nav">
                    <div>
                        <img src="../images/Logo2.png" width="60px" height="60px" alt="alt"/>
                    </div>
                    <ul class="header__menu">
                        <li class="header__li"><a href="#"><i class="fas fa-paw"></i></a></li>
                        <li class="header__li"><a href="#"><i class="fas fa-ellipsis-h"></i></a></li>
                        <li class="header__li"><a href="#"><i class="fas fa-user-cog"></i></a></li> 
                        <li class="header__li"><a href="#"><i class="fab fa-cc-visa"></i></a></li>  
                    </ul>

                    <div class="header__nombre">
                        <h3>Andres Marin</h3>
                    </div>
                </nav>
            </div>
        </header>
        <!-- Chatbot -->
        <script src="https://account.snatchbot.me/script.js"></script><script>window.sntchChat.Init(231017)</script> 

    </body>
</html>