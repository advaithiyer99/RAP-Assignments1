package nestedexamples;

public class ExampleThree {
	public static void main(String[] args) {
		
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {6,7,8,9};
		
//		System.out.println(arr1.length);
		
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; i < arr2.length; j++) {
				System.out.println(arr1[i] * arr2[j]);
				break;
			}
		}
	}
}
