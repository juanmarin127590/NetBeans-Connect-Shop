<%-- 
    Document   : error
    Created on : 27/09/2025, 10:10:05 p. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error en la Operación - Connect Shop</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 40px; text-align: center; }
        .container { background: #fff; padding: 40px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 500px; margin: auto; }
        h1 { color: #dc3545; } /* Rojo para error */
        p { font-size: 18px; color: #333; }
        .actions a {
            display: inline-block;
            margin-top: 20px;
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
        <h1>¡Ha Ocurrido un Error!</h1>
        <p>No se pudo guardar el producto en la base de datos. Por favor, inténtalo de nuevo.</p>
        <div class="actions">
             <%-- Enlace para volver al formulario e intentarlo de nuevo --%>
            <a href="ProductoServlet">Volver a intentarlo</a>
        </div>
    </div>
</body>
</html>