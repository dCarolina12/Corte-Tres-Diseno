/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author paula
 */
public class App {
    private static final String URL = "jdbc:mysql://localhost:3307/organizadorlibros";
    private static final String USER = "root";
    private static final String PASSWORD = "pumbolillo1145D";
    
    private static App instance; 
    private Connection connection;
    
    private App() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión establecida correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos:");
            e.printStackTrace();
            throw new SQLException("No se pudo establecer la conexión", e);
        }
    }
    
     public static App getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed()) {
            instance = new App();
        }
        return instance;
    }
     
     public Connection getConnection(){
         return connection;
     }
}

