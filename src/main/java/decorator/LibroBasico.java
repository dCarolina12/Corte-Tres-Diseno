/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

import modelo.Libro;

/**
 *
 * @author Carolina
 */
public class LibroBasico implements LibroComponente{
    
    private Libro libro;

    public LibroBasico(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String mostrarDetalles() {
        return "Título: " + libro.getTitulo() + ", Autor: " + libro.getAutor();
    }
    
}
