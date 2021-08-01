package Testing;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.Savings;
import com.revature.dao.UserDao;
import com.revature.dao.BankAccountDao;
import com.revature.models.BankAccount;
import com.revature.models.Checking;

@RunWith(MockitoJUnitRunner.class)
public class BankUnitTesting {
	
	@Mock
	private static UserDao userDAO;
	@Mock
	private static BankAccountDao bankaccountDAO;
	@Mock
	private static Checking account;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("Running once before all tests");
	}
	
	@Before
	public void setUpBeforeEachTest() {
		System.out.println("Running before each test.");
	}
	
	@After
	public void tearDownAfterEachTest() {
		System.out.println("Running after each test.");
	}
	
	@AfterClass
	public static void tearDownAfterClass() {
		System.out.println("Running once after all tests");
	}
	
	@Test
	public void testRetrieveCustomerName() {
		System.out.println("testRetrieveCustomer is now running");
		when(userDAO.getUser(anyString())).thenReturn(new Customer("user1", "1111", "Joe Smith"));
		
		Customer user = (Customer) userDAO.getUser("anything");
		
		String nameExpected = "Joe Smith";
		
		String nameReturned = user.getName();
		
		assertSame(nameExpected, nameReturned);
	}
	
	@Test
	public void testRetrievePIN() {
		System.out.println("testRetrievePIN is now running");
		
		when(userDAO.getUser(anyString())).thenReturn(new Customer("user1", "1111", "Joe Smith"));
		
		Customer user = (Customer) userDAO.getUser("anything");
		
		String PINExpected = "1111";
		
		String PINReturned = user.getPIN();
		
		assertSame(PINExpected, PINReturned);
	}
	
	@Test
	public void testRetrieveUsername() {
		System.out.println("testRetrieveUsername is now running");
		
		when(userDAO.getUser(anyString())).thenReturn(new Customer("user1", "1111", "Joe Smith"));
		
		Customer user = (Customer) userDAO.getUser("anything");
		
		String usernameExpected = "user1";
		
		String usernameReturned = user.getUsername();
		
		assertSame(usernameExpected, usernameReturned);
	}
	
	@Test
	public void testRetrieveWrongUsername() {
		System.out.println("testRetrieveWrongUsername is now running");
		
		when(userDAO.getUser(anyString())).thenReturn(new Customer("user1", "1111", "Joe Smith"));
		
		Customer user = (Customer) userDAO.getUser("anything");
		
		String usernameExpected = "user2";
		
		String usernameReturned = user.getUsername();
		
		assertNotSame(usernameExpected, usernameReturned);
	}
	
	@Test (expected = ClassCastException.class) 
	public void testGetUsernameException() {
		System.out.println("testGetUsernameException is running");
		
		when(userDAO.getUser(anyString())).thenReturn(new Employee("user1", "1212"));

		Customer user = (Customer) userDAO.getUser("anything");

		verify(userDAO).getUser("anything");

		user.getUsername();
	}
	
	@Test
	public void testCheckingAccountNumber () {
		System.out.println("testCheckingAccountNumber is running");
		
		when(bankaccountDAO.getAccount(anyString())).thenReturn(new Checking(1234567898, 1500, "Active"));
		
		BankAccount account = (BankAccount) bankaccountDAO.getAccount("somebody");
		
		int accountNumberExpected = 1234567898;
		
		int accountNumberReturned = account.getAccountNumber();
		
		assertEquals(accountNumberExpected, accountNumberReturned);
	}
	
	@Test 
	public void testSavingsAccountStatus() {
		System.out.println("testSavingsAccountStatus is running");
		
		when(bankaccountDAO.getAccount(anyString())).thenReturn(new Savings(1234567898, 1500, "Active"));

		BankAccount account = (BankAccount) bankaccountDAO.getAccount("somebody");

		verify(bankaccountDAO).getAccount("somebody");

		account.getAccountStatus();
	}
	
	@Test
	public void testSetAccountBalance() {
		System.out.println("testSetAccountBalance is running");
		
		Checking account = new Checking("Checking", 1212121212, "Active", 500, 0, 125.25, 125.25, 374.75);
	
		double resultExpected = 374.75;
		
		double resultRetrieved = account.getAccountBalance();
		
		assertEquals(resultExpected, resultRetrieved, 0.02);
	}
	
	@Test 
	public void testCheckingAccountBalance() {
		System.out.println("testCheckingAccountBalance is running");
		
		Checking account = new Checking("Checking", 1234567898, "active", 100, 2100.56, 0, 2100.56, 2200.56);
		
		double resultExpected = 2200.56;
		
		double resultRetrieved = account.getAccountBalance();
		
		assertEquals(resultExpected, resultRetrieved, 0.02);
	}
	
}
