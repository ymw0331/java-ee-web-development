package com.httpservletresponse.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BinaryStreamExample extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BinaryStreamExample() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Setting response Mime Type
		response.setContentType("image/png");// MIME type (default is text/html)

		// Response Binary Stream
		ServletOutputStream outputStream = response.getOutputStream();

		// Read Image Bytes
		// 1- Open Stream
		InputStream inputStream = getServletContext().getResourceAsStream("images/linux.jpg");

		// 2- Define Byte Array
		byte[] imageBytes = new byte[inputStream.available()];

		// 3- Read the Image
		inputStream.read(imageBytes);

		// 4- Write Image Bytes on Servlet Output Stream
		outputStream.write(imageBytes);

		// 5- Flush the response
		outputStream.flush();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
