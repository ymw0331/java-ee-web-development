package com.applicatioscope;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextParamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		config.getServletContext();
	}

	public ContextParamExample() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter printWriter = response.getWriter();
		ServletContext servletContext = request.getServletContext();

		printWriter.print("<h2>Context Parameters</h2><br/>");
		printWriter.print("<h3>DB IP Param: " + getServletContext().getInitParameter("db-ip") + "</h3>");
		printWriter.print("<h3>DB Port Param: " + getServletContext().getInitParameter("db-port") + "</h3>");

		Enumeration<String> enumeration = servletContext.getInitParameterNames();
		// Loop
		// servletContext.getInitParameter(T);

		// methods to get servlet context
//		request.getServletContext();
//		getServletContext();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
