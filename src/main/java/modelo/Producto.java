/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.math.BigDecimal;

/**
 *
 * @author jmmacbook
 */
public class Producto {
    
    // Atributos  de la tabla 'Productos'
    private long id;
    private int idCategoria;
    private String sku;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    private boolean activo; 
    
    
    public Producto(){
        
    }
    
    // Constructores para cuando creamos un nuevo producto
    public Producto(int idCategoria, String sku, String nombre, String descripcion, BigDecimal precio, int stock){
    this.idCategoria = idCategoria;
    this.sku = sku;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.stock = stock;
    this.activo = true; // Por defecto, un nuevo producto está activo
        
    }
    
     // --- Getters y Setters ---
    // Permiten el acceso controlado a los atributos privados

    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public long getIdCategoria(){
        return idCategoria;
    }
    
    public void setIdCategoria(int idCategoria){
        this.idCategoria = idCategoria;
    }
    
    public String getSku(){
        return sku;
    }
    
    public void setSku(String sku){
        this.sku = sku;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
