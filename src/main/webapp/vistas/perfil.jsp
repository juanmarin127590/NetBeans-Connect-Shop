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
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        .header {
            background: #0056b3;
            color: white;
            padding: 15px 30px;
            text-align: center;
        }
        .container {
            max-width: 700px;
            margin: 40px auto;
            background: white;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            font-size: 24px;
            margin-bottom: 15px;
            text-align: center;
        }
        p {
            font-size: 16px;
            color: #555;
            line-height: 1.6;
        }
        .actions {
            margin-top: 25px;
            display: flex;
            justify-content: center;
            gap: 20px;
        }
        a.button {
            display: inline-block;
            text-decoration: none;
            padding: 10px 18px;
            background: #0056b3;
            color: white;
            border-radius: 6px;
            transition: background 0.3s;
            font-size: 15px;
        }
        a.button:hover {
            background: #004494;
        }
    </style>
</head>
<body>
    <div class="header">
        <h2>Connect Shop</h2>
    </div>
    <div class="container">
        <h1>¡Bienvenido, <%= session.getAttribute("nombre_usuario") %>!</h1>
        <p>Has iniciado sesión correctamente.</p>
        <p><strong>ID de usuario:</strong> <%= session.getAttribute("id_usuario") %></p>
        
        <div class="actions">
            <a class="button" href="${pageContext.request.contextPath}/ProductoServlet">➕ Registrar Producto</a>
            <a class="button" href="${pageContext.request.contextPath}/LogoutServlet">🚪 Cerrar Sesión</a>
        </div>
    </div>
</body>
</html>
