/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private int añopublicacion;
    private String genero;
    private LocalDate fechaLectura;
    private int calificacion;
    private String reseña;

    private Libro(LibroBuilder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.autor = builder.autor;
        this.añopublicacion = builder.añopublicacion;
        this.genero = builder.genero;
        this.fechaLectura = builder.fechaLectura;
        this.calificacion = builder.calificacion;
        this.reseña = builder.reseña;
    }

    public static LibroBuilder builder() {
        return new LibroBuilder();
    }

    public static class LibroBuilder {
        private int id;
        private String titulo;
        private String autor;
        private int añopublicacion;
        private String genero;
        private LocalDate fechaLectura;
        private int calificacion;
        private String reseña;

        public LibroBuilder id(int id) {
            this.id = id;
            return this;
        }

        public LibroBuilder titulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public LibroBuilder autor(String autor) {
            this.autor = autor;
            return this;
        }

        public LibroBuilder añopublicacion(int año) {
            this.añopublicacion = año;
            return this;
        }

        public LibroBuilder genero(String genero) {
            this.genero = genero;
            return this;
        }

        public LibroBuilder fechaLectura(LocalDate fechaLectura) {
            this.fechaLectura = fechaLectura;
            return this;
        }

        public LibroBuilder calificacion(int calificacion) {
            this.calificacion = calificacion;
            return this;
        }

        public LibroBuilder reseña(String reseña) {
            this.reseña = reseña;
            return this;
        }

        public Libro build() {
            return new Libro(this);
        }
    }
    public int getId() { 
        return id; 
    }
    
    public String getTitulo() {
        return titulo; 
    }
    
    public String getAutor() { 
        return autor; 
    }
    
    public int getAñopublicacion() {
        return añopublicacion; 
    }
    
    public String getGenero() { 
        return genero; 
    }
    
    public LocalDate getFechaLectura() { 
        return fechaLectura; 
    }
    
    public int getCalificacion() { 
        return calificacion; 
    }
    
    public String getReseña() { 
        return reseña; 
    }
    
}