package com.bridgeit.emppayrollservice_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Emppayrollservice {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/emppayrollservice?useSSL=false";
		String userName = "root";
		String password = "Abhi123*";
		
		//* 1. Load the driver class 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded!");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		
		}
		
		//* 2. create the connection to database
		Connection con = null;
		try {
			con = DriverManager.getConnection(jdbcURL, userName, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(" connection established ");
		
		
		//* 3. create statement
		Statement stmt =  null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//* 4. Execute the query
		try {
			stmt.executeUpdate(" Update employeepayroll set  EmpDeductions = '20000' where name = 'abhishek';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//* 5. close the connections
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

 }
}