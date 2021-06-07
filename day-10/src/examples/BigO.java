package examples;

public class BigO {
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		
		// O(1): constant time
			// the same number of operations regardless of input
		constant(array);
		
		// O(log n)
			// binary search
		
		// O(n): linear time
			// 
		linear(array);
		
		// O(n log n)
			// merge sort and quick sort (divide and conquer)
		
		//O(n^2)
			// ex) for every item in an array, multiply that item by each item in array
		quadratic(array);
	}
	
	// O(1): constant time
	public static void constant(int[] array) {
		// check if array is null or empty
		if(array != null && array.length > 0) {
			System.out.println(array[0]);
		}
	}
	
	// O(n): linear
	public static void linear(int[] array) {
		for (int element : array) { // one loop is a linear time operation
			System.out.println(element); // constant time operation
		}
		
		System.out.println("something else"); // constant time operation
		
	}
	
	// a solution for searching an unsorted array
	// O(n)
	public static int simpleSearch (int[] array, int value) {
		for (int index = 0; index < array.length; index++) {
			if (array[index] == value) {
				return index;
			}
		}
		
		// not found
		return -1;
	}
	
	// O(n^2)
	public static void quadratic(int[] array) {
		// 1, 2, 3
		// 1 * 1
		// 1 * 2
		// 1 * 3
		
		// 2 * 1
		// 2 * 2
		// 2 * 3
		
		// 3 * 1
		// 3 * 2
		// 3 * 3
		for (int outerElement : array) {
			for(int innerElement : array) {
				System.out.print((outerElement * innerElement) + ", ");
			}
			System.out.println("");
		}
	}
	
}
