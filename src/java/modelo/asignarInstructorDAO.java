/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JH
 */
public class asignarInstructorDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    //operaciones CRUD
      public Personas validar(String user, String pass){
        Personas pm=new Personas();
        String sql="select * from tblusuario where Usuario=? and Contraseña=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
                pm.setId(rs.getInt("IDUsuario"));
                pm.setUser(rs.getString("Usuario"));
                pm.setpass(rs.getString("Contraseña"));
                pm.setNombre(rs.getString("IDExcusa "));
                
            }
        } catch (Exception e) {
        }return pm;
    }
    
    public List ListInstruc(String idFicha){
        String sql="SELECT * FROM `tbl_personas` WHERE PK_id_personas NOT IN (SELECT tbl_ficha_x_personas.FK_id_personas from tbl_ficha_x_personas where tbl_ficha_x_personas.FK_id_ficha="+idFicha+") and FK_id_rol=1";
        List<asignarInstructor>AsignarIns = new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                asignarInstructor AsIns = new asignarInstructor();
                AsIns.setIdInstructor(rs.getInt(1));
                AsIns.setCedula(rs.getString(2));
                AsIns.setNombre(rs.getString(3));
                AsIns.setApellido(rs.getString(4));
                AsIns.setRol(rs.getString(8));
                AsignarIns.add(AsIns);
            }
        } catch (Exception e) {
        }
        return AsignarIns;
    }
     public asignarInstructor listar(String id){
        String sql="SELECT * FROM tbl_ficha where PK_id_ficha="+id+";";
        System.out.println(sql);
        asignarInstructor AsIns = new asignarInstructor();

        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);

            rs=ps.executeQuery();

            while (rs.next()){
                AsIns.setIdInstructor(rs.getInt(1));
                AsIns.setCedula(rs.getString(2));
                AsIns.setNombre(rs.getString(3));
                AsIns.setApellido(rs.getString(4));
                AsIns.setRol(rs.getString(8));
                
                
                System.out.println("ficha listar");
            }
        } catch (Exception e) {
            System.out.println("err: "+e);
        }
        return AsIns;
    }
    
    public void asignar(String idFicha, String idPersona){
        String sql="INSERT INTO `tbl_ficha_x_personas` (`FK_id_ficha`, `FK_id_personas`) VALUES ("+idFicha+", "+idPersona+");";
        
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("err"+e);
        }
      }
    public List ficha(){
       List fichas = new ArrayList<>();
       try {
           con=cn.conexion();
           ps=con.prepareStatement("SELECT * FROM tbl_ficha");
           rs=ps.executeQuery();
           while (rs.next()){
               fichas fcha=new fichas();

               fcha.setIdficha(rs.getString(1));
               fcha.setNumeroFicha(rs.getString(2));

               fichas.add(fcha);
           }
       } catch (Exception e) {
           System.out.println("err: "+e);
       }

       return fichas;
    }
    
}
