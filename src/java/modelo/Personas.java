/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jhoan
 */
public class Personas {
    int id;
    String cedula;
    String nombre;
    String apellido;
    String email;
    String user;
    String pass;
    String rol;
    String iduser;
    String idrol;
    String idexcusa;
    String Rol1;
    String idpersona;
    
    

    public Personas() {
    }

    public Personas(int id, String Rol1, String cedula, String nombre, String apellido, String email, String user,String pass, String rol,String iduser,String idrol,String idexcusa) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.user = user;
        this.pass = pass;
        this.rol = rol;
        this.iduser =iduser;
        this.idrol = idrol;
        this.idexcusa = idexcusa;
        this.Rol1 = Rol1;
    }
    
    public String getRol1() {
        return Rol1;
    }

    public void setRol1(String Rol1) {
        this.Rol1 = Rol1;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcedula() {
        return cedula;
    }

    public void setcedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public  String getpass(){
        return pass;
    }
    
    public void setpass(String pass){
        this.pass = pass;
    }
    
    public  String getrol(){
        return rol;
    }
    
    public void setRol(String rol){
        this.rol = rol;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getIdrol() {
        return idrol;
    }

    public void setIdrol(String idrol) {
        this.idrol = idrol;
    }

    public String getIdexcusa() {
        return idexcusa;
    }

    public void setIdexcusa(String idexcusa) {
        this.idexcusa = idexcusa;
    }

    public String getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(String idpersona) {
        this.idpersona = idpersona;
    }
    
    
    
    
}
