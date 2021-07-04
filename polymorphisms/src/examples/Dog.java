package examples;

public class Dog extends Animal {
	String name; // Inherited
	String breed;
	
	public void eat() { // Overridden
		System.out.println("I eat kibble!");
	}
	
	public void bark() {
		System.out.println("Woof!");
	}
}
