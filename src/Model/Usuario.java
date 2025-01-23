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
public class Usuario {

  

    // user_id , usuarioNombre, usuarioApellido, usuarioRut, contraseña
    
    
    int user_id;
    String usuarioNombre;
    String usuarioApellido;
    String usuarioRut;
    String contraseña;
    String usuario;
    int visible;
    
    public Usuario() {
    }

    public Usuario(int user_id, String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int visible) {
        this.user_id = user_id;
        this.usuarioNombre = usuarioNombre;
        this.usuarioApellido = usuarioApellido;
        this.usuarioRut = usuarioRut;
        this.contraseña = contraseña;
        this.usuario = usuario;
        this.visible = visible;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public String getUsuarioApellido() {
        return usuarioApellido;
    }

    public String getUsuarioRut() {
        return usuarioRut;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getVisible() {
        return visible;
    }

 
    
    
    

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public void setUsuarioApellido(String usuarioApellido) {
        this.usuarioApellido = usuarioApellido;
    }

    public void setUsuarioRut(String usuarioRut) {
        this.usuarioRut = usuarioRut;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

   
    
    
    
    
    
    
    
    
    
    
    
   public static Usuario buscarUsuarioenBase(String usuario) throws SQLException{
    
        Conexion conexion = new Conexion();  // Crear una nueva conexión
        Connection conn = null;

        // Abrimos la conexión
        if (!conexion.abrir()) {
            throw new SQLException("No se pudo abrir la conexión.");
        }

        conn = (Connection) conexion.enlace;  // Obtener la conexión abierta
        String sql = "SELECT * FROM usuario where usuario = ? ";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Asignar los parámetros a la consulta
            stmt.setString(1, usuario);
            ResultSet rs = stmt.executeQuery();
            
            //verificar si hay un resultado
            if(rs.next())
            {
                
                 // user_id , usuarioNombre, usuarioApellido, usuarioRut, contraseña
                //Medicamento medicamento = new Medicamento();
                Usuario usuario1 = new Usuario();
        
                usuario1.setUser_id(rs.getInt("user_id"));
                
                usuario1.setUsuarioNombre(rs.getString("usuarioNombre"));
                usuario1.setUsuarioApellido(rs.getString("usuarioApellido"));
                usuario1.setUsuarioRut(rs.getString("usuarioRut"));
                usuario1.setContraseña(rs.getString("contraseña"));
                
              
                
                return usuario1; //retorna el cliente encontrado
            }else{
                return null; //retorna null si el cliente no es encontrado
            }
            
        } finally {
            // Cerrar la conexión
            conexion.cerrar();
        }
    }
    
    
    
    
   
   
   
  public static ArrayList <Usuario> buscarTodosUsuario() throws SQLException, Exception{
  
  //crear la instacia de conexion
  
  
  ArrayList <Usuario> listaUsuario = new ArrayList();
  
   Conexion conexion = new Conexion();
   Connection conn = null;
   
   
 
    if (!conexion.abrir()) {
            throw new SQLException("No se pudo abrir la conexión.");
        }
   
   
   //abrir conexion
      try {
          
          conn = (Connection) conexion.enlace;
          String consultaSQL = "SELECT * FROM usuario";
          
          PreparedStatement stmt = conn.prepareStatement(consultaSQL);
          
          ResultSet resultado = stmt.executeQuery();
          
          while (resultado.next()) {              
              Usuario usuarioLista = new Usuario();
              
              usuarioLista.setUser_id(resultado.getInt("user_id"));
              usuarioLista.setUsuarioNombre(resultado.getString("usuarioNombre"));
              usuarioLista.setUsuarioApellido(resultado.getString("usuarioApellido"));
              usuarioLista.setUsuarioRut(resultado.getString("usuarioRut"));
              usuarioLista.setContraseña(resultado.getString("contraseña"));
              usuarioLista.setUsuario(resultado.getString("usuario"));
              usuarioLista.setVisible(resultado.getInt("usr_visible"));
              
              listaUsuario.add(usuarioLista);
              
           
          }
          
         
         return listaUsuario;
          
      } finally{
          conexion.cerrar();
      }


}

  
  
  
  
      public boolean verificacion (String usuario, String contraseña) throws SQLException {
          Conexion conexion = new Conexion();
          Connection conn = null;
          
          
          
          if (!conexion.abrir()) {
              throw new SQLException("NO SE PUEDE ABRIR LA CONEXION");
              
          }
           conn = conexion.enlace;
           String consultaSQL ="SELECT * FROM usuario WHERE usuario = ? AND contraseña = ?";
          
          try {
              
              PreparedStatement statement = conn.prepareStatement(consultaSQL);
              statement.setString(1, usuario);
              statement.setString(2, contraseña);
              
              ResultSet rs = statement.executeQuery();
              return  rs.next();
              
          } finally {
              conexion.cerrar();
          }
          
        
      }
      

      
      
      
      public static boolean InsertarUsuario(String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int visible) throws SQLException{
          
         
      
          Conexion conexion = new Conexion();
          Connection conn = null;
          
          
          if (!conexion.abrir()) {
               throw new SQLException("NO SE PUEDE ABRIR LA CONEXION");
          }
      
          
          conn = conexion.enlace;
          String consultaSQL = "INSERT INTO usuario (usuarioNombre, usuarioApellido, usuarioRut, contraseña, usuario, usr_visible ) " +
                 "VALUES (?, ?, ?, ?, ?, ?)";
          try {
              
              PreparedStatement statement = conn.prepareStatement(consultaSQL);
              statement.setString(1, usuarioNombre);
              statement.setString(2, usuarioApellido);
              statement.setString(3, usuarioRut);
              statement.setString(4, contraseña);
              statement.setString(5, usuario);
              statement.setInt(6, visible);
              
              int filas = statement.executeUpdate();
              return filas > 0;
              
          } finally{
          conexion.cerrar();
          }
                  
      
      }
      
      
      
      public static boolean modificarUsuario(String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int visible) throws SQLException{
          Conexion conexion = new Conexion();
          Connection conn = null;
      
          
          if (!conexion.abrir()) {
              throw new SQLException("NO SE PUDO ABRIR BASE DE DATOS");
              
          }
          
          conn = conexion.enlace;
          String consultaSQL = "UPDATE usuario set usuarioNombre = ?, usuarioApellido = ?, usuarioRut = ?, contraseña = ?, usuario = ?, usr_visible = ?  " +
                  "WHERE usuario = ? ";
          
          try {
              PreparedStatement statement = conn.prepareStatement(consultaSQL);
              statement.setString(1, usuarioNombre);
              statement.setString(2, usuarioApellido);
              statement.setString(3, usuarioRut);
              statement.setString(4, contraseña);
              statement.setString(5, usuario);
              statement.setInt(6, visible);
              statement.setString(7, usuario);
              
              int filas = statement.executeUpdate();
              return  filas >0;
              
              
                      
          } finally {
              conexion.cerrar();
          }
          
      }
      
      
      
      

      
      
      
      public static boolean eliminarUsuario (String usuario, int visible) throws SQLException{
      
          Conexion conexion = new Conexion();
          Connection conn = null;
          
          if (!conexion.abrir()) {
              
              throw new SQLException("NO SE PUDO ABRIR BASE DE DATOS");
              
          }
      
          
          conn = conexion.enlace;
          String consultaSQL = "UPDATE usuario SET usr_visible = ? " +
                  "WHERE usuario = ? ";
          
          
          try {
              
              PreparedStatement statement = conn.prepareStatement(consultaSQL);
              statement.setInt(1,visible);
              statement.setString(2, usuario);
              
              int filas = statement.executeUpdate();
              return  filas >0;

          } finally {
              conexion.cerrar();
          }
      }

 
      
}