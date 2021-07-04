package examples2;

public class Human extends Animal {
	int legs = 2; // overriden
	
	public void eat() { // overriden
		System.out.println("I eat whatever I want");
	}
}
