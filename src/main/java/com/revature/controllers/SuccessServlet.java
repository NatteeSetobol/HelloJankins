package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SuccessServlet extends HttpServlet {

	// This is bad practice but possible. Sometimes it may be necessary.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// This is a flag to the browser about what format the response body is in.
		HttpSession session = request.getSession(false);

		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();

		if (session == null) {
			printWriter.print("<h1>YOU ARE NOT LOGGED IN!!!!!!!!!!!!!!!</h1>");
		} else {

			String username = (String) session.getAttribute("username");
			printWriter.print("<h2> Welcome " + username + ", you successfully logged in!</h2>");
			printWriter.print("<a href='logout'>Click here to logout!</a>");
		}
	}

}
