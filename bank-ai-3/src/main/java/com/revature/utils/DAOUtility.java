package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOUtility {
	public static String CONNECTION_USERNAME = "postgres";
	public static String CONNECTION_PASSWORD = "Westlake2017";
	public static String CONNECTION_URL = "jdbc:postgresql://localhost:5432/postgres";
	public static Connection connection;

	public static void init() {
		if (CONNECTION_URL != null) {
			return;
		}
		try {
			// get reference to properties file
			DAOUtility.class.getClassLoader();
			InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");
			Properties properties = new Properties();
			properties.load(input);
			
			// take values from keys in file
			String CONNECTION_USERNAME_VAR = properties.getProperty("CONNECTION_USERNAME");
			String CONNECTION_PASSWORD_VAR = properties.getProperty("CONNECTION_PASSWORD");
			String CONNECTION_URL_VAR = properties.getProperty("CONNECTION_URL");
			
			CONNECTION_USERNAME = System.getenv(CONNECTION_USERNAME_VAR);
			CONNECTION_PASSWORD = System.getenv(CONNECTION_PASSWORD_VAR);
			CONNECTION_URL = System.getenv(CONNECTION_URL_VAR);
			
			CONNECTION_USERNAME = System.getenv(properties.getProperty("CONNECTION_USERNAME"));
			CONNECTION_PASSWORD = System.getenv(properties.getProperty("CONNECTION_PASSWORD"));
			CONNECTION_URL = System.getenv(properties.getProperty("CONNECTION_URL"));
			
			input.close();
		} catch(IOException ex) {
			System.out.println("Failed to load properties from file.");
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Could not register driver!");
			ex.printStackTrace();
		}
		
		if (connection == null || connection.isClosed()) {
			connection = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		
		return connection;
	}
}