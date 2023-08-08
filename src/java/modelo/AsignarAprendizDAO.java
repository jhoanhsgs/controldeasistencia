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
public class AsignarAprendizDAO {
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
    
    public List ListarApendiz1(String idFicha){
        String sql="SELECT * FROM `tbl_personas` WHERE PK_id_personas NOT IN (SELECT tbl_ficha_x_personas.FK_id_personas from tbl_ficha_x_personas where tbl_ficha_x_personas.FK_id_ficha="+idFicha+") and FK_id_rol=2";
        List<AsignarAprendiz>AsignarAprendiz=new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                AsignarAprendiz AsAp=new AsignarAprendiz();
                AsAp.setidAprendiz(rs.getInt(1));
                AsAp.setCedula(rs.getString(2));
                AsAp.setNombre(rs.getString(3));
                AsAp.setApellido(rs.getString(4));
                AsAp.setrol(rs.getString(8));
                AsignarAprendiz.add(AsAp);
            }
        } catch (Exception e) {
        }
        return AsignarAprendiz;
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
   /*   public int agregar(Asistencia Am){     
        String sql="insert into tblpersonas(Cedula, Nombre,Apellido,email,IDUsuario,IDRol)values(?,?,?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,Am.getCedula());
            ps.setString(2,Am.getNombre());
            ps.setString(3,Am.getApellido());
            ps.setDate(4, (java.sql.Date) Am.getFecha());
            ps.setString(5,Am.getasistencia().toString());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    }*/

    /*public int Actualizar(Personas pm){
        String sql="update tblpersonas set Cedula=?, Nombre=?, Apellido=?, Email=?, IDUsuario=?, IDRol=? where IDPersonas=?";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pm.getcedula());
            ps.setString(2,pm.getNombre());
            ps.setString(3,pm.getapellido());
            ps.setString(4,pm.getemail());
            ps.setString(5,pm.getIduser());
            ps.setString(6,pm.getIdrol());
            ps.setInt(7, pm.getId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    public void eliminar(int id){
        String sql="delete from tblpersonas where IDPersonas="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }*/
     
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
    

