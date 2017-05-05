import java.util.*;

public class DemoSorts {

    public static void main (String [] args) {

        Random rand = new Random();
        String sortName = args[0];
        int n = Integer.parseInt(args[1]);
    

        // construct an array of random ints
        int [] a = new int[n];
        for (int i = 0; i <n; i++)
	    a[i] = rand.nextInt(10*n);


	System.out.println(Arrays.toString(a));
        System.out.println("Sort using " + sortName + " Sort");
        Sorter sorter;
        if  (sortName.equals("insertion"))
	    sorter = new InsertionSort(a);
        else if (sortName.equals("selection"))
	    sorter = new SelectionSort(a);
        else {
            System.out.println("Incorrect sort name: " + sortName);
            sorter = null;
            System.exit(0);
	}
        sorter.sort();
     
	System.out.println(Arrays.toString(a));

        if (sorted (a))  
	    System.out.println("sorted");
	else
	    System.out.println("NOT sorted");

    }

    public static boolean sorted(int [] a) {
	for (int i =0; i < a.length -1; i++)
	    if (a[i] > a[i+1])
		return false;
        return true;
    }

}
