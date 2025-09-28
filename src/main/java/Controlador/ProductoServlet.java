/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import dao.CategoriaDAO;
import dao.ProductoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;

/**
 *
 * @author jmmacbook
 */
@WebServlet(name = "ProductoServlet", urlPatterns = {"/ProductoServlet"})
public class ProductoServlet extends HttpServlet {

    // Se ejecutará cuando naveguemos a la URL para mostrar el formulario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Leemos el parámetro 'accion' de la URL
        String accion = request.getParameter("accion");
        if (accion == null) {
            accion = "listar"; // Acción por defecto
        }
        
        switch (accion) {
            case "mostrarFormulario":
                mostrarFormulario(request, response);
                break;
            case "listar":
            default:
                listarProductos(request, response);
                break;
        } 
    }

    // Se ejecutará cuando el formulario haga SUBMIT
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Recuperamos los datos del formulario
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String sku = request.getParameter("sku");
        int idCategoria = Integer.parseInt(request.getParameter("id_categoria"));
        BigDecimal precio = new BigDecimal(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        // 2. Creamos el objeto Producto
        Producto nuevoProducto = new Producto(idCategoria, sku, nombre, descripcion, precio, stock);

        // 3. Usamos el DAO para guardar el producto
        ProductoDAO productoDAO = new ProductoDAO();
        boolean exito = productoDAO.crearProducto(nuevoProducto);

        // 4. Redirigimos a una página de éxito o de listado de productos
        if (exito) {
           // ¡Mejora! Redirigimos a la lista de productos para ver el nuevo item añadido.
            response.sendRedirect("exito.jsp"); 
        } else {
            // Manejar el caso de error
            response.sendRedirect("error.jsp");
        }
    }
    
    private void listarProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Obtenemos las categorías de la BD
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProducto = productoDAO.obtenerTodos();
        
         System.out.println("Servlet: Pasando al JSP " + listaProducto.size() + " Productos.");

        // 2. Guardamos la lista en el request para que el JSP pueda usarla
        request.setAttribute("listaProducto", listaProducto);

        // 3. Redirigimos (forward) al JSP para que muestre el formulario
        request.getRequestDispatcher("vistas/misProductos.jsp").forward(request, response);
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Obtenemos las categorías de la BD
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> listaCategorias = categoriaDAO.obtenerTodas();

        System.out.println("Servlet: Pasando al JSP " + listaCategorias.size() + " categorías.");

        // 2. Guardamos la lista en el request para que el JSP pueda usarla
        request.setAttribute("listaCategorias", listaCategorias);

        // 3. Redirigimos (forward) al JSP para que muestre el formulario
        request.getRequestDispatcher("vistas/agregarProducto.jsp").forward(request, response);

    }
    

}
