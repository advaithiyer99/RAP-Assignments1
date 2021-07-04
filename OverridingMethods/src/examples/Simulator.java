package examples;

public class Simulator {

	public static void main(String[] args) {
		A a = new A();
		a.talk();
		
		B b = new B();
		b.talk();
		
		A ab = new B();
		ab.talk();
	}
}
