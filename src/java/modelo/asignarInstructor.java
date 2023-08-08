/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author JH
 */
public class asignarInstructor {
     int idInstructor;
     int idFicha;   
    String cedula;
    String nombre;
    String apellido;
    String rol;
    Date Fecha;  

     public asignarInstructor() {
    }
     
     
    public asignarInstructor(int idInstructor, int idFicha, String cedula, String nombre, String apellido, String rol, Date Fecha) {
        this.idInstructor = idInstructor;
        this.idFicha = idFicha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.Fecha = Fecha;
    }

   

    public int getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public int getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(int idFicha) {
        this.idFicha = idFicha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
    
    
}
