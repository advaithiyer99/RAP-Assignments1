package java8features;

import java.util.ArrayList;

public interface Domesticated {
	ArrayList<String> animals = new ArrayList<>();
	ArrayList<String> plants = new ArrayList<>();
	
	static void register(Domesticated species) {
		if (species instanceof Animal) 
			animals.add(species.getClass().getName());
		else if (species instanceof Plant)
			plants.add(species.getClass().getName());
	}
	
	void doWork();
	
	default void doWork(String job) {
		System.out.println("I " + job);
	}
}
