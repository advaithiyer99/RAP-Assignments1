package BankingSimulator;

import com.revature.models.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserRepos;
import com.revature.dao.UserReposImpl;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simulator {
	
	public static User user = null;
	
	private static final Logger LOG = LogManager.getLogger(Simulator.class);
	
	private static UserDao userDAO = new UserDaoImpl();
	
	private static BankAccountDao bankaccountDAO = new BankAccountDaoImpl();
	
	private static UserRepos userRepos = new UserReposImpl();
	
	private static UserService userService = new UserServiceImpl();
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static boolean appIsRunning = true; 
	
	public static void run() {
		
		LOG.trace("Simulator.run() method is now running.");
		
		while (appIsRunning) {
			
			int option1 = loginScreen();
			
			switch (option1) {
			case 1: user = new Employee("user1", "2222");
					LOG.info("Employee has logged in");
					break;
			case 2: user = new Customer("user1", "1111", "Joe Smith");
					LOG.info("Customer has logged in");
					break;
			case 3: appIsRunning = false;
					displayGoodbyeScreen();
					break;
			default: System.out.println("Input invalid. Please enter a number between 1 and 3.");
					break;
			}
			
			if (user != null && user instanceof Employee) {
				boolean isEmployee = true;
				while (isEmployee) {
					LOG.trace("isEmployee loop is now running");
					int option2 = displayEmployeeMenu();
					
					switch(option2) {
					case 1: // View customer balance
							System.out.println(bankaccountDAO.getAccountsofUser("user1").getAccountBalance());
							break;
					case 2: // Approve account
							System.out.println(userRepos.getUser("user1"));
							System.out.println(bankaccountDAO.addAccount(null));
							break;
					case 3: // Reject Account
							System.out.println(userRepos.getUser("user1"));
							System.out.println(bankaccountDAO.removeAccount(null));
							break;
					case 4: // View transaction log
							System.out.println(); 
							break;
					case 5: // Log Out
							user = null;
							isEmployee = false;
							break;
					case 6: // Quit
							isEmployee = false;
							appIsRunning = false;
							displayGoodbyeScreen();
							break;
					default: System.out.println("Input invalid. Please enter a number between 1 and 6.");
							break;
					}
					
				}
				
				LOG.trace("isEmployee loop has finished");
				
			} 
			// if user is a customer
			else if (user != null && user instanceof Customer) {
				boolean isCustomer = true;
				while (isCustomer) {
					LOG.trace("isCustomer loop is now running");
					int option2 = displayCustomerMenu();
					
					switch(option2) {
					case 1: // View Accounts
							System.out.println(bankaccountDAO.getAccountsofUser("user1"));
							break;
					case 2: // Apply for New Account
							System.out.println(bankaccountDAO.getAccountsofUser("user1"));
							System.out.println(bankaccountDAO.addAccount(null));
							break;
					case 3: // Make Deposit
							bankaccountDAO.getAccount("user1").setDeposit(100.20);
							bankaccountDAO.getAccount("user1").getDeposit();
							break;
					case 4: // Make Withdrawal
							bankaccountDAO.getAccount("user1").setWithdraw(200.20);
							bankaccountDAO.getAccount("user1").getWithdraw();
							break;
					case 5: // Transfer Money
							System.out.println(bankaccountDAO.getAccountsofUser("user1"));;
							break;
					case 6: // Log Out
							user = null;
							isCustomer = false;
							break;
					case 7: // Quit 
							isCustomer = false;
							appIsRunning = false;
							displayGoodbyeScreen();
							break;
					default: System.out.println("Invalid. Please enter a number between 1 and 7.");
							break;
					}
			
				}
				LOG.trace("isCustomer loop has finished");
			}
		}
			
	}
	
	public static void homeScreen() {
		
		System.out.printf("\n------------------------------------\n"
				+ "\nWelcome to The Bank!\n"
				+ "\n------------------------------------\n\n");
		
	}
	
	public static int loginScreen() {
		LOG.trace("loginScreen method is now running");
		
		homeScreen();
		
		System.out.printf("\n1. Employee Login \n"
				+ "\n2. Customer Login \n"
				+ "\n3. Log Out\n\n");
	
		int option = 0;
		
		try {
			String text = scanner.nextLine();
			option = Integer.parseInt(text);
		}catch(Exception ex){
			LOG.info("User entered incorrect input in loginScreen", ex);
		}
		
		return option;
	}
	
	public static int displayEmployeeMenu() {
		LOG.trace("displayEmployeeMenu method is now running");
		
		System.out.printf("\n------------------------------------\n"
				+ "\nEmployee Menu\n"
				+ "\n------------------------------------\n\n");
		
		System.out.printf("1. View customer account balances\n"
				+ "2. Approve Account\n" 
				+ "3. Reject Account\n" 
				+ "4. View Transaction Log\n"
				+ "5. Log Out\n"
				+ "6. Quit\n") ;
		
		int option = 0;
		try {
			String text = scanner.nextLine();
			option = Integer.parseInt(text);
		}catch(Exception ex){
			LOG.info("User entered incorrect input in displayEmployeeMenu", ex);
		}
		return option;
	}
	
	public static int displayCustomerMenu() {
		LOG.trace("displayCustomerMenu method is now running");
		
		System.out.printf("\n------------------------------------\n"
				+ "\nCustomer Menu\n"
				+ "\n------------------------------------\n\n");
		
		System.out.printf("1. View balances of accounts\n"
				+ "2. Apply for New Account\n"
				+ "3. Make Deposit\n"
				+ "4. Make Withdrawal\n"
				+ "5. Transfer Money\n"
				+ "6. Log Out\n"
				+ "7. Quit\n");
		
		int option = 0;
		try {
			String text = scanner.nextLine();
			option = Integer.parseInt(text);
		}catch(Exception ex){
			LOG.info("User entered incorrect input in displayCustomerMenu", ex);
		}
		return option;
	}
	
	public static void displayGoodbyeScreen() {
		LOG.trace("displayGoodbyeMessage method is now running");
		
		System.out.printf("\n\n\n------------------------------------"
				+ "\n\n"
				+ "Thank you for using The Bank!"
				+ "\n\n"
				+ "------------------------------------\n\n\n");
	}
	
}
