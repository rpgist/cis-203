/*
James Hawkins
CIT 203
Assignment 11
*/
import java.util.*;
public class QuickSort implements Sorter {

    // field
    private int [] a;

    public QuickSort (int [] a) {
	this.a = a;
       
    }


     // Rearranges the elements of a into sorted order using
     // the mergesort algorithm.
     public  void sort() {
        Stack<Pair> stack = new Stack();
        //fill the stack
        Pair temp = new Pair(0, a.length);
        stack.push(temp);
        quickSort(stack,stack.peek().first, stack.peek().n);
     }     
    //Parameters: passed the current stack full of the remaining pairs
    //            passed the first position and the number of values
    //PostCondition: the array is sorted
     public void quickSort(Stack<Pair> stack, int first, int n){
        while(!stack.empty()){
            Pair temp2 = stack.pop();
            int test = partition(temp2.first, temp2.n);
            if(test>1){
                Pair temp3 = new Pair(test,n);
                stack.push(temp3);
            }
        }        
    }
    
    // Parameters: first - first position  in the position (also the pivot)
    //             n - number of values to partition
    // Postcondition: a[first]-a[pivotIndex-1] <= a[pivotIndex] 
    //                a[pivotIndex] < a[pivotIndex+1]-a[first + n]
   private  int partition(int first, int n)  {
       int pivotIndex = first;
       int last = first + n - 1;
       int pivotValue = a[first++];
       while (first <= last) {
	   while (first <= last && a[first] <= pivotValue)
	       first++;
	   while (last >= first && a[last] > pivotValue)
               last--;
           if (first < last) 
	       swap(first, last);
       }
       swap(pivotIndex, last);
       return last;
   }
    //Parameters: takes the two positions as ints
   //Post condition: the two positions are swapped
    public  void swap(int i, int j) {
           int temp = a[i];
           a[i] = a[j];
           a[j] = temp;
    }

}
