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
    <body
        <%
          if(session.getAttribute("username")==null) {
              response.sendRedirect("login.html");
          }  
        %>
        Welcome ${username}
        <h1>Welcome ${username}</h1>
    </body>
</html>
