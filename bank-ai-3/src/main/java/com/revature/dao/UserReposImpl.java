package com.revature.dao;

import com.revature.models.User;

import com.revature.models.BankAccount;
import com.revature.models.Customer;

public class UserReposImpl implements UserRepos {

	private UserDao userDao = new UserDaoImpl();
	private BankAccountDao bankaccountDao = new BankAccountDaoImpl();
	
	@Override
	public User getUser(String username) {
		try {
			Customer user = (Customer) userDao.getUser(username);
			BankAccount account = (BankAccount) bankaccountDao.getAccount(username);
			user.setUsername(username);
			account.getAccountNumber();
			return user;
		} catch(ClassCastException ex) {
			System.out.println("Error: user not a customer.");
			ex.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		UserRepos userRepo = new UserReposImpl();
		
		User user = userRepo.getUser("user1");
		
		System.out.println(user);
		
	}

}