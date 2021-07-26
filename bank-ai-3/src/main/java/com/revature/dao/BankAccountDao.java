package com.revature.dao;

import java.util.List;

import com.revature.models.BankAccount;

public interface BankAccountDao {
	
	public boolean addAccount(BankAccount account);
	
	public BankAccount getAccount(String text);
	
	public List<BankAccount> getAllAccounts();
	
	public BankAccount getAccountsofUser(String username);
	
	public boolean updateAccountInfo(String text, String value);
	
	public boolean removeAccount(String text);
}
