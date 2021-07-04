package nestedexamples;

public class ExampleTwo {
	public static void main(String[] args) {
		int num = 7;
		
		if (num < 10) {
			if (num == 5) {
				System.out.println("My lucky number!");
			} else {
				System.out.println("Close, but not my lucky number");
			}
		} else {
			System.out.println("Not even close");
		}
	}
}
