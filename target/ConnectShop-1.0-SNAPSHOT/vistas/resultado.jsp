<%-- 
    Document   : resultado
    Created on : 17/09/2025, 12:11:30 a. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado del Registro - Connect Shop</title>
     <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 40px; text-align: center; }
        .container { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 500px; margin: auto; }
        a { color: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Estado del Registro</h1>
        <p>
            <%--
                request.getAttribute("Message") recupera el mensaje que guardamos en el Servlet.
            --%>
            <%= request.getAttribute("Message") %>
        </p>
        <br>
        <a href="${pageContext.request.contextPath}/vistas/login.jsp">Iniciar sesión</a>
    </div>
</body>
</html>
