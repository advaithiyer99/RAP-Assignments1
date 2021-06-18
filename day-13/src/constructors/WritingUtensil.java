package constructors;

public class WritingUtensil {
	private int durability = 100;
	
	// given a default no-args constructor
//	public WritingUtensil(int durability) {
//		this.durability = durability;
//	}

	public WritingUtensil(int durability) {
		this.durability = durability;
	}
	// getters and setters 
	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability; // this necessary to target instance variable
		
	}
	
}
