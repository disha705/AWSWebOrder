package Setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ReadExcelData {

	public static Object[][] getData(String ExcelName, String SheetName, String TestName) throws IOException {
		String[][] dataSet = null;

		String ExcelPath = System.getProperty("user.dir") + "\\Resources\\Excel\\" + ExcelName;

		FileInputStream input = new FileInputStream(new File(ExcelPath));
		System.out.println(input);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet(SheetName);

		int rownum = 0;
		try {
			while (!sheet.getRow(rownum).getCell(0).getStringCellValue().equals(TestName))
				rownum++;
		} catch (Exception e) {
			rownum++;
		}

		int noOfColumns = 0;
		if (TestName.equals("Creden")) {
			noOfColumns = 2;
			System.out.println("creden");
		}

		else if (TestName.equals("Order")) {
			noOfColumns = 7;
			System.out.println("Order");
		} else if (TestName.equals("table")) {
			noOfColumns = 3;
			System.out.println("table");
		}
		int noOfRows = 0;
		if (TestName.equals("table")) {
			noOfRows = 3;
			System.out.println("table");
		}

		else {
			noOfRows = 1;
			System.out.println("default");
		}

		dataSet = new String[noOfRows][noOfColumns];

		int x = 0, y = 0;
		for (int i = 0; i < noOfRows; i++, x++) {
			rownum++;
			y = 0;
			for (int j = 0; j < noOfColumns; j++, y++) {
				DataFormatter formatter = new DataFormatter();
//				String val = formatter.formatCellValue(sheet.getRow(rownum).getCell(j));
				dataSet[x][y] = formatter.formatCellValue(sheet.getRow(rownum).getCell(j));
//				dataSet[x][y] = sheet.getRow(rownum).getCell(j).getStringCellValue();
			}
		}
		return dataSet;
	}

}
