package examples;

public class Dog extends Animal implements Domesticated {
	public void eat() {
		System.out.println("I eat kibble");
	}
	
	public void doWork() {
		System.out.println("I perform a trick!");
	}
}
