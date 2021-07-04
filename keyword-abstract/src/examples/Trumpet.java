package examples;

public class Trumpet extends Instrument{

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		System.out.println("Brumm brumm");
	}
	
	public static void main(String[] args) {
		Trumpet trumpet  = new Trumpet();
		trumpet.makeSound();
	}

}
