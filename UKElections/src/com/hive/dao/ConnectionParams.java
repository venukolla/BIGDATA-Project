package com.hive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionParams {
	
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	  
	  private static String url = "jdbc:hive2://bi-hadoop-prod-117.services.dal.bluemix.net:10000/default";
	  
	  private static String password = "t56K40Ofz~gV";
	  private static String userName = "biblumix";
	  
	  private static Connection connection;

	public static Connection getConnection(){
			
		
		try {
		      Class.forName(driverName);
		    
		    connection = DriverManager.getConnection(url,userName,password);
		    
		} catch (ClassNotFoundException | SQLException e) {
		     
		      e.printStackTrace();
		      System.exit(1);
		      
		    }
		return connection;
		    
	}
}
