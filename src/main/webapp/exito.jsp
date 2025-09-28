<%-- 
    Document   : exito
    Created on : 27/09/2025, 10:04:18 p. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Operación Exitosa - Connect Shop</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 40px; text-align: center; }
        .container { background: #fff; padding: 40px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 500px; margin: auto; }
        h1 { color: #28a745; } /* Verde para éxito */
        p { font-size: 18px; color: #333; }
        .actions a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .actions a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>¡Éxito!</h1>
        <p>El producto ha sido guardado correctamente en la base de datos.</p>
        <div class="actions">
            <%-- Enlace para volver al formulario y añadir otro producto --%>
            <a href="${pageContext.request.contextPath}/ProductoServlet?accion=mostrarFormulario">Añadir otro producto</a>
            
            <%-- Enlace para la futura página que listará los productos --%>
            <a href="${pageContext.request.contextPath}/ProductoServlet?accion=listar">Ver mis productos</a>
        </div>
    </div>
</body>
</html>