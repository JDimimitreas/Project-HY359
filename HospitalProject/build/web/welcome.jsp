<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <!-- Meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="Content-Style-Type" content="text/css">
        <meta name="description" content="Assignment 1">
        <meta name="keywords" content="HTML,CSS">
        <meta name="author" content="csd3619">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Title and Favicon -->
        <title>Login</title>
        <!-- <link rel='shortcut icon' type='image/x-icon' href='favicon.ico'> -->

    <!-- Bootstrap CSS and Style CSS -->
        <!--link rel="stylesheet" href="css/bootstrap.min.css"-->
        <link rel="stylesheet" type="text/css" href="css/style.css">

    </head>
    <body onload="getDocList()">
        <!-- JQuery -->
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous">
        </script>
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            
            response.setHeader("Pragma", "no-cache");
            
            response.setHeader("Expires", "0");
            
            if(session.getAttribute("username")==null || session.getAttribute("password")==null) {
                response.sendRedirect("login.html");
            }  
        %>
        <div class="topnav">
            <a class="active" href="#home">Home</a>
            <a href="#news">News</a>
            <a href="#contact">Contact</a>
            <a href="#about">About</a>
        </div> 
        <br>
        <h1>Welcome ${username}</h1>
        <div id="main-container">
            <div id="doc_list">
                
            </div>
        </div>
        <form action="Logout">
            <input type="submit" value="logout">
        </form>
        <script src="js/adminPage.js"></script>
    </body>
</html>
