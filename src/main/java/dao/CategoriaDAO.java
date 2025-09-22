/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;

/**
 *
 * @author jmmacbook
 */
public class CategoriaDAO {
    private final String dbURL = "jdbc:mysql://localhost:3306/connect_shop";
    private final String dbUser = "root";
    private final String dbPassword = "";
    
    /**
     * Obtiene una lista de todas las categorías de la base de datos.
     * @return Una lista de objetos Categoria.
     */
    
    public List<Categoria> obtenerTodas() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT id_categoria, nombre FROM Categorias ORDER BY nombre";
        
        try (
             Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword);
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            
            System.out.println("Categorias obtenidas: " + categorias.size());

            
            while (rs.next()) {
                int id = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre");
                categorias.add(new Categoria(id, nombre));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categorias;
        
    }
    
}
