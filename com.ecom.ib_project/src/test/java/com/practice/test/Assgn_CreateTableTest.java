package com.practice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class Assgn_CreateTableTest {
public static void main(String[] args) throws Throwable {
		
		Scanner s= new Scanner(System.in);
		Connection con=null;
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		Statement state= con.createStatement();
		System.out.println("Enter Name to add");
		String name=s.nextLine();
		int count=0;
		String q1="Select name from TYSS;";
		String q2="insert into tyss (Name) values('"+name+"');";
		ResultSet res1 = state.executeQuery(q1);
		while (res1.next()) {
			String bName=res1.getString(1);
			if (bName.equalsIgnoreCase(name)) {
				System.out.println(name+" is already existing in TYSS");
				count++;
				break;
			}
			}
		int res=0;
		if (count==0) {
			res = state.executeUpdate(q2);
		}
		if (res>0) {
			System.out.println(name+" is entered in TYSS");
		}
		System.out.println();
		String q3="Select * from TYSS order by id;";
		ResultSet res3 = (state).executeQuery(q3);
		System.out.println("Updated table");
		while (res3.next()) {
			System.out.println(res3.getString(1)+" "+res3.getString(2));
		}
	}

}