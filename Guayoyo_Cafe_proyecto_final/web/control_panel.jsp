

 <%@page import="modelo.Cafe"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Guayoyo Cafe - Panel de Control</title>
        <link rel="stylesheet" href="css/control-panel.css">

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    </head>
    <body>
        <header>
            <div class="header-logo">
                <img src="assets/logo_guayoyo_cafe.png" alt="guayoyo cafe logo" class="logo">
                <p>Panel de Control</p>
            </div>
            <div class="header-actions">
                <a href='<%= request.getContextPath() %>'>Página principal</a>
                <a href='logout' class="logout-btn">Cerrar sesión</a>
            </div>
        </header>
        <div id="mensajes">
            <%= (request.getSession().getAttribute("mensaje") != null ? request.getSession().getAttribute("mensaje") : "") %>
            <% request.getSession().setAttribute("mensaje", ""); %>
        </div>
        <div class="status-bar">
            <p>Conectado como <%= request.getSession().getAttribute("nombre") %> </p>
        </div>
        <main>
            <h1>cafés</h1>
            <button id="nuevo-cafe-btn" onclick="nuevoCafe();">Agregar nuevo café</button>
            <table>
                <thead>
                    <tr>
                        <td>ID del café</td>
                        <td>Nombre</td>
                        <td>Origen</td>
                        <td>Stock</td>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Cafe> cafes = (ArrayList) request.getAttribute("cafes");
                        for (int i = 0; i < cafes.size(); i++) { %>
                            <tr>
                                <td><a href="#editarCafe" onclick="editarCafe('<%= cafes.get(i).getID() %>');"><%= cafes.get(i).getID() %></a></td>
                                <td><%= cafes.get(i).getNombre() %></td>
                                <td><%= cafes.get(i).getOrigen() %></td>
                                <td><%= cafes.get(i).getStock() %></td>
                            </tr>
                    <% } %>    
                </tbody>
            </table>
        </main>
        <div class="modal" id="editar-cafe-modal">
            <div class="modal-content">
                <div class="modal-form">
                    <h2>Editando café <span id="cafe-editado">Cargando...</span></h2>
                    <small>El ID de este café no se puede cambiar.</small>
                    <button onclick="eliminarCafe();">Eliminar café</button>
                    <form action="editar-cafe" method="POST">
                        <input type="hidden" value="" id="cafe-editado-input" name="cafe-editado-input">
                        <div class="input-space">
                            <input type="text" name="nombre" placeholder="nombre" value='Lungo' id="nombre-editado" required disabled>
                        </div>
                        <div class="input-space">
                            <input type="text" name="origen" id="origen-editado" placeholder="origen" value='Brasil' required disabled>
                        </div>
                        <div class="input-space">
                            <input type="number" name="stock" id="stock-editado" placeholder="stock" value='25' required disabled>
                        </div>
                        <div class="input-space">
                            <input type="submit" value="Guardar Cambios">
                        </div>
                    </form>
                    <button id="cerrar-modal">Cancelar</button>
                </div>
            </div>
        </div>
        <div class="modal" id="agregar-cafe-modal">
            <div class="modal-content">
                <div class="modal-form">
                    <h2>Nuevo Café</h2>
                    <small>El ID de este café se generará automáticamente.</small>
                    <form action="agregar-cafe" method="POST">
                        <div class="input-space">
                            <input type="text" name="nombre" placeholder="nombre" autocomplete="off" required>
                        </div>
                        <div class="input-space">
                            <textarea name="descripcion" id="descripcion" placeholder="Descripcion del cafe (opcional)" autocomplete="off"></textarea>
                        </div>
                        <div class="input-space">
                            <input type="text" name="origen" id="origen" placeholder="origen">
                        </div>
                        <div class="input-space">
                            <input type="number" name="stock" id="stock" placeholder="stock" min="0" value="0" required>
                        </div>
                        <div class="input-space">
                            <label for="color">Color (para estilizar la página de este café)</label>
                            <input type="color" name="color" id="color" placeholder="color">
                            <small>opcional</small>
                        </div>
                        <div class="input-space">
                            <input type="text" name="img" id="imagen" placeholder="URL de imagen">
                            <small>opcional</small>
                        </div>
                        <div class="input-space">
                            <input type="submit" value="Guardar Nuevo Café">
                        </div>
                    </form>
                    <button id="cerrar-agregar-cafe-modal" class="cerrar-modal">Cancelar</button>
                </div>
            </div>
        </div>
    <script src="js/jquery.js"></script>
    <script src="js/control-panel.js"></script>
    </body>
</html>
