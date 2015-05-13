package com.samples.search;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hive.dao.ImpactPartyLeaderDAO;

public class ImpactPartLeader extends HttpServlet {
	
	HashMap<String, Integer> hashMap;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Helloooooooooooooo hhaskagsdfkagskjdgsk");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Testing Working search resultsssssssssssss1111");
		
		String name = req.getParameter("test");
		
		System.out.println("Search:"+name);
		
		String query = req.getParameter("id");
		
		System.out.println(req.getParameter("test"));
		
		System.out.println(req.getParameter("testing"));
		
		System.out.println("Iddd"+query);
		
		ImpactPartyLeaderDAO impactPartyLeader = new ImpactPartyLeaderDAO();
		
		
		try {
			hashMap = impactPartyLeader.getPartyImpactResults();
		} catch (SQLException e) {
			System.out.println("Exception in Impact Party Leader"+e.getMessage());
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
