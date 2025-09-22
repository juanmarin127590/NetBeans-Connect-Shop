<%-- 
    Document   : perfil
    Created on : 17/09/2025, 11:21:36 p. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Verificamos si existe una sesión y un atributo de usuario
    // Si no, redirigimos al login. Esta es la base de la protección de rutas.
    if (session.getAttribute("nombre_usuario") == null) {
        response.sendRedirect("vistas/login.jsp");
        return; // Detenemos la ejecución del resto del JSP
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mi Perfil - Connect Shop</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>¡Bienvenido a Connect Shop, <%= session.getAttribute("nombre_usuario") %>!</h1>
        <p>Has iniciado sesión correctamente.</p>
        <p>Tu ID de usuario es: <%= session.getAttribute("id_usuario") %></p>
        <br>
        <a href="${pageContext.request.contextPath}/LogoutServlet">Cerrar Sesión</a>
    </div>
</body>
</html>
