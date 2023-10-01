package com.practice.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteMultipleDataExcelTest {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no.of.rows");
		int row = sc.nextInt();
		System.out.println("Enter the no.of.columns");
		int col=sc.nextInt();
		String path = ".\\src\\test\\resources\\Testdata511.xlsx";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Hotels");
		for(int i=1;i<row;i++) {
			sh.createRow(i);
			for(int j=0;j<col;j++) {
				System.out.println("Enter the data for "+i+"row and"+j+"cell");
				String c = sc.next();
				sh.getRow(i).createCell(j).setCellValue(c);
			}
		}
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Testdata511.xlsx");

	}

}
