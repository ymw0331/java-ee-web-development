package com.applicationscope.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection connection = null;

	public static Connection openConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver"); // Step 1
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee_db?characterEncoding=latin1&useConfigs=maxPerformance",
					"root", "password"); // Step 2
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean closeConnection() {

		try {
			connection.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		DBConnection dbConnection = new DBConnection();
		System.out.println(dbConnection.openConnection());

	}
}
