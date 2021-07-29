package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.models.*;
import com.revature.utils.DAOUtility;

public class BankAccountDaoImpl implements BankAccountDao {
	
	private Connection connection;
	private PreparedStatement statement;

	@Override
	public boolean addAccount(BankAccount account) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "insert into account values (default, ?, ?, ?, ?);";
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, account.getAccountNumber());
			statement.setDouble(2, account.getAccountBalance());
			statement.setString(3, account.getAccountType());
			statement.setString(4, account.getAccountStatus());
			
			return statement.executeUpdate() != 0;
			
		} catch(SQLException ex) {
			System.out.println("Error: failed to add bank account.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}

	@Override
	public BankAccount getAccount(String username) {
		BankAccount account = null;
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from account where account_id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int accountNumber = rs.getInt("account_number");
				double accountBalance = rs.getDouble("balance");
				String accountType = rs.getString("account_type");
				String accountStatus = rs.getString("status");
	
				if (accountType.equals("Checking")) {
					account = new Checking(accountNumber, accountBalance, accountStatus);
				} else {
					account = new Savings(accountNumber, accountBalance, accountStatus);
				}
			}
			
		} catch(SQLException ex) {
			System.out.println("Error: Failed to obtain account.");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return account;
	}

	@Override
	public List<BankAccount> getAllAccounts() {
		List<BankAccount> accounts = new ArrayList<>();
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from account;";
			statement = connection.prepareStatement(sql);
		
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int accountNumber = rs.getInt("account_number");
				double accountBalance = rs.getDouble("balance");
				String accountType = rs.getString("account_type");
				String accountStatus = rs.getString("status");
				
				if (accountType.equals("Checking")) {
					accounts.add(new Checking(accountNumber, accountBalance, accountStatus));
				} else {
					accounts.add(new Savings(accountNumber, accountBalance, accountStatus));
				}
			}
			
		} catch(SQLException ex) {
			System.out.println("Error: Failed to obtain all accounts.");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return accounts;
	}

	@Override
	public BankAccount getAccountsofUser(String username) {
		BankAccount account = null;
		
		try {
			connection = DAOUtility.getConnection();
			String sql = "select * from animals where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int accountNumber = rs.getInt("account_number");
				double accountBalance = rs.getDouble("balance");
				String accountType = rs.getString("account_type");
				String accountStatus = rs.getString("status");
				
				if (accountType.equals("Checking")) {
					account = new Checking(accountNumber, accountBalance, accountStatus);
				} else {
					account = new Savings(accountNumber, accountBalance, accountStatus);
				}
			}
			
		} catch(SQLException ex) {
			System.out.println("Error: Failed to obtain user of account.");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return account;
	}

	@Override
	public boolean updateAccountInfo(String text, String value) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update account set status = ? where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, value);
			statement.setString(2, text);
			return statement.executeUpdate() != 0;
		} catch(SQLException ex) {
			System.out.println("Error: Failed to obtain requested account.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}

	@Override
	public boolean removeAccount(String text) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "delete from account where account_id = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, text);
			return statement.executeUpdate() != 0;
		} catch(SQLException ex) {
			System.out.println("Error: Failed to obtain requested account.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	public void closeResources() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (statement != null && !statement.isClosed()) {
				statement.close();
			}
			
		} catch(SQLException ex) {
			System.out.println("Error: could not close resources.");
			ex.printStackTrace();
		}
	}

}