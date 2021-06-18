package abstraction;

public abstract class WritingTool {
	// fields
	private int usability;
	
	// constructors
	public WritingTool() {
		this.usability = 100;
	}
	
	// methods
	public abstract void write();
	
	// getters and setters 
	public int getUsability() {
		return usability;
	}

	public void setUsability(int usability) {
		this.usability = usability;
	}
	
	
}
