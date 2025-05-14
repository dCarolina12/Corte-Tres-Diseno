/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package decorator;

/**
 *
 * @author Carolina
 */
public class FavoritoDecorator extends LibroDecorator {
    
    public FavoritoDecorator(LibroComponente libro) {
        super(libro);
    }
    
    @Override
    public String mostrarDetalles(){
        return super.mostrarDetalles() + "FAVORITO";
    }
    
}
