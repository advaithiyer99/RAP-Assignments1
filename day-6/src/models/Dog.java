package models;

public class Dog {
	// state fields, properties
	// created using variables
	public String name = "Chester";
	public double weight = 20.00;
	public String breed = "Husky";
	public int age = 1;
	public Collar collar = new Collar();
	
	//constructors
	public Dog() {}
	
//	// shadowing
//	public Dog(String name) {
//		name = name;
//	}
	
	public Dog(String name) {
		this.name = name;
	}
	
	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public Dog(double weight, String name) {
		this.name = name;
		this.weight = weight;
	}
	
	// behavior:
	// created using methods
	public void bark() {
		System.out.println("woof!");
	}
	
	public void grow(int age) {
		this.age = age;
	}
	
}
