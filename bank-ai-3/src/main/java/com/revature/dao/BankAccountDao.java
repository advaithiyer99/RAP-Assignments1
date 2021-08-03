package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;

public interface BankAccountDao {
	
	public boolean addAccount(BankAccount account);
	
	public BankAccount getAccount(String username);
	
	public List<BankAccount> getAllAccounts();
	
	public BankAccount getAccountsofUser(String username);
	
	public boolean updateAccountInfo(String text, String value);
	
	public boolean updateAccountInfo(String text, double accountBalance);
	
	public boolean removeAccount(String text);
}