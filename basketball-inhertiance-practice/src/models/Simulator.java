package models;

import java.util.Scanner;

public class Simulator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.println("Enter Player name: ");
		String player = scanner.nextLine();
		System.out.println("Player is named " + player);
	}
}
