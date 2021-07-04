package examples;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListExample {
	public static void main(String[] args) {
		LinkedList<String> list=new LinkedList<String>();
		
		// Adding elements to the linked list
		list.add("Carl");
		list.add("Annie");
		list.add("Lisa");
		
		// Adding on elements to the first position
		list.addFirst("Negan");
		
		// Adding an element to the last position
		list.add("Nick");
		
		// Adding an element to the third position
		list.add(3,"Amie");
		
		// Iterating LinkedList
		Iterator<String> iterator=list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}
