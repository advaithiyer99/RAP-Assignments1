package examples;

public class Animal {
	String name;
	
	public void eat() {
		System.out.println("I eat something");
	}
	
	public static void main(String[] args) {
		Animal A = new Animal();
		Dog D = new Dog();
		
		System.out.println("Animal eats something: ");
		A.eat();
		
		System.out.println("Dog eats something: ");
		D.eat();
		
		System.out.println("Dog makes a noise: ");
		D.bark();
		
	}
}
