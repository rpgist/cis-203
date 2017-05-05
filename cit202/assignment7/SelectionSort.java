import java.util.*;

public class SelectionSort implements Sorter {

    // field
    private int [] a;

    // constructor
    public SelectionSort (int [] a) {
	this.a = a;
    }

    // Postcondition: array a is sorted
    public void sort() {
	selectionSort(0);
    }

    // Postcondition: array a is sorted (using selection sort)
    private  void selectionSort(int position) {
	if (position == a.length)
	    return;
	else{
	    int min = findMinPosition(position, position+1);
	    swap (position, min);
	    selectionSort(position+1);
	}
    }

    // Parameter: thisPosition, the position in the array we are selecting for
    // Returns: the position in the array (between thisPosition and a.length-1)
    //          where the smallest value is held
    private int findMinPosition(int thisPosition, int nextPosition) {
        if (nextPosition == a.length)
	    return thisPosition;
	else if( a[nextPosition]<a[thisPosition])
	    return findMinPosition(nextPosition, nextPosition+1);
	else
	    return findMinPosition(thisPosition, nextPosition+1);
    }


    // Parameters: i, j - two positions in array a
    // Postcondition: the values at  a[i] with a[j] have been swapped
    public  void swap(int i, int j) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }
}
