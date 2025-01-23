import Model.Usuario;
import java.sql.SQLException;



public class UsuarioController {

    
    
    
    
    public UsuarioController() {
    }
    
    
    
    
    
    
    
    
    public void buscarPorNombreUsuario (String userName) throws SQLException{
    Usuario.buscarUsuarioenBase(userName);
    }
}
