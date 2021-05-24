package examples;

public class Switch {
	
	// not quite a class
		// represents a group of unchanging variables
		// can be accessed with dot notation
	static enum DAY {
		MONDAY,
		TUESDAY,
		WEDNESDAY,
		THURSDAY,
		FRIDAY,
		SATURDAY,
		SUNDAY
		}
	
		// https://docs.oracle.com/javase/tutorial/java/java00/enum.html
	
	public static void main(String[] args) {
		// can support int, char, short, byte, string, and enum
		int int1 = 3;
		
		switch (int1) {
		case 1:
			System.out.println("number is 1");
			break;
		case 2:
			System.out.println("number is 2");
			break;
		case 3:
			System.out.println("number is 3");
			break;
		case 4:
			System.out.println("number is 4");
			break;
		case 5:
			System.out.println("number is 5");
			break;
		default:
			System.out.println("number is not in the range of 1-5");
			break;
		}
		
		DAY myDay = DAY.FRIDAY;
		
		switch (myDay) {
		case MONDAY:
			System.out.println("it is Monday");
			break;
		case TUESDAY:
			System.out.println("it is Tuesday");
			break;
		case WEDNESDAY:
			System.out.println("it is Wednesday");
			break;
		case THURSDAY:
			System.out.println("it is Thursday");
			break;
		case FRIDAY:
			System.out.println("it is Friday");
			break;
		default:
			System.out.println("it's the weekend!");
		}
		
		// when you want to use fallthrough
		switch (myDay) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			System.out.println("it's a weekday!");
			break;
		default:
			System.out.println("it's the weekend!");
			break;
		}
	}
}
