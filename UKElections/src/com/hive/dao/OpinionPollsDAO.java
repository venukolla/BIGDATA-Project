package com.hive.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class OpinionPollsDAO {
	
	HashMap<String, Integer> hashMap;

	public HashMap<String,Integer> getOpinionPolls() throws SQLException{
		
		hashMap = new HashMap<String, Integer>();
		
		Connection connection  = ConnectionParams.getConnection();
		
		Statement statement = connection.createStatement();
		
		String sql  = "select party,sum(count) as sum from keyword_count group by party order by sum desc";
		
		ResultSet resultSet =  statement.executeQuery(sql);
		
		while(resultSet.next()){
			System.out.println(resultSet.getString("party"));
			System.out.println(resultSet.getInt(2));
			
			hashMap.put(resultSet.getString("party"), resultSet.getInt("sum"));
		}
		
		return hashMap;
	}
	
}
