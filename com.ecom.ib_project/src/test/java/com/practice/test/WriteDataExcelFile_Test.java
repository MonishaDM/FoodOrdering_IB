package com.practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataExcelFile_Test {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata511.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Hotels");
		sh.createRow(9).createCell(0).setCellValue("9");
		sh.getRow(9).createCell(1).setCellValue("South India");
		sh.getRow(9).createCell(2).setCellValue("Bangalore");
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata511.xlsx");
		wb.write(fos);
		int count = sh.getLastRowNum();
		int lastcell = sh.getRow(1).getLastCellNum();
		for(int i=1;i<=count;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				String values = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(values+"--------");
			}
			System.out.println();
		}

		wb.close();

	}

}
