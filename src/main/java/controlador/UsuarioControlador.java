package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioControlador {

    private UsuarioDAO usuarioDAO;

    public UsuarioControlador() {
        this.usuarioDAO = new UsuarioDAO();
    }

  
    public boolean registrarUsuario(String nombreUsuario, String correo, String contraseña) {
        
        Usuario usuario = Usuario.builder()
                .nombreUsuario(nombreUsuario)
                .correo(correo)
                .contraseña(contraseña)  
                .build();

     
        return usuarioDAO.save(usuario);
    }
}