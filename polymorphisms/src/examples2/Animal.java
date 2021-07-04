package examples2;

public class Animal {
	int legs = 4;
	
	public void eat() {
		System.out.println("I eat something");
	}
	
	public static void main(String[] args) {
		Animal A = new Animal();
		Human H =  new Human();
		
		System.out.println("What does the Animal eat?");
		A.eat();
		
		System.out.println("What does the Human eat?");
		H.eat();
		
		
	}
}
