/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Producto;

/**
 *
 * @author nicolas
 */
public class ProductoController {

    public ProductoController() {
    }
    
    
    public boolean insertarProducto (
  String nombreProducto,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  int cantidadRecepcionada,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo){
    
        try {
            Producto.ingresoProducto(nombreProducto, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo);
            return  true;
            
        } catch (Exception e) {
            return false;
        }
        
    }
    
    
    
    public boolean modificarProducto (  
  String nombreProducto,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  int cantidadRecepcionada,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo,
  int id_producto){
        
        
        try {
            
            Producto.modificarProducto(nombreProducto, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo, id_producto);
            
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
    
    
 public boolean modificarEstado(int nuevoeEstado, int id_producto) {
    try {
        return Producto.modificarEstadoProducto(nuevoeEstado, id_producto);
    } catch (Exception e) {
        System.err.println("Error en modificarEstado: " + e.getMessage());
        return false;
    }
}
}
