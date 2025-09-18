/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author jmmacbook
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String dbURL = "jdbc:mysql://localhost:3306/connect_shop";
        String dbUser = "root";
        String dbPassword = ""; 
        
        Connection conn = null;

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            
            // Consulta para buscar al usuario por su email
            String sql = "SELECT id_usuario, nombre, password FROM Usuario WHERE email = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                // Usuario encontrado, ahora verificamos la contraseña
                String storedPassword = rs.getString("password");
                
                // --- ¡IMPORTANTE! Ver explicación académica sobre seguridad ---
                if (password.equals(storedPassword)) {
                    // Contraseña correcta: Autenticación exitosa
                    
                    // 1. Creamos una nueva sesión o recuperamos la existente
                    HttpSession session = request.getSession();
                    
                    // 2. Guardamos información del usuario en la sesión
                    session.setAttribute("id_usuario", rs.getInt("id_usuario"));
                    session.setAttribute("nombre_usuario", rs.getString("nombre"));
                    
                    // 3. Redirigimos al usuario a una página protegida (su perfil)
                    response.sendRedirect("perfil.jsp");
                    
                } else {
                    // Contraseña incorrecta
                    request.setAttribute("errorMessage", "La contraseña es incorrecta.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // Usuario no encontrado
                request.setAttribute("errorMessage", "No existe un usuario con ese correo electrónico.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Error de conexión a la base de datos.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}