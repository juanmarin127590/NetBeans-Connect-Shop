/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dao;

import jakarta.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Producto;

/**
 *
 * @author jmmacbook
 */
@WebServlet(name = "ProductoDAO", urlPatterns = {"/ProductoDAO"})
public class ProductoDAO {
    
    private final String dbURL = "jdbc:mysql://localhost:3306/connect_shop";
    private final String dbUser = "root";
    private final String dbPassword = ""; 
    
    /**
     * Inserta un nuevo producto en la base de datos.
     * @param producto El objeto Producto con la información a guardar.
     * @return true si el producto se guardó exitosamente, false en caso contrario.
     */
    
    public boolean crearProducto(Producto producto){
        
        String sql = "INSERT INTO Productos (id_categoria, sku, nombre, descripcion, precio, stock, activo) VALUES (?, ?, ?, ?, ?, ?, ?,)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        boolean guardadoExitosamente = false;
        
        try{
            // 1. Establecer la conexión
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPassword );
            
            // 2. Preparar la sentencia
            statement = conn.prepareStatement(sql);
            statement.setInt(1, (int) producto.getIdCategoria());
            statement.setString(2, producto.getSku());
            statement.setString(3, producto.getNombre());
            statement.setString(4, producto.getDescripcion());
            statement.setBigDecimal(5, producto.getPrecio());
            statement.setInt(6, producto.getStock());
            statement.setBoolean(7, producto.isActivo());
            
            // 3. Ejecutar la inserción
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("¡Un nuevo producto fue insertado exitosamente!");
                guardadoExitosamente = true;
            }
            
        } catch (SQLException ex){
            System.out.println("Error al guardar el producto.");
            ex.printStackTrace();
        } finally {
            try{
                if (statement != null) statement.close();
                if (conn != null) conn.close();
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return guardadoExitosamente;
    }

}
