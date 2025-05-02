package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;

public class UsuarioControlador {
    
    private UsuarioDAO usuarioDAO;

    public UsuarioControlador() {
        this.usuarioDAO = new UsuarioDAO();
    }

    // Método para guardar un usuario
    public boolean saveUsuario(String nombreUsuario, String correo, String contraseña) {
        // Usar el Builder para crear un objeto Usuario
        Usuario usuario = Usuario.builder()
                .nombreUsuario(nombreUsuario)
                .correo(correo)
                .contraseña(contraseña)
                .build();

        return usuarioDAO.save(usuario);
    }

    // Método para actualizar un usuario
    public boolean updateUsuario(int id, String nombreUsuario, String correo, String contraseña) {
        // Usar el Builder para crear un objeto Usuario
        Usuario usuario = Usuario.builder()
                .id(id)
                .nombreUsuario(nombreUsuario)
                .correo(correo)
                .contraseña(contraseña)
                .build();
        return usuarioDAO.update(usuario);
    }

    // Método para eliminar un usuario
    public boolean deleteUsuario(int id) {
        return usuarioDAO.delete(id);
    }

    // Método para encontrar un usuario por su ID
    public Usuario findUsuarioById(int id) {
        return usuarioDAO.findById(id);
    }
}