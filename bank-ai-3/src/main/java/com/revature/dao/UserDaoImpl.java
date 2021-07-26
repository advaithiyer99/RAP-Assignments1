package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.*;
import com.revature.utils.DAOUtility;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement statement;
	
	@Override
	public User getUser(String text) {
		
		User user = null;
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from customer where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, text);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String username = rs.getString("username");
				String PIN = rs.getString("password");
				String name = rs.getString("name");
				
				

				if (name != null) {
					user = new Customer(username, PIN, name);
				} else {
					user = new Employee(username, PIN);
				}
			}
			
			return user;
			
		} catch(SQLException ex) {
			System.out.println("Error: User unavailable.");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return user;
	}

	private void closeResources() {
		try {
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch(SQLException ex) {
			System.out.println("Error: Could not close resources.");
			ex.printStackTrace();
		}
	}

}