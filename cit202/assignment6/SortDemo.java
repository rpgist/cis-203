import java.util.*;

public class SortDemo {

    public static void main (String [] args) {
        /* Commment out this or the area below
        // read n, this size of the array
        int n = Integer.parseInt(args[0]);
      	int [] a = new int[n];

        // fill a with random values
	for (int i = 0; i <n ; i++) {
	    a[i] = (int) (Math.random() * 100);
	}
	*/

        /* Comment out the 3 lines below, or the area above */
        // This is the array given in the example in your assignment description
	int [] a = {67, 52, 22, 72, 3, 55, 17, 83, 82,
                    33, 71, 43, 42, 44, 82, 72, 39};
 
        // copy array a to b to check that a, when sorted, still has the
        // same values as b (a unsorted)
        int [] b = new int[a.length];
        for (int i=0; i < a.length; i++)
            b[i]  = a[i];

        //         System.out.println(Arrays.toString(a));
        System.out.println("Sort using Shell Sort");
        Sorter sorter = new ShellSort(a);
	sorter.sort();
	//        System.out.println(Arrays.toString(a));
        System.out.println("Sorted? " + sorted(a));
        System.out.println("Same Values? " + sameValues(a, b));
    }

    public static boolean sorted(int [] a) {
        for (int i = 0; i < a.length-1; i++) 
	    if (a[i] > a[i+1])
		return false;
	return true;
    }

    public static boolean sameValues(int [] a, int [] b) {
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        place(a, mapA);
        place(b, mapB);
        return mapA.equals(mapB);
    }

    public static void place(int [] array, Map<Integer, Integer> map) {
        for (int i = 0; i < array.length; i++) 
	    if (map.containsKey(array[i])) 
		map.put(array[i], map.get(array[i])+1);
	    else
		map.put(array[i], 1);

    }
}
