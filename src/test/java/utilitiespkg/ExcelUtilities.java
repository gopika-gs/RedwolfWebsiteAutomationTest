package utilitiespkg;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	private static final String FILE_PATH = "files\\loginCredentials.xlsx";

    public static List<String[]> getLoginData() throws IOException {
        List<String[]> loginDataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Sheet1");
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) { 
                Row row = sheet.getRow(i);

                if (row == null || row.getCell(0) == null || row.getCell(1) == null) {
                    continue;
                }

                String[] data = new String[2];
                Cell emailCell = row.getCell(0);
                Cell passwordCell = row.getCell(1);
                data[0] = getCellValueAsString(emailCell);
                data[1] = getCellValueAsString(passwordCell);

                loginDataList.add(data);
            }
        }

        return loginDataList;
    }
    
    private static String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
