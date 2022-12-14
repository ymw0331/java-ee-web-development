package com.sessionscope.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionScopeExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionScopeExample() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();

//		request.getCookies(); // ==> JSESSIONID (cookies) are data saved on client side (session tracking)
		HttpSession httpSession = request.getSession(); // get user session, see if request from same browser

		Object sessionObj = httpSession.getAttribute("isVisited");

		if (sessionObj == null) { // first send request
			httpSession.setAttribute("isVisited", true); // add attribute
			// attribute : Server-side
			// cookie : Client-side
			printWriter.print("Thanks for visiting our application");
		} else {
			printWriter.print("Welcome back"); // not first time visiting
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
