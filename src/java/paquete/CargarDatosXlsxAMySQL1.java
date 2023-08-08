import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CargarDatosXlsxAMySQL1 {

    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Cargar el archivo
            FileInputStream inputStream = new FileInputStream("nombres.xlsx");
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Obtener la hoja de trabajo
            Sheet sheet = workbook.getSheetAt(0);

            // Conectar a la base de datos
            String url = "jdbc:mysql://localhost:3306/asistencia2";
            String usuario = "root";
            String password = "";
            connection = DriverManager.getConnection(url, usuario, password);

            // Preparar la sentencia SQL para insertar los datos
                        String insertSQL = "INSERT INTO tbl_personas (cedula, nombre, apellido,telefono,email,FK_id_rol) VALUES (?, ?, ?,?,?,2)";

            preparedStatement = connection.prepareStatement(insertSQL);

            // Recorrer las filas y las celdas de la hoja de trabajo
            for (Row row : sheet) {
                // Obtener los valores de las celdas y establecerlos en la sentencia SQL
                Cell cell1 = row.getCell(0);
                if (cell1.getCellTypeEnum()== CellType.NUMERIC) {
                    preparedStatement.setDouble(1, cell1.getNumericCellValue());
                } else {
                    preparedStatement.setString(1, cell1.getStringCellValue());
                }

                Cell cell2 = row.getCell(1);
                if (cell2.getCellTypeEnum()== CellType.NUMERIC) {
                    preparedStatement.setDouble(2, cell2.getNumericCellValue());
                } else {
                    preparedStatement.setString(2, cell2.getStringCellValue());
                }

                Cell cell3 = row.getCell(2);
                if (cell3.getCellTypeEnum()== CellType.NUMERIC) {
                    preparedStatement.setDouble(3, cell3.getNumericCellValue());
                } else {
                    preparedStatement.setString(3, cell3.getStringCellValue());
                }
                Cell cell4 = row.getCell(3);
                if (cell4.getCellTypeEnum()== CellType.NUMERIC) {
                    preparedStatement.setDouble(4, cell4.getNumericCellValue());
                } else {
                    preparedStatement.setString(4, cell4.getStringCellValue());
                }
                Cell cell5 = row.getCell(4);
                if (cell5.getCellTypeEnum()== CellType.NUMERIC) {
                    preparedStatement.setDouble(5, cell5.getNumericCellValue());
                } else {
                    preparedStatement.setString(5, cell5.getStringCellValue());
                }
               

                // Ejecutar la sentencia SQL para insertar los datos
                preparedStatement.executeUpdate();
            }

            // Cerrar el libro de trabajo, el archivo de entrada, la sentencia SQL y la conexión a la base de datos
            workbook.close();
            inputStream.close();
            preparedStatement.close();
            connection.close();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
