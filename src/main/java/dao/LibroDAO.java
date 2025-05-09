package dao;

import Conexion.App;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Libro;
import java.time.LocalDate;

/**
 *
 * @author Carolina
 */
public class LibroDAO {
    private Connection connection;
    
    public LibroDAO() {
        try {
            this.connection = App.getInstance().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Método para guardar un libro
    public boolean save(Libro libro) {
        String query = "INSERT INTO libro (id, titulo, autor, año_publicacion, genero, fecha_lectura, calificacion, resena) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, libro.getId());
            statement.setString(2, libro.getTitulo());
            statement.setString(3, libro.getAutor());
            statement.setInt(4, libro.getAñopublicacion());
            statement.setString(5, libro.getGenero());
            statement.setDate(6, java.sql.Date.valueOf(libro.getFechaLectura()));
            statement.setInt(7, libro.getCalificacion());
            statement.setString(8, libro.getReseña());
            return statement.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para actualizar un libro
    public boolean update(Libro libro) {
        String query = "UPDATE libro SET titulo = ?, autor = ?, año_publicacion = ?, genero = ?, fecha_lectura = ?, calificacion = ?, resena = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, libro.getTitulo());
            statement.setString(2, libro.getAutor());
            statement.setInt(3, libro.getAñopublicacion());
            statement.setString(4, libro.getGenero());
            statement.setDate(5, java.sql.Date.valueOf(libro.getFechaLectura()));
            statement.setInt(6, libro.getCalificacion());
            statement.setString(7, libro.getReseña());
            statement.setInt(8, libro.getId());
            return statement.executeUpdate() > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un libro
    public boolean delete(int id) {
        String query = "DELETE FROM libro WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0; // Si se eliminó correctamente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para encontrar un libro por su ID
    public Libro findById(int id) throws SQLException {
        String query = "SELECT * FROM libro WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Libro.builder()
                        .id(resultSet.getInt("id"))
                        .titulo(resultSet.getString("titulo"))
                        .autor(resultSet.getString("autor"))
                        .añopublicacion(resultSet.getInt("año_publicacion"))
                        .genero(resultSet.getString("genero"))
                        .fechaLectura(resultSet.getDate("fecha_lectura").toLocalDate())
                        .calificacion(resultSet.getInt("calificacion"))
                        .reseña(resultSet.getString("resena"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al consultar el libro.", e);
        }
        return null; 
    }

    // Método para encontrar todos los libros
    public List<Libro> findAll() throws SQLException {
        List<Libro> libros = new ArrayList<>();
        String query = "SELECT * FROM libro";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                libros.add(Libro.builder()
                        .id(resultSet.getInt("id"))
                        .titulo(resultSet.getString("titulo"))
                        .autor(resultSet.getString("autor"))
                        .añopublicacion(resultSet.getInt("año_publicacion"))
                        .genero(resultSet.getString("genero"))
                        .fechaLectura(resultSet.getDate("fecha_lectura").toLocalDate())
                        .calificacion(resultSet.getInt("calificacion"))
                        .reseña(resultSet.getString("reseña"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al consultar todos los libros.", e);
        }
        return libros;
    }
    
    public boolean actualizarReseñaYCalificacion(int id, int calificacion, String reseña) {
        String sql = "UPDATE libro SET calificacion = ?, reseña = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, calificacion);
            stmt.setString(2, reseña);
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}