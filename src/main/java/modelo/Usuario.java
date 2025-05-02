/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contraseña;
    private String correo;

    private Usuario(UsuarioBuilder builder) {
        this.id = builder.id;
        this.nombreUsuario = builder.nombreUsuario;
        this.contraseña = builder.contraseña;
        this.correo = builder.correo;
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public static class UsuarioBuilder {
        private int id;
        private String nombreUsuario;
        private String contraseña;
        private String correo;

        public UsuarioBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder nombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
            return this;
        }

        public UsuarioBuilder contraseña(String contraseña) {
            this.contraseña = contraseña;
            return this;
        }

        public UsuarioBuilder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }
    
    public int getId() {
        return id; 
    }
    
    public String getNombreUsuario() { 
        return nombreUsuario; 
    }
    
    public String getContraseña() { 
        return contraseña; 
    }
    
    public String getCorreo() { 
        return correo; 
    }
    
}