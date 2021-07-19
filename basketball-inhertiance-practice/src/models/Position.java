package models;

public class Position {
	
	public String position;
	private int height;
	private boolean paint;
	private boolean perimeter;
	
	public Position() {
		this("Unknown Position", 79, false, false);
	}
	
	public Position(String string) {
		this("Unknown Position", 79, false, true);
	}
	
	public Position(String string, int i, boolean b, boolean c) {
		System.out.println("Player info revealed!");
		this.position = position;
		this.height = height;
		this.paint = paint;
		this.perimeter = perimeter;
	}

	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean getPaint() {
		return paint;
	}
	public void setPaint(boolean paint) {
		this.paint = paint;
	}
	public boolean getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(boolean perimeter) {
		this.perimeter = perimeter;
	} 
}
