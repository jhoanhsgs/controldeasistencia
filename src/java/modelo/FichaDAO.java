/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import config.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.util.net.AprEndpoint;

/**
 *
 * @author jhoan
 */
public class FichaDAO {
    conexion cn=new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    /*public Personas validar(String user, String pass){
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
    */
    
    //operaciones CRUD
    public List programas(){
        List programs = new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement("SELECT * FROM tbl_programacion");
            rs=ps.executeQuery();
            while (rs.next()){
                Programa program=new Programa();
                
                program.setId(rs.getString(1));
                program.setNombre(rs.getString(2));
                program.setVigencia(rs.getString(3));
                program.setVersion(rs.getString(4));
                program.setFecha(rs.getString(5));

                
                programs.add(program);
            }
        } catch (Exception e) {
            System.out.println("err: "+e);
        }
        
        return programs;
    }
    public List listar(){
        String sql="SELECT * FROM tbl_ficha,tbl_programacion where tbl_ficha.FK_id_programa_formacion = tbl_programacion.PK_id_programa_formacion";
        List<Ficha>lista1=new ArrayList<>();
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                Ficha Fc=new Ficha();
                Fc.setId(rs.getInt(1));
                Fc.setNficha(rs.getString(2));
                Fc.setFechaI(rs.getString(3));
                Fc.setFechaF(rs.getString(4));
                Fc.setFechaC(rs.getString(5));
                Fc.setIdprogformacion(rs.getString(7));
                Fc.setNombre(rs.getString(8));
                
                lista1.add(Fc);
            }
        } catch (Exception e) {
            System.out.println("err: "+e);
        }
        return lista1;
    }
    
    public Ficha listar(String id){
        String sql="SELECT * FROM tbl_ficha where PK_id_ficha="+id+";";
        System.out.println(sql);
        Ficha Fc=new Ficha();

        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);

            rs=ps.executeQuery();

            while (rs.next()){
                Fc.setId(rs.getInt(1));
                Fc.setNficha(rs.getString(2));
                Fc.setFechaI(rs.getString(3));
                Fc.setFechaF(rs.getString(4));
                Fc.setFechaC(rs.getString(5));
                Fc.setIdprogformacion(rs.getString(7));
                
                System.out.println("ficha listar");
            }
        } catch (Exception e) {
            System.out.println("err: "+e);
        }
        return Fc;
    }
    
    
    public int agregar(Ficha fc){     
        String sql="insert into tbl_ficha(numero_de_ficha, fecha_inicio, fecha_fin, FK_id_programa_formacion)values(?,?,?,?)";
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            
            ps.setString(1,fc.getNficha());
            ps.setString(2,fc.getFechaI());
            ps.setString(3,fc.getFechaF());
            ps.setString(4,fc.getIdprogformacion());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("err"+e);
        }
        return r;
    }
     /*public Personas listarId(int id){
        Personas emp=new Personas();
        String sql="select * from tblpersonas where IDPersonas="+id;
       
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                emp.setcedula(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setapellido(rs.getString(4));
                emp.setemail(rs.getString(5));
                emp.setUser(rs.getString(6));
                emp.setIdrol(rs.getString(7));
                
            }
        } catch (Exception e) {
        }
        return emp;
    }*/ 
    public int Actualizar(Ficha fc){
        String sql="update tbl_ficha set numero_de_ficha=? where PK_id_ficha=?";
//        System.out.println("id de ficha:"+fc.getId());
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,fc.getNficha());
            ps.setInt(2, fc.getId());
            ps.executeUpdate();
            System.out.println("actualizar f"+ps);
        } catch (Exception e) {
        }
        return r;
    }
    public void eliminar(int id){
        String sql="delete from tbl_ficha where PK_id_ficha="+id;
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("err"+e);
        }
    }

    /*public Object getuser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Personas listar(int idPersonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
}
