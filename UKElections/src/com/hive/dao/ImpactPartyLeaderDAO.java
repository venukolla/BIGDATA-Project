package com.hive.dao;


	import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.HashMap;
	 
	public class ImpactPartyLeaderDAO {
	 
	 
	 	public HashMap<String, Integer> getPartyImpactResults() throws SQLException{
	 		
	 		HashMap<String, Integer> hashMap =  new HashMap<String, Integer>();
	 		
	 		Connection connection =  ConnectionParams.getConnection();
	  
	 		Statement stmt = connection.createStatement();
	    String sql = "select keyword,count from keyword_count where keyword != party order by count desc";
	    
	    
	   // int count = stmt.executeUpdate(sql);
	    
	    ResultSet resultSet = stmt.executeQuery(sql);
	   
	    while (resultSet.next()) {
			System.out.println("Ids:"+resultSet.getString("keyword"));
			System.out.println("Values:"+resultSet.getInt("count"));
			
			hashMap.put(resultSet.getString("keyword"), resultSet.getInt("count"));
			
		}
	    stmt.close();
	    connection.close();
	
	    return hashMap;
	  }
	
}
