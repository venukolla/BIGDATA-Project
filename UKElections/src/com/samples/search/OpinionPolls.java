package com.samples.search;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hadoop.http.HttpServer;

import com.hive.dao.OpinionPollsDAO;

public class OpinionPolls extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("In the servlet");
		
		OpinionPollsDAO opinionDao= new OpinionPollsDAO();
		
		try {
			HashMap<String, Integer> hashMap =  opinionDao.getOpinionPolls();
			
			/*File createCSVFile =  new File("opinionpolls.csv");
			
			if(!createCSVFile.exists()){
				createCSVFile.createNewFile();
			}
			else{
				BufferedWriter bfwriter =  new BufferedWriter(new FileWriter(createCSVFile));
				for(Map.Entry<String, Integer> inte: hashMap.entrySet()){
					bfwriter.write(inte.getKey());
					bfwriter.write(",");
					bfwriter.write(inte.getValue());
					bfwriter.write("\n");
				}
				
			}*/
			
			req.setAttribute("HashMap", hashMap);
		} catch (SQLException e) {
			System.out.println("Exception:"+e.getMessage());
		}
		
		req.getRequestDispatcher("start.jsp").forward(req, resp);
	}
	
	public static void main(String[] args) {
		
		OpinionPollsDAO opinionDao= new OpinionPollsDAO();
		
		try {
			HashMap<String, Integer> hashMap =  opinionDao.getOpinionPolls();
			
			File createCSVFile =  new File("opinionpolls.csv");
			
			if(!createCSVFile.exists()){
				createCSVFile.createNewFile();
			}
			else{
				
				
			}
			
			BufferedWriter bfwriter =  new BufferedWriter(new FileWriter(createCSVFile));
			for(Map.Entry<String, Integer> inte: hashMap.entrySet()){
				bfwriter.write(inte.getKey());
				bfwriter.write(",");
				bfwriter.write(inte.getValue());
				bfwriter.write("\n");
			}
			
			bfwriter.close();
/*			for (Map.Entry<String, Integer> string : hashMap.entrySet()) {
				System.out.println("Key:"+string.getKey()+"Value:"+string.getValue());
			}*/
		} catch (SQLException | IOException e) {
			System.out.println("Exception:"+e.getMessage());
		}
		
		
	}
}
