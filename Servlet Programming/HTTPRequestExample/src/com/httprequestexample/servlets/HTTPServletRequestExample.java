package com.httprequestexample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTTPServletRequestExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HTTPServletRequestExample() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); // automatically direct to doPost
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter printWriter = response.getWriter();

		// Request Object content : HTTP Request object which sent from web browser :
		// Header + Body (Parameters)
		// 1- Locale : Language ==> Response depends on locale (regconize request
		// language)
		printWriter.print("<h1>Request Locale : " + request.getLocale() + "</h1>");

		// 2- Content Length:
		printWriter.print("<h1>Request Content Length :" + request.getContentLength() + "</h1>");

		// 3- Server Name:
		printWriter.print("<h1>Request Server Name : " + request.getServerName() + "</h1>");

		// 4- Content Type (Mime Type)
		printWriter.print("<h1>Request Content Type : " + request.getContentType() + "</h1>");

		// 5- Context Path
		printWriter.print("<h1>Request Context Path : " + request.getContextPath() + "</h1>");

		// 6 - Parameter (get all data from user input)
		printWriter.print("<h1>User Name Parameter: " + request.getParameter("userName") + "</h1>");
		printWriter.print("<h1>Country Parameter: " + request.getParameter("country") + "</h1>");
		request.getParameterNames();

		// Quiz : HTML Request Headers
		// Is there a way to reach certain header directly without using java functon
		request.getHeader("");
		request.getHeaderNames();

	}

}
