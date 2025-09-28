/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;
import java.sql.ResultSet;

/**
 *
 * @author jmmacbook
 */

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
        
        String sql = "INSERT INTO Productos (id_categoria, sku, nombre, descripcion, precio, stock, activo) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
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
    
    /**
     * Obtiene una lista de todos los productos de la base de datos.
     *
     * @return Una lista de objetos Producto.
     */
    public List<Producto> obtenerTodos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Productos ORDER BY nombre";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword); 
                PreparedStatement statement = conn.prepareStatement(sql); 
                ResultSet rs = statement.executeQuery()) {

            // Iteramos sobre cada fila que devuelve la consulta
            while (rs.next()) {
                // Creamos un objeto Producto por cada fila
                Producto producto = new Producto();
                producto.setId(rs.getLong("id_producto"));
                producto.setIdCategoria(rs.getInt("id_categoria"));
                producto.setSku(rs.getString("sku"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecio(rs.getBigDecimal("precio"));
                producto.setStock(rs.getInt("stock"));
                producto.setActivo(rs.getBoolean("activo"));

                // Añadimos el objeto a nuestra lista
                productos.add(producto);
            }
        } catch (SQLException ex) {
        }

        System.out.println("DAO: Número de productos leídos: " + productos.size());
        return productos;
    }


}
