package com.applicatioscope;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationScopeServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ServletContext servletContext = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		servletContext = config.getServletContext();
//		servletContext = getServletContext();
	}

	public ApplicationScopeServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter printWriter = response.getWriter();
		Connection connection = (Connection) servletContext.getAttribute("db-connection");
//		ServletContext servletContext = getServletContext(); //recommended to define at init();
		printWriter.print("<h1>Employee DB Object is Obtained from Context : " + connection + "</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
