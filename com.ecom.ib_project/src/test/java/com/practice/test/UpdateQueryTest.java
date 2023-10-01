package com.practice.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateQueryTest {

	public static void main(String[] args) throws Throwable {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		Statement state = con.createStatement();
	String query = "insert into project values('Team4','Dhamu','AzureCloud','3');";
	int res = state.executeUpdate(query);
	if(res>0)
	{
		System.out.println("Details are updated");
	}
	else {
		System.out.println("Details are not updated");
	}
	String query1 = "select * from project;";
	ResultSet res1 = state.executeQuery(query1);
	while(res1.next()) {
		System.out.println(res1.getString(1)+" "+res1.getString(2)+" "+res1.getString(3)+" "+res1.getString(4));
	}
	con.close();

	}

}
