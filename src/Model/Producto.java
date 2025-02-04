/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Conexion.Conexion;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author nicolas
 */
public class Producto {
    
    // OBJETO CON 8 ATRIBUTOS  EN MYSQL LAS TABLAS SON:
    // id_producto, nombreProducto, cantidad, valorCompra, marca, modeloCompatible
    
  int id_producto;
  String nombreProducto;
  String tipoProducto;
  String marcaRepuesto;
  String marcaVehiculo;
  String modelosCompatibles;
  int cantidadRecepcionada;
  int id_marca;
  int id_marcaRepuesto;
  int id_tipo;
  int producto_estado;

    public Producto(int id_producto, String nombreProducto, String tipoProducto, String marcaRepuesto, String marcaVehiculo, String modelosCompatibles, int cantidadRecepcionada, int id_marca, int id_marcaRepuesto, int id_tipo,int producto_estado) {
        this.id_producto = id_producto;
        this.nombreProducto = nombreProducto;
        this.tipoProducto = tipoProducto;
        this.marcaRepuesto = marcaRepuesto;
        this.marcaVehiculo = marcaVehiculo;
        this.modelosCompatibles = modelosCompatibles;
        this.cantidadRecepcionada = cantidadRecepcionada;
        this.id_marca = id_marca;
        this.id_marcaRepuesto = id_marcaRepuesto;
        this.id_tipo = id_tipo;
        this.producto_estado = producto_estado;
    }

    public Producto() {
    }

    public int getId_tipo() {
        return id_tipo;
    }

 
    public String getTipoProducto() {
        return tipoProducto;
    }


    public int getId_producto() {
        return id_producto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getMarcaRepuesto() {
        return marcaRepuesto;
    }

    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    public String getModelosCompatibles() {
        return modelosCompatibles;
    }

    public int getCantidadRecepcionada() {
        return cantidadRecepcionada;
    }

    public int getId_marca() {
        return id_marca;
    }

    public int getId_marcaRepuesto() {
        return id_marcaRepuesto;
    }

    public int getProducto_estado() {
        return producto_estado;
    }
    
    

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setMarcaRepuesto(String marcaRepuesto) {
        this.marcaRepuesto = marcaRepuesto;
    }

    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    public void setModelosCompatibles(String modelosCompatibles) {
        this.modelosCompatibles = modelosCompatibles;
    }

    public void setCantidadRecepcionada(int cantidadRecepcionada) {
        this.cantidadRecepcionada = cantidadRecepcionada;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setId_marcaRepuesto(int id_marcaRepuesto) {
        this.id_marcaRepuesto = id_marcaRepuesto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setProducto_estado(int producto_estado) {
        this.producto_estado = producto_estado;
    }
  
    
    
  
  
    
    
  public static ArrayList <Producto> buscarTodasMarcas() throws SQLException{
      
      Conexion conexion = new Conexion();
      Connection conn = null;
      
      
      if (!conexion.abrir()) {
          throw  new SQLException("No fue posible abrir la conexion SQL");
      }
      
      try {
                ArrayList <Producto> tablaProductos = new ArrayList<>();

          conn = conexion.enlace;
          String consultaSQL = "SELECT * FROM Producto ";
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          ResultSet resultado = statement.executeQuery();

          while (resultado.next()) {
              Producto producto = new Producto();
              producto.setId_producto(resultado.getInt("Id_producto"));
              producto.setNombreProducto(resultado.getString("nombreProducto"));
              producto.setTipoProducto(resultado.getString("tipoProducto"));
              producto.setMarcaRepuesto(resultado.getString("marcaRepuesto"));
              producto.setMarcaVehiculo(resultado.getString("marcaVehiculo"));
              producto.setModelosCompatibles(resultado.getString("modelosCompatibles"));
              producto.setCantidadRecepcionada(resultado.getInt("cantidadRecepcionada"));
              producto.setId_marca(resultado.getInt("id_marca"));
              producto.setId_marcaRepuesto(resultado.getInt("id_marcaRepuesto"));
              producto.setId_tipo(resultado.getInt("id_tipo"));
              producto.setProducto_estado(resultado.getInt("producto_estado"));
              
              tablaProductos.add(producto);
              
              
          }
          
          return tablaProductos;
          
      } finally {
          conexion.cerrar();
      }
      
      
      
  }
  
  
  
  
  
  
  public static boolean ingresoProducto(
          
  String nombreProducto,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  int cantidadRecepcionada,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo) throws SQLException{
      
      
  Conexion conexion = new Conexion();
  Connection conn = null;
  
      if (!conexion.abrir()) {
          throw new SQLException("No se pudo abrir la conexion SQL");
      }
      
      
      try { 
          conn = conexion.enlace;
          String consultaSQL = "INSERT INTO Producto (nombreProducto, tipoProducto, marcaRepuesto, marcaVehiculo, modelosCompatibles, cantidadRecepcionada, id_marca, id_marcaRepuesto, id_tipo) " +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          statement.setString(1, nombreProducto);
          statement.setString(2, tipoProducto);
          statement.setString(3, marcaRepuesto);
          statement.setString(4, marcaVehiculo);
          statement.setString(5, modelosCompatibles);
          statement.setInt(6, cantidadRecepcionada);
          statement.setInt(7, id_marca);
          statement.setInt(8, id_marcaRepuesto);
          statement.setInt(9, id_tipo);
          
          
           int filas = statement.executeUpdate();
              return filas > 0;
          
      } finally {
          
          conexion.cerrar();
      }
  
  }
  
  
  
  
public static int VerificacionAsignacion_idMarca(String marcaVehiculo) {
    try {
        ArrayList<Marca> tablaMarca = Marca.buscarTodasMarcas();
        for (Marca marca : tablaMarca) {
            if (marcaVehiculo.equals(marca.getNombreMarca())) {
                return marca.getId_marca();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra la marca
}





public static int VerificacionAsignacion_idMarcaRepuestos(String marcaRepuesto) {
    try {
        ArrayList<MarcaRepuesto> tablaMarcaRepuesto = MarcaRepuesto.buscarTodasMarcas();
        for (MarcaRepuesto marcaRepuesto1 : tablaMarcaRepuesto) {
            
            if (marcaRepuesto.equals(marcaRepuesto1.getNombreMarca())) {
                return marcaRepuesto1.getId_marca();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra la marca de repuesto
}





public static int VerificacionAsignacion_idTipo(String tipoRepuesto) {
    try {
        
        ArrayList<TipoProducto> tablaTipoProductos = TipoProducto.listarTodos();
        
        for (TipoProducto tipoProducto : tablaTipoProductos) {
            
            if (tipoRepuesto.equals(tipoProducto.getTipoNombre())) {
                return tipoProducto.getId_tipo();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return 0; // Retorna 0 si no se encuentra el tipo de repuesto
}
  


public static boolean modificarProducto (        
  String nombreProducto,
  String tipoProducto,
  String marcaRepuesto,
  String marcaVehiculo,
  String modelosCompatibles,
  int cantidadRecepcionada,
  int id_marca,
  int id_marcaRepuesto,
  int id_tipo,
  int id_producto) throws SQLException{
    
    Conexion conexion = new Conexion();
      Connection conn = null;
      
      
      if (!conexion.abrir()) {
          throw  new SQLException("No fue posible abrir la conexion SQL");
      }
      
      try {
        
          conn = conexion.enlace;
          String consultaSQL = "UPDATE Producto SET nombreProducto = ?, tipoProducto = ?, marcaRepuesto = ?, marcaVehiculo = ?, modelosCompatibles = ?, cantidadRecepcionada = ?, id_marca = ?, id_marcaRepuesto = ?, id_tipo = ? " +
                               "WHERE id_producto = ?";
          
          
          
          PreparedStatement statement = conn.prepareStatement(consultaSQL);
          statement.setString(1, nombreProducto);
          statement.setString(2, tipoProducto);
          statement.setString(3, marcaRepuesto);
          statement.setString(4, marcaVehiculo);
          statement.setString(5, modelosCompatibles);
          statement.setInt(6, cantidadRecepcionada);
          statement.setInt(7, id_marca);
          statement.setInt(8, id_marcaRepuesto);
          statement.setInt(9, id_tipo);
          statement.setInt(10, id_producto);
          
          
           int filas = statement.executeUpdate();
              return  filas >0;
          
    } finally {
          
          conexion.cerrar();
    }
}





public static boolean modificarEstadoProducto(int nuevoEstado, int id_producto) throws SQLException {
    Conexion conexion = new Conexion();
    
    if (!conexion.abrir()) {
        throw new SQLException("No fue posible abrir la conexión SQL");
    }

    Connection conn = conexion.enlace;
    String consultaSQL = "UPDATE Producto SET producto_estado = ? WHERE id_producto = ?";

    try (PreparedStatement statement = conn.prepareStatement(consultaSQL)) {
        statement.setInt(1, nuevoEstado);
        statement.setInt(2, id_producto);
        
        int filas = statement.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        System.err.println("Error al modificar estado del producto: " + e.getMessage());
        return false;
    } finally {
        conexion.cerrar();
    }
}

}

