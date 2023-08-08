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
public class AsignarAprendiz {
     int idAprendiz;
     int idFicha;
    String cedula;
    String nombre;
    String apellido;
    String rol;
    String total_inasistencia;
    Date Fecha;

    public AsignarAprendiz() {
    }

    public AsignarAprendiz(int id, String cedula, String nombre, String apellido, String rol, String total_inasistencia, Date Fecha) {
        this.idAprendiz = idAprendiz;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.total_inasistencia = total_inasistencia;
        this.Fecha = Fecha;
    }

    public int getidAprendiz() {
        return idAprendiz;
    }

    public void setidAprendiz(int idAprendiz) {
        this.idAprendiz = idAprendiz;
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

    public String getrol() {
        return rol;
    }

    public void setrol(String rol) {
        this.rol = rol;
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
