/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.App;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 *
 * @author Carolina
 */
public class UsuarioDAO {
    
    private Connection connection;
    

    
    public boolean save(Usuario usuario) {
        String query = "INSERT INTO usuario (id, nombreUsuario, contraseña, correo) VALUES (?,?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getContraseña());
            return statement.executeUpdate() > 0; // Si se insertó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar un usuario
    public boolean update(Usuario usuario) {
        String query = "UPDATE usuario SET nombre = ?, email = ?, contraseña = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, usuario.getContraseña());
            statement.setInt(4, usuario.getId());
            return statement.executeUpdate() > 0; // Si se actualizó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un usuario
    public boolean delete(int id) {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0; // Si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public Usuario findById(int id) {
    String query = "SELECT * FROM usuario WHERE id = ?";
    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return Usuario.builder()
                .id(resultSet.getInt("id"))
                .nombreUsuario(resultSet.getString("nombreUsuario"))
                .contraseña(resultSet.getString("contraseña"))
                .correo(resultSet.getString("correo"))
                .build();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
}