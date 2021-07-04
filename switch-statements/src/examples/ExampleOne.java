package examples;

public class ExampleOne {
	public static void main(String[] args) {
		int value = 6;
		
		switch(value) {
		case 4:
			System.out.println("Case 4");
		case 5:
			System.out.println("Case 5");
			break;
		case 6:
			System.out.println("Case 6");
			break;
		default:
			System.out.println("Default Case");
		}
	}
}
