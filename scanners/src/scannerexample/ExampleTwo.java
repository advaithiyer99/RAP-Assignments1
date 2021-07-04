package scannerexample;

import java.util.Scanner;

public class ExampleTwo {

		public static void main(String[] args) {
			// setup some String data
			String numbers = "1 2 3 4 7 9";
			
			// create scanner over String
			Scanner scanner = new Scanner(numbers);
			
			// iterate over data
			while(scanner.hasNextInt()) {
				System.out.println(scanner.nextInt());
				
				//print a comma if more numbers are available
				if(scanner.hasNext()) {
					System.out.println(",");
				}
			}
			
			// close statement
			scanner.close();
		}
}
