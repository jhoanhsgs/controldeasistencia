/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class fichas {
    String Idficha,NumeroFicha;

    public fichas() {
       
    }
    public fichas(String Idficha, String NumeroFicha) {
        this.Idficha = Idficha;
        this.NumeroFicha = NumeroFicha;
    }
    

    public String getIdficha() {
        return Idficha;
    }

    public void setIdficha(String Idficha) {
        this.Idficha = Idficha;
    }

    public String getNumeroFicha() {
        return NumeroFicha;
    }

    public void setNumeroFicha(String NumeroFicha) {
        this.NumeroFicha = NumeroFicha;
    } 
}
