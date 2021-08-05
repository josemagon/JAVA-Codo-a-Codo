<%-- 
    Document   : Cafe
    Created on : Jul 20, 2021, 6:33:21 PM
    Author     : josema
--%>

<%@page import="modelo.Cafe"%>
<%
    Cafe cafe = (Cafe) request.getAttribute("cafe");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/cafe.css">
        <link rel="icon" href="assets/logo_guayoyo_cafe.png" type="image/png">
        <title>Guayoyo Cafe - <%=  cafe.getNombre() %></title>
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    </head>
    <body style="background-color: <%= cafe.getColor() %>">
        <header>
            <% if (!request.getSession().getAttribute("isLoggedIn").equals(false)){ %>
                <div class="empleado">
                    <span><%= "Conectado como " + request.getSession().getAttribute("nombre") %></span> | <a href="<%= request.getContextPath() %>/control-panel">Panel de control</a>
                </div>
            <% } %>
            
            <div class="banner-logo">
                <img src="assets/logo_guayoyo_cafe.png" alt="logo guayoyo cafe" class="logo">
                <p>Guayoyo Café</p>
                <p>Tu portal al mejor café</p>
            </div>
        </header>
        <img class="bg-img" src="<%= cafe.getImg() %>">
        <main>
            <div class="descripcion">
                <h1><%=  cafe.getNombre() %></h1>
                <p><%= cafe.getDescripcion() %></p>
                <h3><strong>Origen</strong> <%= cafe.getOrigen() %></h3>
            </div>
            <div class="imagen">
                <img src="<%= cafe.getImg() %>" alt="imagen <%= cafe.getNombre() %>">
            </div>
        </main>
    
        <footer>

        </footer>
    </body>
</html>
