package examples;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample2 { // removing elements example
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		
		// Adding elements to the linked list
		list.add("Steve");
		list.add("Carl");
		list.add("Annie");
		list.add("Lisa");
		list.add("Negan");
		list.add("Nick");
		list.add("Amie");
		
		//Removing First element
		// same as list.remove(0);
		
		list.removeFirst();
		
		// Removing last element
		
		list.removeLast();
		
		// Iterating LinkedList
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next() + "");
		}
		
		// removing second element, index starts with 0
		list.remove(1);
		System.out.println("\nAfter removing second element: ");
		
		//Iterating LinkedList again
		Iterator<String> iterator2=list.descendingIterator();
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next() + "");
		}
	}
}
