import java.util.*;

public class InsertionSort implements Sorter {

    // field
    private int [] a;

    public InsertionSort (int [] a) {
	this.a = a;
    }


    // Postcondition: array a is sorted
    public void sort() {
	insertionSort(0);
    }


    // Postcondition: array a is sorted (using insertion sort)
    private  void insertionSort(int position) {
	if (position == a.length)
	    return;
	else{
	    int temp = a[position];
	    int correctPosition = findPosition(temp, position);
            insertionSort(position+1);
	}
    }
    
    // Parameters: value - to insert
    //             currentPosition - the current position of 'value' in the array
    //                  
    // Returns: position to insert 'value' in the array
    // Postcondition: everything from a[pos] down to a[return value]  has been
    //                shifted one position to the right in array a.
    private int findPosition (int value, int currentPosition){
	if (currentPosition == 0)
	    return currentPosition;
	else if( a[currentPosition -1] <= value)
	    return currentPosition;
	else{
	    int temp2;
	    temp2 = a[currentPosition-1];
	    a[currentPosition-1]= a[currentPosition];
	    a[currentPosition]=temp2;
	    return findPosition(value, currentPosition-1);
	}
    }
}
