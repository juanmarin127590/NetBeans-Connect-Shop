<%-- 
    Document   : agregarProducto
    Created on : 21/09/2025, 9:44:27 p. m.
    Author     : jmmacbook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- Importamos la librería JSTL Core para usar bucles y condicionales --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Añadir Producto - Connect Shop</title>
    <style>
        /* Reutilizamos los mismos estilos para mantener la consistencia visual */
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 40px; }
        .container { background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); max-width: 600px; margin: auto; }
        h2 { text-align: center; color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; color: #555; }
        input[type="text"], input[type="number"], textarea, select {
            width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ddd; border-radius: 4px;
        }
        button {
            width: 100%; padding: 10px; background-color: #0056b3; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;
        }
        button:hover { background-color: #004494; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Añadir Nuevo Producto</h2>
        
        <p>Lista cargada: ${listaCategorias.size()} categorías</p>

        
        <form action="${pageContext.request.contextPath}/ProductoServlet" method="post">
            <div class="form-group">
                <label for="nombre">Nombre del Producto:</label>
                <input type="text" id="nombre" name="nombre" required>
            </div>
            <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion" rows="4"></textarea>
            </div>
            <div class="form-group">
                <label for="sku">SKU:</label>
                <input type="text" id="sku" name="sku" required>
            </div>
            <div class="form-group">
                <label for="categoria">Categoría:</label>
                
                <c:if test="${empty listaCategorias}">
                    <p style="color:red;">⚠️ La lista de categorías está vacía o no llegó desde el Servlet.</p>
                </c:if>

                <c:if test="${not empty listaCategorias}">
                    <p style="color:green;">Se recibieron ${listaCategorias.size()} categorías.</p>
                </c:if>
                
                <select id="categoria" name="id_categoria" required>
                    <option value="">-- Seleccione una categoría --</option>
                    <%-- JSTL itera sobre la lista de categorías que nos envió el Servlet --%>
                    <c:forEach var="cat" items="${listaCategorias}">
                        <option value="${cat.id}">${cat.nombre}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="precio">Precio:</label>
                <input type="number" id="precio" name="precio" step="0.01" required>
            </div>
            <div class="form-group">
                <label for="stock">Stock:</label>
                <input type="number" id="stock" name="stock" required>
            </div>
            <button type="submit">Guardar Producto</button>
        </form>
    </div>
</body>
</html>
