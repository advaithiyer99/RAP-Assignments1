package examples3;

public class PolymorphismExample {
	
	public static void main(String[] args) {
		
		Animal myAnimal = new Animal();
		Dog myDog = new Dog();
		
		myDog.eat();
		
		System.out.println(myDog.hasFur);
	}
}

class Animal {
	public boolean hasFur = false;
	
	public void eat() {
		System.out.println("I eat food");
	}
}

class Dog extends Animal {
	public boolean hasFur = true;
	
	public void eat() {
		System.out.println("I eat kibble!");
	}	
	public void bark() {
		System.out.println("Woof!");
	}

}