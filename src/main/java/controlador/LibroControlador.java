/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.LibroDAO;
import java.sql.SQLException;
import modelo.Libro;
import java.time.LocalDate;

public class LibroControlador {
    
    private LibroDAO libroDAO;

    public LibroControlador() {
        this.libroDAO = new LibroDAO();
    }

    // Método para guardar un libro
    public boolean saveLibro(String titulo, String autor, int añoPublicacion, String genero, LocalDate fechaLectura, int calificacion, String reseña) {
        // Usar el Builder para crear un objeto Libro
        Libro libro = Libro.builder()
                .titulo(titulo)
                .autor(autor)
                .añopublicacion(añoPublicacion)
                .genero(genero)
                .fechaLectura(fechaLectura)
                .calificacion(calificacion)
                .reseña(reseña)
                .build();

        return libroDAO.save(libro);
    }

    // Método para actualizar un libro
    public boolean updateLibro(int id, String titulo, String autor, int añoPublicacion, String genero, LocalDate fechaLectura, int calificacion, String reseña) {
        // Usar el Builder para crear un objeto Libro
        Libro libro = Libro.builder()
                .id(id)
                .titulo(titulo)
                .autor(autor)
                .añopublicacion(añoPublicacion)
                .genero(genero)
                .fechaLectura(fechaLectura)
                .calificacion(calificacion)
                .reseña(reseña)
                .build();

        return libroDAO.update(libro);
    }

    // Método para eliminar un libro
    public boolean deleteLibro(int id) {
        return libroDAO.delete(id);
    }

    // Método para encontrar un libro por su ID
    public Libro findLibroById(int id) throws SQLException {
        return libroDAO.findById(id);
    }
}