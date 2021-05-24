package examples;

// shortcut for running program: ALT, shift, X + J
public class DataTypes {
	
	// to get default values, must not be locally scoped OR an instance variable
		// any whole number defaults to zero
		static byte myDefaultByte;
		static short myDefaultShort;
		static int myDefaultInt;
		static long MyDefaultLong;
		
		//any decimal number defaults to 0.0
		static float myDefaultFloat;
		static double myDefaultDouble;
		
		//boolean default is false
		static boolean myBoolean; 
	
	// main method shortcut: type main, then press CTRL + space, then hit enter
	public static void main(String[] args) {
		// tyring to print out variables that are static and in global scope
		System.out.println(myDefaultByte);
		
		// other
		boolean myBool; 
		
		
		//initializing the declared variable
		myBool = true;
		//both together
		boolean myNewBool = false; 
		
		// number data types
			//whole number data types
				//byte - 1 byte
				byte myMinByte = -128;
				byte myMaxByte = 127;
				
				//short - 2 bytes
				short myMinShort = -32_768;
				short MyMaxShort = 32_767;
				
				//int - 4 bytes / 32 bit
				int myMinInt = -2_147_483_648;
				int myMaxInt = 2_147_483_647;
				
				//intlong - 8 bytes / 64 bits
				long myMinLong = -9_223_372_036_854_775_808L;
				long myMaxLong = 9_223_372_036_854_775_807L;
				
		// decimal numbers
				
				// float - 4 bytes
				float myFloat = 5.555555555555555555F;
				//System.out.println(myFloat);
				
				// double - 8 bytes
				double myDouble = 5.55555555555555555D; 
				//System.out.println(myDouble);
				
				// also a number data type
					// char - 2 bytes / range is from 0 to 65,535
					char myChar = 'a';
					char myOtherChar = 89;
					//System.out.println(myChar);
					//System.out.println(myOtherChar);
					
				for (char letter = 'a'; letter <= 'z'; letter++) {
					// System.out.println(letter);
				}
			
	}
}
