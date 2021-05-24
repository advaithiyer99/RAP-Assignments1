package examples;

public class Operators {
	public static void main(String[] args) {
		int int1 = 5;
		int int2 = 4;
		int int3 = 12;
		int int4 = 5;
		
		double double1 = 5.0;
		double double2 = 4.0;
		double double3 = 12.0;
		
		String string1 = "5";
		String string3 = "5";
		//string string2 = "five"; 
		//int result = Integer.parseInt(string2); <---- Does not work
		
		//arithmetic operators
		//System.out.println(int1 + int2);
		//System.out.println(int1 + double2);
		//System.out.println(int1 + string1);
		//System.out.println(int1 + result);
		
		//System.out.println(int3 / int1); // integer division only returns whole number
		//System.out.println(double3 / int1); // decimal division returns decimal
		
		// modulus operator
		//System.out.println(int3 % int1); // 5 --> 12, goes into 12 twice, remainder 2 is returned
		
		
		// order of operations
		//System.out.println("my string plus " + 5 + 5);
		//System.out.println(5 + 5 + " plus my string");
		//System.out.println("my string plus " + (5 + 5));
		//System.out.println("my string plus " + 5 * 5);
		
		//conditional operators
//		 <, >, <=, >=, !=, ==
//		System.out.println(int1 == int4);
//		System.out.println(string1 == string3);
		
		// shorthand/compound assignment operators
		// +=, -=, *=, /=, %=
		int int5 = 8;
//		int5 = int5 + 2;
//		System.out.println(int5);
		
		int5 += 2;
//		System.out.println(int5);
		
//		prefix and postfix operators
//		--, -+
		int int6 = 9;
//		System.out.println(++int6); 
		//this is the same as 
//		System.out.println(int6++);
		
		//this
//		System.out.println(int6);
//		int6++;
//		
//		System.out.println(int6);
		
	}
}
