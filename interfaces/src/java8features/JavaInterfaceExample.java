package java8features;

import java.util.ArrayList;

public class JavaInterfaceExample {
	public static void main(String[] args) {
		Domesticated myDog = new Dog();
		Domesticated.register(myDog);
		myDog.doWork();
		myDog.doWork("play fetch!");
		System.out.println("Domesticated animals: " + Domesticated.animals);
	}
}
