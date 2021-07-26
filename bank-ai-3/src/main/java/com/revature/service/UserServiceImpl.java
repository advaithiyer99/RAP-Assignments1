package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Customer;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public String getName(String username) {
		
		String name1 = "";
		
		try {
			Customer user = (Customer) userDao.getUser(username);
			name1 = user.getName();
		} catch(ClassCastException ex) {
			System.out.println("Error: user is not a customer; retrieval invalid!");
		}
		return name1;
	}

		
	}
	

