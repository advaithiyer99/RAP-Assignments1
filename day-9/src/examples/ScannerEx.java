package examples;

import java.util.Scanner;

public class ScannerEx {
	// the JYM creates three different streams.
	/*
	 * System.out: output stream to the console
	 * 
	 * System.in: takes input from the console
	 *
	 * System.err: output error messages (red text)
	 *
	 *
	 */
	public static void main(String[] args) {
//		System.out.println("hello");
//		System.err.println("This is an error message!");
		
		// take in a afile to read, input from user, string, etc.
		String myString = "Hello there my name is Advaith";
		Scanner scanner = new Scanner(myString);
		
//		while(scanner.hasNext()) {
//			System.out.println(scanner.nextLine());
//		}
		
		scanner = new Scanner(System.in);
		// display something to the user
//		System.out.println("Enter a number: ");
//		int response = scanner.nextInt();
//		System.out.println("User entered: " + response);
		
		System.out.println("Please enter a word or phrase. Enter 'quit' to exit. ");
		
		while (scanner.hasNext()) {
			String current = scanner.nextLine();
			
			System.out.println(current);
			
			// == vs equals: 
			// == <---- comparing string address in memory
			// equals <---- comparing the values within
			// intern <---- changes string object to string literal that is shared in pool
			// current.intern() == "quit"
			if (current.equals("quit")) {
				break;
			}
		}
	}
}
