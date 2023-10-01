package com.practice.test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataExcelFileTest {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Testdata511.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Hotels");
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
