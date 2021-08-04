package com.revature.dao;

import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.revature.models.BankAccount;
import com.revature.models.Savings;
import com.revature.models.Checking;
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
			String sql = "select * from account where username = ?;"; 
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet rs1 = statement.executeQuery();
			
			while (rs1.next()) {
				int accountNumber = rs1.getInt("account_id");
				double accountBalance = rs1.getDouble("balance");
				String accountType = rs1.getString("account_type");
				String accountStatus = rs1.getString("status");
				
				System.out.println(accountNumber);
				
				if (accountType.equals("Checking")) {
					account = new Checking(accountNumber, accountBalance, accountStatus, accountType);
				} else {
					account = new Savings(accountNumber, accountBalance, accountStatus, accountType);
				}
			}
			
			String sql2 = "select * from transactions where username = ?;";
			statement = connection.prepareStatement(sql2);
			statement.setString(1, username);
			ResultSet rs2 = statement.executeQuery();
			
			while (rs2.next()) {
				double startingBalance = rs2.getDouble("starting_balance");
				double deposit = rs2.getDouble("deposit");
				double withdraw = rs2.getDouble("withdrawn");

					account.setStartingBalance(startingBalance);
					account.setDeposit(deposit);
					account.setWithdraw(withdraw);
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
				int accountNumber = rs.getInt("account_id");
				double accountBalance = rs.getDouble("balance");
				String accountType = rs.getString("account_type");
				String accountStatus = rs.getString("status");
				
				if (accountType.equals("Checking")) {
					accounts.add(new Checking(accountNumber, accountBalance, accountStatus, accountType));
				} else {
					accounts.add(new Savings(accountNumber, accountBalance, accountStatus, accountType));
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
	public boolean makeDeposit(String username, double startingBalance, double deposit, double accountBalance) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update transactions set deposit = ?, starting_balance = ?, balance = ? where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, deposit);
			statement.setDouble(2, startingBalance);
			statement.setDouble(3, deposit + startingBalance);
			statement.setString(4, username);
			System.out.println("You just deposited " + deposit + " dollars!");
			return statement.executeUpdate() != 0;
		}
		 catch(SQLException ex) {
			System.out.println("Error: Failed to deposit.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	@Override
	public boolean makeWithdrawal(String username, double startingBalance, double withdraw, double accountBalance) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update transactions set withdrawn = ?, starting_balance = ?, balance = ? where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, withdraw);
			statement.setDouble(2, startingBalance);
			statement.setDouble(3, startingBalance - withdraw);
			statement.setString(4, username);
			System.out.println("You just withdrew " + withdraw + " dollars!");
			return statement.executeUpdate() != 0;
		} catch(SQLException ex) {
			System.out.println("Error: Failed to update account info.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
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
			System.out.println("Error: Failed to update account info.");
			ex.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	@Override
	public boolean updateAccountInfo(String text, double accountBalance) {
		try {
			connection = DAOUtility.getConnection();
			String sql = "update account set balance = ? where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1, accountBalance);
			statement.setString(2, text);
			return statement.executeUpdate() != 0;
		} catch(SQLException ex) {
			System.out.println("Error: Failed to update account info.");
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
			String sql = "delete from customer where username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, text);
			return statement.executeUpdate() != 0;
		} catch(SQLException ex) {
			System.out.println("Error: Failed to remove requested account.");
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