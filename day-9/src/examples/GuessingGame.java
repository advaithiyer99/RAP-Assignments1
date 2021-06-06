package examples;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	/*
	 * Guessing game 
	 *  - generate random number and allow user to keep
	 * 		guessing until they guess that number.
	 */
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		// create scanner object
		
		// generate random number
		Random randomNumber = new Random();
		// target is between 1 and 10
		int target = randomNumber.nextInt(10) + 1;
		// get user's guess
		
		// compare user's guess to number
			// if guess is greater than number, tell user
			// if guess is less than number, tell user
			// if guess is correct, tell user and quit
		int guess;
		
		do {
			// prompt user to enter a guess
			guess = prompt("Enter a number between 1 and 10: ");
			
			// if guess is greater than number, tell user
			if (guess > target) {
				System.out.println("Too high!");
			}
			// if guess is less than number, tell user
			else if(guess < target) {
				System.out.println("Too low!");
			}
			// if guess is correct, tell user and quit
			else {
				System.out.println("You got it!");
			}
		} while (guess != target); 
	}
	
	private static int prompt(String instruction) {
		System.out.println(instruction);
		return scanner.nextInt();
	}
	
}
