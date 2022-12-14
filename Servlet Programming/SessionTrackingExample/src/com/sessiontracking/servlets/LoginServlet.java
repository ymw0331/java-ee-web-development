package com.sessiontracking.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		doPost(request, response); // make default implementation in doPost and recall this method in other empty
									// method

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);

		printWriter.print("<h3> User Name :  " + userName + " </h3><br/>");
		printWriter.print("<h3> Password :  " + password + " </h3><br/>");

		// Cookie name is JSESSIONID Cookie
		// Auth User ==> DB or LDAP
		Cookie userNameCookie = new Cookie("userName", userName);
		Cookie passwordCookie = new Cookie("password", password);

		// add cookie, use response object
		response.addCookie(userNameCookie);
		response.addCookie(passwordCookie);

		printWriter.print("<a href='/SessionTrackingExample/displayCookiesServlet' >Display Cookies </a>");

	}

}
