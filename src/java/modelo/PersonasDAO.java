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
public class PersonasDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Personas validar(String user, String pass) {
        Personas pm = new Personas();
        String sql = "select * from tbl_usuario inner join tbl_personas on tbl_usuario.FK_id_personas = tbl_personas.PK_id_personas where tbl_usuario.usuario=? and tbl_usuario.contrasena=?";
        //select * from tbl_usuario inner join tbl_personas on tbl_usuario.FK_id_personas = tbl_personas.PK_id_personas where tbl_usuario.usuario='453' and tbl_usuario.contrasena='453';
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            while (rs.next()) {
                pm.setId(rs.getInt("PK_id_usuario"));
                pm.setUser(rs.getString("usuario"));
                pm.setpass(rs.getString("contrasena"));
                pm.setNombre(rs.getString("nombre"));
                pm.setemail(rs.getString("email"));
                pm.setRol(rs.getString("FK_id_rol"));
                pm.setIdpersona(rs.getString("PK_id_personas"));

            }
        } catch (Exception e) {
        }
        return pm;
    }

    //operaciones CRUD
    public List listar() {
        String sql = "SELECT * FROM tbl_personas,tbl_usuario,tbl_rol WHERE tbl_personas.PK_id_personas = tbl_usuario.FK_id_personas AND tbl_personas.FK_id_rol=tbl_rol.PK_id_rol  ORDER BY PK_id_personas ASC";
        List<Personas> lista = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Personas pm = new Personas();
                pm.setId(rs.getInt(1));
                pm.setcedula(rs.getString(2));
                pm.setNombre(rs.getString(3));
                pm.setapellido(rs.getString(4));
                pm.setemail(rs.getString(6));
                pm.setUser(rs.getString(11));
                pm.setRol(rs.getString(16));

                lista.add(pm);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int agregar(Personas pm) {
        String sql = "insert into tbl_personas(cedula, nombre,apellido,email,FK_id_rol) values(?,?,?,?,?)";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, pm.getcedula());
            ps.setString(2, pm.getNombre());
            ps.setString(3, pm.getapellido());

            ps.setString(4, pm.getemail());
            ps.setString(5, pm.getIdrol());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("err" + e);
        }
        return r;
    }

    public Personas listarId(int id) {
        Personas emp = new Personas();
        String sql = "select * from tbl_personas where PK_id_personas=" + id;

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emp.setcedula(rs.getString(2));
                emp.setNombre(rs.getString(3));
                emp.setapellido(rs.getString(4));
                emp.setemail(rs.getString(6));
                emp.setIdrol(rs.getString(8));
            }
        } catch (Exception e) {
        }
        return emp;
    }

    public int Actualizar(Personas pm) {
        System.out.println("aquii");
        String sql = "update tbl_personas set cedula=?, nombre=?, apellido=?, email=?, FK_id_rol=? where PK_id_personas =?";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pm.getcedula());
            ps.setString(2, pm.getNombre());
            ps.setString(3, pm.getapellido());
            ps.setString(4, pm.getemail());
            ps.setString(5, pm.getIdrol());
            ps.setInt(6, pm.getId());
            ps.executeUpdate();
            System.out.println("consulta" + ps);
        } catch (Exception e) {
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "delete from tbl_usuario where FK_id_personas=?";
        System.out.println(sql);
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println(ps);
        } catch (Exception e) {
            System.out.println("err" + e);
        }
    }

    public List rol() {
        List rols = new ArrayList<>();
        try {
            con = cn.conexion();
            ps = con.prepareStatement("SELECT * FROM tbl_rol");
            rs = ps.executeQuery();
            while (rs.next()) {
                rol rl = new rol();

                rl.setId(rs.getString(1));
                rl.setNombre(rs.getString(2));

                rols.add(rl);
            }
        } catch (Exception e) {
            System.out.println("err: " + e);
        }

        return rols;
    }

    public Object getuser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Personas listar(int idPersonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
