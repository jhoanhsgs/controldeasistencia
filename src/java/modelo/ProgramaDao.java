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
import java.util.List;

/**
 *
 * @author jhoan
 */
public class ProgramaDao {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public List programas() {
        List programs = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement("SELECT * FROM tbl_programacion");
            rs = ps.executeQuery();
            while (rs.next()) {
                Programa program = new Programa();

                program.setId(rs.getString(1));
                program.setNombre(rs.getString(2));
                program.setVigencia(rs.getString(3));
                program.setVersion(rs.getString(4));
                program.setFecha(rs.getString(5));

                programs.add(program);
            }
        } catch (Exception e) {
            System.out.println("err: " + e);
        }

        return programs;
    }

    public void agregar(Programa pf) {
        String sql = "INSERT INTO tbl_programacion(nombre_programa,vigencia,version)values(?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, pf.getNombre());
            ps.setString(2, pf.getVigencia());
            ps.setString(3, pf.getVersion());
            ps.executeUpdate();
            //   System.out.println("insertdao");
        } catch (Exception e) {
            System.out.println("err" + e);
        }
    }

    public Programa listarId(int id) {
        Programa pgf = new Programa();
        String sql = "select * from tbl_programacion where PK_id_programa_formacion=" + id;

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pgf.setNombre(rs.getString(2));
                pgf.setVigencia(rs.getString(3));
                pgf.setVersion(rs.getString(4));
            //    System.out.println("programalistado");
            }
        } catch (Exception e) {
            System.out.println("err" + e);
        }
        return pgf;
    }

    public void eliminar(int id) {
        String sql = "delete from tbl_programacion where PK_id_programa_formacion="+id;
        System.out.println("consulta"+sql);
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
           // System.out.println("eliipp");
        } catch (Exception e) {
            System.out.println("err" + e);
        }

    }
    public int Actualizar(Programa pmf){
        String sql="update tbl_programacion set nombre_programa=?,vigencia=?,version=? where PK_id_programa_formacion=?";
//        System.out.println("id de ficha:"+fc.getId());
        try {
            con=cn.conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1,pmf.getNombre());
            ps.setString(2,pmf.getVigencia());
            ps.setString(3,pmf.getVersion());
            
            ps.setString(4, pmf.getId());
            ps.executeUpdate();
            System.out.println("actualizar pgf"+ps);
        } catch (Exception e) {
        }
        return r;
    }
    
}
