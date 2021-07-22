package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			session.invalidate();
		}
		
		//sendRedirect with an empty string will redirect to the base URL. 
		response.sendRedirect("http://www.google.com");
	}
	
}
