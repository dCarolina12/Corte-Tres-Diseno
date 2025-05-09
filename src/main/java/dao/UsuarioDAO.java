/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Conexion.App;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public UsuarioDAO() {
        try {
            this.connection = App.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

   
    public boolean save(Usuario usuario) {
        String query = "INSERT INTO usuario (nombreUsuario, contraseña, correo) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
          
            String contraseñaEncriptada = encriptarContraseña(usuario.getContraseña());

            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, contraseñaEncriptada); 
            statement.setString(3, usuario.getCorreo());
            return statement.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean update(Usuario usuario) {
        String query = "UPDATE usuario SET nombreUsuario = ?, correo = ?, contraseña = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
           
            String contraseñaEncriptada = encriptarContraseña(usuario.getContraseña());

            statement.setString(1, usuario.getNombreUsuario());
            statement.setString(2, usuario.getCorreo());
            statement.setString(3, contraseñaEncriptada); 
            statement.setInt(4, usuario.getId());
            return statement.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public boolean delete(int id) {
        String query = "DELETE FROM usuario WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0; 
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
                        .contraseña(resultSet.getString("contraseña")) // Contraseña encriptada
                        .correo(resultSet.getString("correo"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

  
    public String encriptarContraseña(String contraseña) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(contraseña.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }
    public Usuario findByCorreoYContraseña(String correo, String contraseña) {
    String contraseñaEncriptada = encriptarContraseña(contraseña);
    String query = "SELECT * FROM usuario WHERE correo = ? AND contraseña = ?";

    try (PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setString(1, correo);
        statement.setString(2, contraseñaEncriptada);
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