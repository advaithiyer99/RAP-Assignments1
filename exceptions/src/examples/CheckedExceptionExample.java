package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {

	public static void main(String[] args) {
		
		try {
			openFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void openFile() throws FileNotFoundException {
		new FileInputStream("C:\\DoesNotExist.txt");
	}
	
}
