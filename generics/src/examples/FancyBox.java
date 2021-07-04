package examples;

public class FancyBox <T> {

	private T contents;
	
	public FancyBox() {}
	
	public FancyBox(T in) {
		this.contents = in;
	}
	
	public void put(T in) {
		this.contents = in;
	}
	
	public T get() {
		return contents;
	}
		
}
