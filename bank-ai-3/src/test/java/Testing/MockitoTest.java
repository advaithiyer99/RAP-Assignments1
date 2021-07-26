package Testing;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.mock.MockName;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.Customer;

public class MockitoTest {

	@Mock
	private UserDao userDao = new UserDaoImpl();
	
	@BeforeClass
	public static void intialSetup() {
		System.out.println("Run before mock!");
	}
	
	@AfterClass
	public static void finishingSetup() {
		System.out.println("Run after mock test is finished!");
	}
	
	@Test
	public void testgetUser() {
		System.out.println("Run the mock test!");

		when(userDao.getUser(anyString())).thenReturn(new Customer("user1", "111", "Joe Smith"));
		
		Customer user = (Customer) userDao.getUser("user1");
		
//		String incorrectUsername = "";
//		
//		String correctUsername = user.getUsername();

		assertSame(user, "user1");
	}
}
