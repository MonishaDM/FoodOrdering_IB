package com.practice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Assgnt_Insert_Query_Test {

	public static void main(String[] args) throws Throwable {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value");
		String st = s.nextLine();
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		Statement state = con.createStatement();
		String query = "select * from TYSS;";
		ResultSet res = state.executeQuery(query);
		while(res.next()) {
			//name = System.out.println(res.getString(1));
		}
		//INSERTING VALUE
		String query1 = "insert into TYSS value('01','"+st+"');";
		state.executeUpdate(query1);
	
		/*if(st==name) {
			System.out.println("Data already exists");
		}
		for(int i= 0;i<10;i++) {
			while(res.next()) {
				System.out.println(res.getString(i));
			}
		} */
		con.close();
	}

}
