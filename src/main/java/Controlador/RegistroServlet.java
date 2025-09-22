/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// La anotación @WebServlet mapea la URL /RegistroServlet a esta clase.
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})

public class RegistroServlet extends HttpServlet {

    // Usamos el método doPost porque el formulario HTML usa method="post".
    // POST es el método correcto para enviar datos que crearán o modificarán un recurso.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperar los parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");

        // 2. Lógica para conectar e insertar en la Base de Datos
        String dbURL = "jdbc:mysql://localhost:3306/connect_shop";
        String dbUser = "root"; // Cambiar por tu usuario
        String dbPassword = ""; // Cambiar por tu contraseña
        
        Connection conn = null;
        String message = null; // Mensaje para el usuario

        try {
            // Cargar el driver de MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            // Establecer la conexión
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            // Crear la sentencia SQL parametrizada para evitar inyección SQL
            String sql = "INSERT INTO Usuario (nombre, apellidos, email, password, telefono) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, email);
            statement.setString(4, password); // Esto debería ser un hash de la contraseña
            statement.setString(5, telefono);

            // Ejecutar la inserción
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                message = "¡Registro exitoso! Ahora puedes iniciar sesión.";
            }
        } catch (SQLException ex) {
            // Manejar errores, por ejemplo, si el email ya existe (violación de UQ_email)
            message = "Error en el registro: " + ex.getMessage();
            //ex.printStackTrace();
        } finally {
            // Cerrar la conexión para liberar recursos
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                  // ex.printStackTrace();
                }
            }
        }
        
        // 3. Enviar una respuesta al usuario
        // Guardamos el mensaje en el objeto request para que el JSP pueda acceder a él
        request.setAttribute("Message", message);
        
        // Redirigir la petición al JSP que mostrará el resultado
        getServletContext().getRequestDispatcher("/vistas/resultado.jsp").forward(request, response);
    }
}