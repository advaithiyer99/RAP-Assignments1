package BankingSimulator;

import com.revature.models.User;
import com.revature.models.BankAccount;
import com.revature.models.Checking;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.dao.UserDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Simulator {
	
	public static User user = null;
	
	private static final Logger LOG = LogManager.getLogger(Simulator.class);
	
	private static UserDao userDAO = new UserDaoImpl();
	
	private static BankAccountDao bankaccountDAO = new BankAccountDaoImpl();
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static boolean appIsRunning = true; 
	
	public static void run() {
		
		LOG.trace("Simulator.run() method is now running.");
		LOG.debug(String.format("User is: %s and appIsRunning is: %b", user != null ? user.getClass() : null, appIsRunning));
		
		while (appIsRunning) {
			
			int option1 = loginScreen();
			
			switch (option1) {
			case 1: user = new Employee("user1", "1111");
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
			
			LOG.debug(String.format("User is: %s and appIsRunning is: %b", user != null ? user.getClass() : null, appIsRunning));
			if (user != null && user instanceof Employee) {
				boolean isEmployee = true;
				while (isEmployee) {
					LOG.trace("isEmployee loop is now running");
					int option2 = displayEmployeeMenu();
					
					switch(option2) {
					case 1: // View customer balance
							System.out.println(bankaccountDAO.getAllAccounts());
							LOG.info("Account names not converted to String in order to preserve confidentiality");
							break;
					case 2: // Approve account
							bankaccountDAO.getAccount(user.getUsername());
							System.out.println("Account approved for: " + userDAO.getUser(user.getUsername()) + "!");
							break;
					case 3: // Reject Account
							bankaccountDAO.getAccount(user.getUsername());
							bankaccountDAO.removeAccount(user.getUsername());
							System.out.println("Account rejected!");
							break;
					case 4: // View transaction log
							System.out.println(bankaccountDAO.getAccount(user.getUsername()).getDeposit()); 
							System.out.println(bankaccountDAO.getAccount(user.getUsername()).getWithdraw()); 
							break;
					case 5: // Log Out
							user = null;
							isEmployee = false;
							break;
					case 6: // Quit Application
							isEmployee = false;
							appIsRunning = false;
							displayGoodbyeScreen();
							break;
					default: System.out.println("Input invalid. Please enter a number between 1 and 6.");
							break;
					}
					
					LOG.debug(String.format("isEmployee: %b", isEmployee));
					
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
							BankAccount account = bankaccountDAO.getAccount(user.getUsername());
							System.out.println(account);
							break;
					case 2: // Apply for New Account
							System.out.println(bankaccountDAO.addAccount(new Checking(1212112323, 100.00, "Inactive", "Checking")));
							LOG.warn("First parameter needs to be changed after each run due to unique constraint account_id");
							break;
					case 3: // Make Deposit
							BankAccount accountDeposit = bankaccountDAO.getAccount(user.getUsername());
							double startingBalanceD = accountDeposit.getStartingBalance();
							System.out.println(bankaccountDAO.makeDeposit(user.getUsername(), startingBalanceD, 10.00, startingBalanceD + 10.00));
							LOG.info("Enter custom value into third parameter if you want a value other than 10.00");
							LOG.info("The double value in the third parameter should be the same as the double value in the fourth");
							break;
					case 4: // Make Withdrawal
							BankAccount accountWithdraw = bankaccountDAO.getAccount(user.getUsername());
							double startingBalanceW = accountWithdraw.getStartingBalance();
							System.out.println(bankaccountDAO.makeWithdrawal(user.getUsername(), startingBalanceW, 10.00, startingBalanceW - 10.00));
							LOG.info("Enter custom value into third parameter if you want a value other than 10.00");
							LOG.info("The double value in the third parameter should be the same as the double value in the fourth");
							break;
					case 5: // Transfer Money
							double accountbalance1 = bankaccountDAO.getAccount(user.getUsername()).getAccountBalance() + bankaccountDAO.getAccount(user.getUsername()).getDeposit();
							double accountbalance2 = bankaccountDAO.getAccount("user3").getAccountBalance() - bankaccountDAO.getAccount(user.getUsername()).getDeposit();
							System.out.println(accountbalance1);
							System.out.println(accountbalance2);
							LOG.info("Enter any other available account if you wish in the getAccount parameter");
							break;
					case 6: // Log Out
							user = null;
							isCustomer = false;
							break;
					case 7: // Quit Application
							isCustomer = false;
							appIsRunning = false;
							displayGoodbyeScreen();
							break;
					default: System.out.println("Invalid. Please enter a number between 1 and 7.");
							break;
					}
			
					LOG.debug(String.format("isCustomer: %b", isCustomer));
					
				}
				LOG.trace("isCustomer loop has finished");
			}
		}
		LOG.debug(String.format("User is: %s and appIsRunning is: %b", user != null ? user.getClass() : null, appIsRunning));	
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
		
		System.out.printf("1. View customer accounts\n"
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
