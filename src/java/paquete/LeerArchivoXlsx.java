package paquete;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import static org.apache.poi.ss.usermodel.CellType.BOOLEAN;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerArchivoXlsx {

    public static void main(String[] args) {

        // Cargar el archivo xlsx en un objeto Workbook
        try {
            FileInputStream inputStream = new FileInputStream(new File("nombres.xlsx"));
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Obtener la hoja de trabajo por su índice (en este caso, la primera hoja)
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar sobre las filas de la hoja y obtener los valores de las celdas
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellTypeEnum().toString()) {
                        case "STRING":
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case "NUMERIC":
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case "BOOLEAN":
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("\t");
                    }
                }
                System.out.println();
            }

            // Cerrar el archivo
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
