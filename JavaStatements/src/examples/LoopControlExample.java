package examples;

public class LoopControlExample {
	public static void main(String[] args) {
		
		int count = 0;
		while (count <= 10) {
			count++;
			
			if (count == 9) {
				break;
			} 
			
			if (count % 2 == 0) {
				continue;
			} 
			
			else {
				System.out.println(count);
			}
			
			System.out.println("We have exited the loop");
		}
	}
}
