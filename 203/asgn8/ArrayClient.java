
import java.util.*;

public class ArrayClient {

    public static void main (String [] args) {
	if (args.length > 0) {
	    String test = args[0];
           if (test.equals("a"))
        	testAddAll();
	   else if (test.equals("c"))
                testContainsAll();
	   else if (test.equals("e"))
                testEquals();
	   else if (test.equals("l"))
                testLastIndexOf();
	   else if (test.equals("r"))
	       testRemove();
	   else if (test.equals("rr"))
               testRemoveRange();
	   else if (test.equals("s"))
	       testSublist();
	   else
               System.out.println("a - addAll\nc - containsAll\n"+
                                  "e - equals\nl - lastIndexOf\n"+
                                  "r - remove\nrr - removeRange\n"+
                                  "s - subList");
	} else {
	   testAddAll();
           testContainsAll();
	   testEquals();
           testLastIndexOf();
	   testRemove();
	   testRemoveRange();
	   testSublist();
	}
                             

	/*
        String test = args[0];
        if (test.equals("c"))
            testCapacity();
	else if (test.equals("t"))
            testTrim();
	else if (test.equals("i"))
            testIntersection();
	else
	    System.out.println("Don't know what to test: "+ test);
	*/
    }

    public static void testAddAll() {
        System.out.println("TESTING addAll(int pos, ArrayList<E> other)");
	ArrayList<Character> a1 = new ArrayList<Character>();
        for (char c = 'a'; c <= 'm'; c++)
            a1.add(c);
        System.out.println("a1 = " + a1);

	ArrayList<Character> a2 = new ArrayList<Character>();
        for (char c = 'A'; c <= 'H'; c++)
            a2.add(c);
        System.out.println("a2 = " + a2);

        System.out.println("After a1.addAll(4,a2)...");
        a1.addAll(4, a2);
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);

        System.out.println("After a1.addAll(10,[])...");
        a1.addAll(10, new ArrayList<Character>());
        System.out.println("a1 = " + a1);
        System.out.println();
    }

    public static void testContainsAll() {
        System.out.println("TESTING containsAll(ArrayList<E> other)");
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        for (int i = 1; i<= 7; i++)
            a1.add(i);
        System.out.println("a1 = " + a1);
        System.out.println("a1.containsAll([]) = " + 
			   a1.containsAll(new ArrayList<Integer>()));
        System.out.println("a1 = " + a1);

        ArrayList<Integer> a2 = new ArrayList<Integer>();
	Random rand = new Random();
	rand.setSeed(13);
        for (int i = 1; i <= 7; i++) 
            if (rand.nextInt(2)== 1)
		a2.add(0, i);
            else
                a2.add(i);
        System.out.println("a2 = " + a2);
        System.out.println("a1.containsAll(a2) = " + 
			   a1.containsAll(a2));
        System.out.println("a2.containsAll(a1) = " + 
			   a2.containsAll(a1));

        a1.add(4000);
        a2.add(3000);
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a1.containsAll(a2) = " + 
			   a1.containsAll(a2));
        System.out.println("a2.containsAll(a1) = " + 
			   a2.containsAll(a1));

        a1.remove(a1.size()-1);
        a2.remove(a2.size()-1);
        a2.remove(a2.size()-1);
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a1.containsAll(a2) = " + 
			   a1.containsAll(a2));
        System.out.println("a2.containsAll(a1) = " + 
			   a2.containsAll(a1));
        System.out.println();
    }


    public static void testEquals() {
        System.out.println("TESTING equals(Object other)");

	ArrayList<Character> a1 = new ArrayList<Character>();
	ArrayList<Character> a2 = new ArrayList<Character>();
        System.out.println("Two empty lists should be equal: " + a1.equals(a2));

        for (char c = 'a'; c <= 'h'; c++)
            a1.add(new Character(c));
        for (char c = 'a'; c <= 'h'; c++)
            a2.add(new Character(c));
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a1.equal(a2): " + a1.equals(a2));
        System.out.println("a2.equal(a1): " + a2.equals(a1));
        System.out.println("a1.equal(a1): " + a1.equals(a1));

        a1.set(1,'X');
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a1.equal(a2): " + a1.equals(a2));
        System.out.println("a2.equal(a1): " + a2.equals(a1));

        a1.set(1,'b');
        a1.add('h');
        System.out.println("a1 = " + a1);
        System.out.println("a2 = " + a2);
        System.out.println("a1.equal(a2): " + a1.equals(a2));
        System.out.println("a2.equal(a1): " + a2.equals(a1));

        ArrayList<String> l1 = new ArrayList<String>();
        l1.add(new String("dog"));
        l1.add(new String("cat"));
        ArrayList<String> l2 = new ArrayList<String>();
        l2.add(new String("dog"));
        l2.add(new String("cat"));
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println("l1.equals(l2): " + l1.equals(l2));

        System.out.print("a1.equals(new Scanner(System.in))?? ");
        try {
	    a1.equals(new Scanner(System.in));
	} catch (ClassCastException e) {
	    System.out.println(e);
	}
        System.out.println();
    }

    public static void testLastIndexOf() {
        System.out.println("TESTING lastIndexOf(Object o)");
        System.out.println("[].lastIndexOf('T') = " + 
			   new ArrayList<Character>().lastIndexOf('T'));
	ArrayList<Character> a = new ArrayList<Character>();
        for (char c = 'a'; c <= 'h'; c++)
	    a.add('a');
        System.out.println("a = " + a);
        System.out.println("a.lastIndexOf(new Character('a')) =  " +
			   a.lastIndexOf(new Character('a')));

        for (char c = 'a'; c <= 'h'; c++)
	    a.add(c);
        a.set(12, 'a');
        System.out.println("a = " + a);
        System.out.println("a.lastIndexOf(new Character('a')) =  " +
			   a.lastIndexOf(new Character('a')));
        System.out.println("a.lastIndexOf(new Character('T')) =  " +
			   a.lastIndexOf(new Character('T')));
        System.out.println();
    }

    public static void testRemove() {
        System.out.println("TESTING remove(Object o)");
        System.out.println("[].remove('T') = " + 
			   new ArrayList<Character>().remove(new Character('T')));
	ArrayList<Character> a = new ArrayList<Character>();
        for (char c = 'a'; c <= 'h'; c++)
	    a.add(c);
        System.out.println("a = " + a);
        System.out.println("a.remove('T') = " + a.remove(new Character('T')));
        System.out.println("a.remove('e') = " + a.remove(new Character('e')));
        System.out.println("a = " + a);
        System.out.println("a.remove('h') = " + a.remove(new Character('h')));
        System.out.println("a = " + a);
        System.out.println();
    }

    public static void testRemoveRange() {
        System.out.println("TESTING removeRange(int from, int to)");
	ArrayList<Character> a = new ArrayList<Character>();
        for (char c = 'a'; c <= 'h'; c++)
	    a.add(c);
        System.out.println("a = " + a);
        a.removeRange(1,1);
        System.out.println("After a.removeRange(1,1) a = " + a);
        a.removeRange(1,2);
        System.out.println("After a.removeRange(1,2) a = " + a);
        a.removeRange(0,7);
        System.out.println("After a.removeRange(0,7) a = " + a);
        System.out.print("a.removeRange(0,0)?? ");
        try {
	    a.removeRange(0,0);
	} catch (IndexOutOfBoundsException e) {
	    System.out.println(e);
	}
        System.out.println();
        
    }        

    public static void testSublist() {
        System.out.println("TESTING sublist(int from, int to)");
	ArrayList<Character> a = new ArrayList<Character>();
        for (char c = 'a'; c <= 'h'; c++)
	    a.add(c);
        System.out.println("a = " + a);
        System.out.println("a.sublist(1,2) a = " + a.sublist(1,2));
        System.out.println("a = " + a);
        System.out.println("a.sublist(0, a.size()) a = " +
			   a.sublist(0,a.size()));
        System.out.println("a.sublist(3, a.size()-1) a = " +
			   a.sublist(3, a.size()-1));
        System.out.print("a.sublist(0,20)?? ");
        try {
	    a.sublist(0,20);
	} catch (IndexOutOfBoundsException e) {
	    System.out.println(e);
	}
        System.out.println();
        
    }        
/*
    //public static void testCapacity() {
      //  System.out.println("TESTING capacity()...");
	//ArrayList<Character> a = new ArrayList<Character>();
        //System.out.println("a.capcity() should be 100 and is " + a.capacity());
        //a = new ArrayList<Character>(27);
        //System.out.println("a.capcity() should be 27 and is " + a.capacity());
    //}

    public static void testTrim() {
        System.out.println("TESTING trim()...");

	ArrayList<Integer> a = new ArrayList<Integer>(100);
        for (int i = 0; i < 100; i++) {
	    a.add(i);
	}
        System.out.println("a.capacity() is " + a.capacity());
        System.out.println("remove(3) to remove(90) one at a time...");
	for (int i = 3; i < 91; i++)
	    a.remove(3);
        System.out.println("a = " + a);
        System.out.println("a.capacity() is " + a.capacity()  + "\n");

	a = new ArrayList<Integer>(100);
        for (int i = 0; i < 100; i++) {
	    a.add(i);
	}
        System.out.println("a.capacity() is " + a.capacity());
        System.out.println("remove Integers 5 to 99 one at a time...");
	for (int i = 5; i <= 99; i++)
	    a.remove(new Integer(i));
        System.out.println("a = " + a);
        System.out.println("a.capacity() is " + a.capacity()  + "\n");

	a = new ArrayList<Integer>(100);
        for (int i = 0; i < 100; i++) {
	    a.add(i);
	}
        System.out.println("a.capacity() is " + a.capacity());
        System.out.println("removeRange(0, 100)...");
	a.removeRange(0, 100);
        System.out.println("a = " + a);
        System.out.println("a.capacity() is " + a.capacity()  + "\n");

	ArrayList<String> words = new ArrayList<String>(10);
        for (int i = 0; i < 10; i++) {
	    words.add("word"+i);
	}
        System.out.println("words = " + words);
        System.out.println("words.capacity() is " + words.capacity());
        System.out.println("removeRange(1,9)...");
	words.removeRange(1,9);
        System.out.println("words = " + words);
        System.out.println("words.capacity() is " + words.capacity()  + "\n");
        System.out.println("removeRange(0,2)...");
	words.removeRange(0,2);
        System.out.println("words = " + words);
        System.out.println("words.capacity() is " + words.capacity()  + "\n");
    }

    public static void testIntersection() {
        System.out.println("TESTING intersection()...");
        Random rand = new Random();
	ArrayList<Integer> a1 = new ArrayList<Integer>(10);
	ArrayList<Integer> a2 = new ArrayList<Integer>(10);
	for (int i = 0; i < 10; i++) {
            a1.add(rand.nextInt(10));
            a2.add(rand.nextInt(10));
	}
	System.out.println("a1 = " + a1);
	System.out.println("a2 = " + a2);
	System.out.println("a1.intersection(a2) = " + a1.intersection(a2));
	System.out.println("a2.intersection(a1) = " + a2.intersection(a1));
	System.out.println("a1.intersection(a1) = " + a1.intersection(a1));
	System.out.println("a2.intersection(a2) = " + a2.intersection(a2));
    }
*/  
}

