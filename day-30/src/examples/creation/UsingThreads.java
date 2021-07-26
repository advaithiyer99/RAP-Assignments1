package examples.creation;

public class UsingThreads {
	public static void main(String[] args) {
		Thread t1 = new SimpleThread();
		Thread t2 = new SimpleThread();
		Thread t3 = new Thread( new AnotherThread(20));
		
		System.out.println(t1.getState());
		
		t1.start();
		t2.start();
	}
}
