package com.samples.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchResults extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Helloooooooooooooo");
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Testing Working");
		
		String name = req.getParameter("test");
		
		System.out.println("Search:"+name);
		
		String query = req.getParameter("id");
		
		System.out.println(req.getParameter("test"));
		
		System.out.println(req.getParameter("testing"));
		
		System.out.println("Iddd"+query);
		
	}
	
	public static void main(String[] args) {
		
	}
}
