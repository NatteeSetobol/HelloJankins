package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.services.UserService;

public class LoginServlet extends HttpServlet {
	
	private static UserService userService = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("userId");
		String password = req.getParameter("password");
		
		RequestDispatcher reqDispatch = null;
		PrintWriter printWriter = resp.getWriter();

		if(userService.login(username, password)) {
			//create a new session object
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			//forwards to baseURI/success
			reqDispatch = req.getRequestDispatcher("success");
			reqDispatch.forward(req, resp);
		}else{
			reqDispatch = req.getRequestDispatcher("index.html");
			reqDispatch.include(req, resp);
			printWriter.print("<span style='color:red; text-align:center'>Invalid Username or Password</span>");
		}
	}

}
