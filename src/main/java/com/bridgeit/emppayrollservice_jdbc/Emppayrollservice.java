package com.bridgeit.emppayrollservice_jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

public class Emppayrollservice {
	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost:3306/emppayrollservice?useSSL=false";
		String userName = "root";
		String password = "Abhi123*";
		
		 Connection con;
	        
	        try{                                                                                    //try catch method to catch any exception occurs
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver Loaded");
	            con = DriverManager.getConnection(jdbcURL, userName, password);
	            System.out.println("Connection is Succesful "+con);
	            
	            PreparedStatement stmt =con.prepareStatement("select name,s_date from employeepayroll where S_date between cast('2019-06-19' as date) and date(now());");
	            ResultSet resultSet=stmt.executeQuery();
	            
	            while(resultSet.next()){                                                            //using while loop printing employee data
	                String name2 = resultSet.getString("name");
	                String date = resultSet.getString("s_date");

	                System.out.println(name2+" joining date "+date);
	            }
	            con.close();
	            
	        } 
	        
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        listDrivers();
	    }

	    /**
	     * listDrivers() method to list the Drivers
	     * */
	    public static void listDrivers(){
	        Enumeration<Driver> driverEnumeration= DriverManager.getDrivers();
	        while(driverEnumeration.hasMoreElements()){
	            Driver driver= (Driver) driverEnumeration.nextElement();
	            System.out.println("  "+driverEnumeration.getClass().getName());
	        }
	    }
	}