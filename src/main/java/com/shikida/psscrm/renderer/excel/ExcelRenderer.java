package com.shikida.psscrm.renderer.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.shikida.psscrm.core.model.Model;
import com.shikida.psscrm.core.persistence.PersistenceUtil;

public class ExcelRenderer {

	private static final File EXCEL_DIR = new File("excel");
	private static final File EXCEL_FILE = new File(EXCEL_DIR,"p-sscrm-1_0.xlsx");

	public static void main(String[] args) throws IOException {

		Model model = PersistenceUtil.load("p-sscrm-1_0.json");
		render(model);

	}
	
	public static void render(Model m) throws IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("P-SSCRM");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellType(CellType.STRING);
		cell.setCellValue("P-SSCRM");
		
		FileOutputStream out = new FileOutputStream(EXCEL_FILE);
		workbook.write(out);
		out.close();
		workbook.close();

	}

}
