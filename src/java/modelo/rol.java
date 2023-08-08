/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class rol {
    
    
    
    String Idrol,privilegio;

    public rol() {
       
    }
    public rol(String Idrol, String privilegio) {
        this.Idrol = Idrol;
        this.privilegio = privilegio;
    }
    

    public String getIdrol() {
        return Idrol;
    }

    public void setId(String Idrol) {
        this.Idrol = Idrol;
    }

    public String getprivilegio() {
        return privilegio;
    }

    public void setNombre(String privilegio) {
        this.privilegio = privilegio;
    } 
}
