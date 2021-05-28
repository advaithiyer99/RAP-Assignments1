package examples;

public class MethodPractice {
	public static void main(String[] args) {
		// invoke/run/call another method
		// it belongs to the class NOT to objects of the class
		anotherMethod();
		MethodPractice.anotherMethod(); // more explicit 
		
		int myInt = 5;
		
		// need an object to use an instance method
		MethodPractice object = new MethodPractice();
		object.hello();
	}
	
	
	// class-level method - methods called on the class itself
	public static void anotherMethod() { // won't work by itself because it needs main method
		System.out.println("something");
	}
	
	// instance method - requires object of class to be created before it can be called 
	public void hello() {
		System.out.println("hello");
	}
}
