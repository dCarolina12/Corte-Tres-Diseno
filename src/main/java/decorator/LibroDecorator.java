/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author Carolina
 */
public abstract class LibroDecorator implements LibroComponente {
    
    protected LibroComponente libro;

    public LibroDecorator(LibroComponente libro) {
        this.libro = libro;
    }
    
    @Override
    public String mostrarDetalles() {
        return libro.mostrarDetalles();
    }
}
