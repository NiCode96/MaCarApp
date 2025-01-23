/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controller;
import Model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author nicolas
 */
public class UsuarioController {
     
  
    public Usuario buscarUsuario(String usuario){
    
        try {
            return Usuario.buscarUsuarioenBase(usuario);
            
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public ArrayList <Usuario> ListarTodoUsuario(){
    
        ArrayList <Usuario> listaTodos = new ArrayList<>();
        
        try {
            listaTodos = Usuario.buscarTodosUsuario();
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return listaTodos;
        
    
    }
    
    
    
    
    public boolean InsertarNuevoUsuario(String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int visible){
    
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsuarioNombre(usuarioNombre);
        nuevoUsuario.setUsuarioApellido(usuarioApellido);
        nuevoUsuario.setUsuarioRut(usuarioRut);
        nuevoUsuario.setContraseña(contraseña);
        nuevoUsuario.setUsuario(usuario);
        nuevoUsuario.setVisible(visible);
        
        try {
           Usuario.InsertarUsuario(usuarioNombre, usuarioApellido, usuarioRut, contraseña, usuario, visible);
           
        } catch (SQLException e) {
           
        }
        return false;
        
    }
 
    
    
    public boolean editarUsuario(String usuarioNombre, String usuarioApellido, String usuarioRut, String contraseña, String usuario, int visible){
    
    Usuario editarUsuario = new Usuario();
    
    editarUsuario.setUsuarioNombre(usuarioNombre);
    editarUsuario.setUsuarioApellido(usuarioApellido);
    editarUsuario.setUsuarioRut(usuarioRut);
    editarUsuario.setContraseña(contraseña);
    editarUsuario.setUsuario(usuario);
    editarUsuario.setVisible(visible);
    
        try {
            Usuario.modificarUsuario(usuarioNombre, usuarioApellido, usuarioRut, contraseña, usuario, visible);
        } catch (SQLException e) {
            
        }
        
        return false;
     
    }
    
    
    

   
}