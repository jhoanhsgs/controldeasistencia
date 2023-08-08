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
public class Asistencia {
     int id;
    String cedula;
    String nombre;
    String apellido;
    String Asistencia;
    String total_inasistencia;
    String idPersona;
    Date Fecha;

    

    public Asistencia() {
    }

    public Asistencia(int id, String idPersona,String cedula, String nombre, String apellido, String Asistencia, String total_inasistencia, Date Fecha) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Asistencia = Asistencia;
        this.total_inasistencia = total_inasistencia;
        this.Fecha = Fecha;
        this.idPersona = idPersona;
    }
    
    
    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(String Asistencia) {
        this.Asistencia = Asistencia;
    }

    public String getTotal_inasistencia() {
        return total_inasistencia;
    }

    public void setTotal_inasistencia(String total_inasistencia) {
        this.total_inasistencia = total_inasistencia;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }
  
}
