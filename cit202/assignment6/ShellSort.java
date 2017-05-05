import java.util.*;

public class ShellSort implements Sorter {

    // field
    private int [] a;

    public ShellSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the selection sort algorithm.
    public  void sort() {
	int skip = a.length;
	   if (skip ==0)
	      sort(skip);
	   skip =sort(skip/2);
	}
    }
    
    // Parameters: value - to insert
    //             pos - the current position of the above 'value' in the array
    // Returns: position to insert value in the first 'pos' sorted values
    // Postcondition: Sorted values in postions 0-(pos-1) that are greater
    //                than 'value' have been shifted one place to the right
    //                to make room for insertion of 'value' at the first
    //                position 'i+1' where a[i] <= 'value' and 
    //                1 <= 'i+1' <= pos, or, all values shifted, one to right
    //                from pos-1 down to 0 to allow value to be inserted at 0
    public int sort (int skip){
        for(int i= 0; i <a.length; i ++){
	    int temp = a[i];
	    if(a[i] > a[i+skip]){
		a[i]=a[i+skip];
		a[i+skip]=temp;
	    }
	}
	return skip;
    }
}