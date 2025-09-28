<%-- 
    Document   : misProductos
    Created on : 21/09/2025, 9:44:51 p. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Mis Productos - Connect Shop</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 40px; }
        .container { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 900px; margin: auto; }
        h2 { color: #333; }
        .table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        .table th, .table td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        .table th { background-color: #007bff; color: white; }
        .table tr:nth-child(even) { background-color: #f2f2f2; }
        .add-button {
            display: inline-block; padding: 10px 15px; background-color: #28a745;
            color: white; text-decoration: none; border-radius: 5px; margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Gestión de Mis Productos</h2>
        <a href="${pageContext.request.contextPath}/ProductoServlet?accion=mostrarFormulario" class="add-button">Añadir Nuevo Producto</a>
        
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>SKU</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Stock</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="prod" items="${listaProducto}">
                    <tr>
                        <td>${prod.id}</td>
                        <td>${prod.sku}</td>
                        <td>${prod.nombre}</td>
                        <td>${prod.precio}</td>
                        <td>${prod.stock}</td>
                        <td>
                            <%-- Enlaces para futuras funcionalidades --%>
                            <a href="#">Editar</a> | 
                            <a href="#">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>