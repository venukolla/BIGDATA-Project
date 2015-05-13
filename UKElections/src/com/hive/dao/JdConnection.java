package com.hive.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdConnection {

	public static void main(String[] args) throws SQLException {
		
		Connection connection = ConnectionParams.getConnection();
		
		Statement stmt = connection.createStatement();
		
		//String sql = "select place_name, count(*) as count from tweet_info where place_name not in ('null') group by place_name order by count desc";
		
		String sql = "select place_country, count(*) as count from tweet_info where place_country not in ('null') group by place_country order by count desc";
		ResultSet resultSet =  stmt.executeQuery(sql);
		
		while (resultSet.next()) {
			System.out.println(resultSet.getString("place_country")+""+ resultSet.getInt("count"));
			
		}
	}
}
