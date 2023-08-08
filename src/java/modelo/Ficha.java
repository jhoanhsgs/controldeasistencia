/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Ficha {
    int id;
    String Nficha;
    String nombre;
    String fechaI;
    String fechaF;
    String fechaC;
    String idprogformacion;
    
    
    public Ficha() {
    }

    public Ficha(int id, String Nficha, String nombre, String fechaI, String fechaF, String fechaC, String idprogformacion) {
        this.id = id;
        this.Nficha = Nficha;
        this.nombre = nombre;
        this.fechaI = fechaI;
        this.fechaF = fechaF;
        this.fechaC = fechaC;
        this.idprogformacion = idprogformacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNficha() {
        return Nficha;
    }

    public void setNficha(String Nficha) {
        this.Nficha = Nficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaI() {
        return fechaI;
    }

    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    public String getFechaF() {
        return fechaF;
    }

    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public String getIdprogformacion() {
        return idprogformacion;
    }

    public void setIdprogformacion(String idprogformacion) {
        this.idprogformacion = idprogformacion;
    }
   
    
}