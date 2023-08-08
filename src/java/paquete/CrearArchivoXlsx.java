package paquete;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CrearArchivoXlsx {

    public static void main(String[] args) {

        // Crear un libro de trabajo
        Workbook workbook = new XSSFWorkbook();

        // Crear una hoja de trabajo
        Sheet sheet = workbook.createSheet("Mi Hoja");

        // Crear una fila y establecer algunos valores de celda
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Valor de la celda A1");

        // Escribir el libro de trabajo a un archivo
        try {
            FileOutputStream outputStream = new FileOutputStream("miArchivo.xlsx");
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public static void main2(String[] args) {

        // Leer el archivo xlsx
        try {
            FileInputStream inputStream = new FileInputStream("nombres.xlsx");
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            // Iterar a través de las filas y celdas
            for (Row row : sheet) {
                for (Cell cell : row) {
                    // Obtener el valor de la celda y mostrarlo en la consola
                    String cellValue = cell.getStringCellValue();
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }

            workbook.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
