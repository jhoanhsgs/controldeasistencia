/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import config.conexion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author JH
 */
public class AsistenciaDAO {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps, psCrearRegistro, psCrearDetalle;
    ResultSet rs, rsLastId;
    int r;
    LocalDateTime today = LocalDateTime.now();

    //operaciones CRUD
    /*  public Personas validar(String user, String pass){
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
    }*/
    public List llenar(String fichaActual) {
        //String sql="SELECT * FROM tbl_ficha_x_personas,tbl_personas,tbl_ficha WHERE tbl_ficha_x_personas.FK_id_ficha=tbl_ficha.PK_id_ficha AND tbl_ficha_x_personas.FK_id_personas=tbl_personas.PK_id_personas";
        String sql = "SELECT * FROM tbl_ficha_x_personas,tbl_ficha, tbl_personas WHERE tbl_ficha_x_personas.FK_id_ficha=" + fichaActual + " and tbl_ficha.PK_id_ficha=" + fichaActual + " and tbl_personas.PK_id_personas= tbl_ficha_x_personas.FK_id_personas;";
        String sqlFaltas = "select COUNT(FK_id_persona) as faltas from tbl_detalles where FK_id_persona=? and (FK_id_novedad=2 or FK_id_novedad=3);";

        List<Asistencia> asistencia = new ArrayList<>();
        System.out.println(sql);
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            PreparedStatement ps2 = con.prepareStatement(sqlFaltas);

            rs = ps.executeQuery();
            while (rs.next()) {
                //System.out.println("here");
                ps2.setString(1, rs.getString(3));

                Asistencia Am = new Asistencia();
                Am.setId(rs.getInt(1));
                Am.setIdPersona(rs.getString(3));
                Am.setCedula(rs.getString(11));
                Am.setNombre(rs.getString(12));
                Am.setApellido(rs.getString(13));

                ResultSet rs2 = ps2.executeQuery();

                if (rs2.next()) {
                    String nFaltas = rs2.getString(1);
                    Am.setTotal_inasistencia(nFaltas);
                }
                //System.out.println(ps2.executeQuery());

                asistencia.add(Am);
            }
        } catch (Exception e) {
        }
        return asistencia;
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

    public void registrarAsistencia(String idUser, String asistencia, String date) {
        String sqlCrearRegistro = "INSERT INTO `tbl_registro_asistencia` (`fecha_y_hora_asistencia`) VALUES ('" + date + "');";
        String sqlLastId = "SELECT * FROM tbl_registro_asistencia ORDER BY PK_id_registro_asistencia DESC LIMIT 1;";

        System.out.println("REGISTRO" + sqlCrearRegistro);
        //for(Asistencia as: asistencia){
        try {
            con = cn.conexion();
            psCrearRegistro = con.prepareStatement(sqlCrearRegistro);
            psCrearRegistro.executeUpdate();
            //System.out.println(id);

            rsLastId = con.prepareStatement(sqlLastId).executeQuery();
            if (rsLastId.next()) {
                String lastId = rsLastId.getString(1);
                System.out.println(lastId);

                String sqlCrearDetalle = "INSERT INTO tbl_detalles (`FK_id_persona`, `FK_id_registro_asistencia`, `FK_id_novedad`) "
                        + "VALUES (" + idUser + "," + lastId + "," + asistencia + ");";

                //System.out.println(sqlCrearDetalle);
                psCrearDetalle = con.prepareStatement(sqlCrearDetalle);
                /*psCrearDetalle.setString(1, as.getIdPersona());
                    psCrearDetalle.setString(2, lastId);
                    psCrearDetalle.setString(3, "1");*/

                psCrearDetalle.executeUpdate();
                //System.out.println("REGISTRADO");
            }

        } catch (Exception e) {
            System.out.println("err" + e);
        }
        //}

    }

    public List registradosHoy() {
        List<String> registrados = new ArrayList();
        String sql = "SELECT * from tbl_detalles, tbl_registro_asistencia where tbl_registro_asistencia.fecha_y_hora_asistencia = CURRENT_DATE();";
        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                registrados.add(rs.getString(2) + "-" + rs.getString(4));
            }

        } catch (Exception e) {
            System.out.println("err" + e);
        }

        return registrados;
    }

    public String Inasistencias(String idPersona) {
        //List<String> registrados = new ArrayList();
        String sql = "select COUNT(FK_id_persona) as faltas from tbl_detalles where FK_id_persona=" + idPersona + " and (FK_id_novedad=2 or FK_id_novedad=3);";

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println("err" + e);
        }

        return "";
    }

    public Asistencia listarId(int id) {
        Asistencia Am = new Asistencia();
        String sql = "select * from tblpersonas where IDPersonas=" + id;

        try {
            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Am.setCedula(rs.getString(2));
                Am.setNombre(rs.getString(3));
                Am.setApellido(rs.getString(4));

            }
        } catch (Exception e) {
        }
        return Am;
    }

    public void generarReporte() {
        //Asistencia Am=new Asistencia();
        System.out.println("REPORTE");

        //String sql = "select * from tbl_detalles where FK_id_novedad=2 or FK_id_novedad=3;";
        
        String sql = "SELECT * FROM tbl_ficha,tbl_programacion where tbl_ficha.FK_id_programa_formacion = tbl_programacion.PK_id_programa_formacion";

        try {
            //FileInputStream inputStream = new FileInputStream("reporteAsistencia.xlsx");

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("reporte");

            con = cn.conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            int numColumns = rs.getMetaData().getColumnCount();
            
            Row headerRow = sheet.createRow(0);
            for (int i = 1; i <= numColumns; i++) {
                String columnName = rs.getMetaData().getColumnName(i);
                Cell cell = headerRow.createCell(i-1);
                cell.setCellValue(columnName);
            }

            int cont = 1;

            while (rs.next()) {
               Row row1 = sheet.createRow(cont);
               for (int i = 1; i <= numColumns; i++) {
                    String value = rs.getString(i);
                    Cell cell12 = row1.createCell(i-1);
                    cell12.setCellValue(value);
                }
            }
            
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            String filePath = desktopPath + "reporteInasistencia.xlsx";
            
            FileOutputStream outputStream = new FileOutputStream(filePath);
            workbook.write(outputStream);
            workbook.close();
            System.out.println("Archivo guardado en " + filePath);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
        //workbook.write(out);
    }

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
    }
    public int GeneraAsistencia(Asistencia Ga){
       String sql="inser";
   }
     */
    public Asistencia listar(int idPersonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
