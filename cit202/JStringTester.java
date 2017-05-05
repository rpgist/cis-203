public class JStringTester {
    public static void main (String [] args) {
        // args is a String array that contains all the words entered AFTER
        // java JStringTester. For example
	//      java JStringTester cow horse goat
        // would result in ars = {"cow", "horse", "goat"}

	// for each word entered
	for (int i =0; i < args.length; i++) {
	    // construct a JString
            JString js = new JString(args[i]);
	    // print the JString
	    System.out.println("Three permutations of \""+ js + "\":");
	    // and print out 3 permutations of each JString
            for (int j = 0; j < 3; j++) 
	        System.out.println("   " + js.permute());
	    System.out.println();
	}

    }
}

