/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;
   
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/**
 *
 * @author jhoan
 */
public class conexion {
    Connection con;
    String url="jdbc:mysql://localhost:3306/asistencia2";
    String user="root";
    String pass="";
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
        }
        return con;
    }

    public PreparedStatement prepareStatement(String AGREGAR) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
