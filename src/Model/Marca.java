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
public class Marca {
    
    // OBJETO CON 
    // id_marca, nombreMarca
    
    
    int id_marca;
    String nombreMarca;

    public Marca() {
    }

    
    public Marca(int id_marca, String nombreMarca) {
        this.id_marca = id_marca;
        this.nombreMarca = nombreMarca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public String getNombreMarca() {
        return nombreMarca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }
    
    
    
    
    
    public static boolean insertarMarca(String marca) throws SQLException{
     
       Conexion conexion = new Conexion();
       Connection conn = null;
       
        if (!conexion.abrir()) {
            throw new SQLException("No se puede establecer conexion con la base de datos");
            
        }
        
        try {
                    conn = conexion.enlace;
        String consultaSQL = "INSERT INTO marca (nombreMarca) VALUES (?) ";
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        statement.setString(1, marca);
        
          int filas = statement.executeUpdate();
              return filas > 0;
              
        } finally {
            
            conexion.cerrar();
        }
        
        
        }
    
    
    
    
    
    public static ArrayList <Marca> buscarTodasMarcas() throws SQLException{
    ArrayList <Marca> listaMarcas = new ArrayList<>();
    Conexion conexion = new Conexion();
    Connection conn = null;
    
    
        if (!conexion.abrir()) {
            throw new SQLException("Error de conexion con base de datos SQL");
            
        }
        
       
        
        try {
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM marca ";
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        ResultSet resultado = statement.executeQuery();
        
        
        
            while (resultado.next()) {  
                
                Marca marcaIndexada = new Marca();
                marcaIndexada.setNombreMarca(resultado.getString("nombreMarca"));
                marcaIndexada.setId_marca(resultado.getInt("id_marca"));
                
                listaMarcas.add(marcaIndexada);
                
                
            }
            
        } finally {
            
            conexion.cerrar();
        }
       return  listaMarcas;
        
        
        
    }
   
    
    
    
    
    public static Marca seleccionarMarcaEspecifica (String nombreMarca) throws SQLException{
    
      
        
        Conexion conexion = new Conexion();
        Connection conn = null ;
        
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE CONECTAR A BASE DE DATOS SQL");
            
        }
    
        
        conn = conexion.enlace;
        String consultaSQL = "SELECT * FROM marcas" + " WHERE nombreMarca = ? ";
        
        
        try {
        
        PreparedStatement statement = conn.prepareStatement(consultaSQL);
        statement.setString(1,nombreMarca);
        
        ResultSet resultado = statement.executeQuery();
        
            if (resultado.next()) {
                
                  Marca marcaBuscada = new Marca();
                  
                  marcaBuscada.setId_marca(resultado.getInt("id_marca"));
                  marcaBuscada.setNombreMarca(resultado.getString("nombreMarca"));
                  return marcaBuscada;} 
               
            } finally {
         
          conexion.cerrar();
   
        }
        return null;
    }
   
    
    
    public static boolean modificarMarca(String nombreActual, String nombreNuevo) throws SQLException{
    
        Conexion conexion = new Conexion();
        Connection conn = null;
        
        if (!conexion.abrir()) {
            throw new SQLException("NO ES POSIBLE ABRIR CONEXION SQL");
                    
        }
        
        conn = conexion.enlace;
        String consultaSQL = "UPDATE marca SET nombreMarca = ? " +
                "WHERE nombreMarca = ?";
        
        try {
            
            PreparedStatement statement = conn.prepareStatement(consultaSQL);
            statement.setString(1, nombreNuevo);
            statement.setString(2, nombreActual);
            int filas = statement.executeUpdate();
              return  filas >0;
              
        } finally {
            conexion.cerrar();
            
        }
    }
    
    
    
    
    
    
    public static boolean verificarDuplicidad (String nombreMarcaIngresado){
        
        try {
              ArrayList <Marca> tablaMarcas = Marca.buscarTodasMarcas();
              
              
              for (Marca objetoMarcaIndex : tablaMarcas) {
                String nombreMarcaVerificar = objetoMarcaIndex.getNombreMarca();
                
                  if (nombreMarcaIngresado.equals(nombreMarcaVerificar)) {
                      return true;
                  }
            }
              
              
              
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return false;
    
    }
}
