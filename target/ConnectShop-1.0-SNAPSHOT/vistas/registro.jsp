<%-- 
    Document   : registro
    Created on : 17/09/2025, 12:11:05 a. m.
    Author     : jmmacbook
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro de Usuario - Connect Shop</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #0056b3, #00b894);
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
            align-items: center;
            justify-content: center;
        }
        .container {
            background: #fff;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            text-align: center;
            max-width: 500px;
            width: 100%;
        }
        
        h2 { text-align: center; color: #333; }
        .form-group { margin-bottom: 15px; }
        
        label { display: block; 
                margin-bottom: 5px; 
                color: #555;
                text-align: left;
        }
        input[type="text"], input[type="email"], input[type="password"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #0056b3;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover { background-color: #004494; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Crear Cuenta en Connect Shop</h2>
        <form action="${pageContext.request.contextPath}/RegistroServlet" method="post">
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="apellidos">Apellidos:</label>
                <input type="text" id="apellidos" name="apellidos" required>
            </div>
            <div class="form-group">
                <label for="email">Correo Electrónico:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="telefono">Teléfono (Opcional):</label>
                <input type="text" id="telefono" name="telefono">
            </div>
            <button type="submit">Registrarme</button>
        </form>
    </div>
</body>
</html>
