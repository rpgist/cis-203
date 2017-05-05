/*
James Hawkins
CIT 203
Assignment 11
*/

import java.util.*;

// File: Mergesort.java
// A Java application to illustrate the use of a merge sort
// Additional javadoc documentation is available at:
//   http://www.cs.colorado.edu/~main/docs/Mergesort.html
// MODIFIED: S. Haller 11/19/07
public class MergeSort   implements Sorter {

   // Private data members
   private int [] a;   


   // Constructor
    public MergeSort (int [] data) {
       a = data;
    }

    public void sort ()  {
	mergesort(0, a.length);
    }


   // Sort an array of elements from smallest to largest, using a merge sort
   // algorithm.
   // 
   // Parameters:
   //   first -   start index for the portion of the array that will be sorted
   //   n -  the number of elements to sort
   // Precondition:
   //   a[first] through a[first+n-1] are valid  parts of the array.
   // Postcondition:
   //   If n is one, zero or negative then no work is done. Otherwise, 
   //   the elements of data have been rearranged so that 
   //   a[first] <= a[first+1] <= ... <= a[first+n-1].
   private  void mergesort(int first, int n)  {
       if (n <= 1)
	   return;
       //makes a stack
       Stack<Pair> stack = new Stack();
       // fill the stack
       for(int i =1;i<n;i++){
           Pair temp =new Pair(0,(a.length/i));
           stack.push(temp);           
       }
       //check if it only has 1 item
       while(!stack.empty()){
            if(stack.peek().n==1){
                Pair temp2 = stack.pop();
                if(temp2.n == stack.peek().n){
                    temp2.first++;
                    stack.push(temp2);
                }
                Pair temp3 = stack.pop();
                if(temp3.first == (stack.peek().first))
                    stack.push(temp3);
            }
            Pair temp4 = stack.pop();
            merge(0,1,1);
            if(temp4.n == (stack.peek().n)/2){
                temp4.first =temp4.n;
                temp4.n= stack.peek().n/2+1;
            }
            while(temp4.n != 1){
                temp4.n=temp4.n/2;
                stack.push(temp4);
            }
       }
    }
   // Merge the sorted halves
   // Precondition: data has at least n1 + n2 components starting at
   //    a[first]. The first  n1 elements (from a[first] to 
   //    a[first + n1 - 1] are sorted from smallest 
   //    to largest, and the last n2 (from a[first + n1] to 
   //    a[first + n1 + n2 - 1]) are also sorted from smallest to largest. 
   // Postcondition: Starting at a[first], n1 + n2 elements of data
   //    have been rearranged to be sorted from smallest to largest.
   private  void merge(int first, int n1, int n2)  {

      Integer[] temp = new Integer[n1+n2];

      // Number copied to temp
      int copied = 0;
      // Number copied from the first half of a 
      int copied1 = 0;
      // Number copied from the second half of a
      int copied2 = 0; 

      // Merge elements, copying from two halves of a to the
      // temporary array.
      while ((copied1 < n1) && (copied2 < n2))      {
	  if (a[first + copied1] <a[first + n1 + copied2]) { 
              temp[copied] = a[first + copied1];
              copied++;
              copied1++;
	  }
          else {
            temp[copied] = a[first + n1 + copied2];
	    copied++;
	    copied2++;
	  }
      }

      // Copy any remaining entries in the left and right subarrays.
      while (copied1 < n1) {
         temp[copied] = a[first + copied1];
	 copied++;
	 copied1++;
      }

      while (copied2 < n2) {
         temp[copied] = a[first + n1 + copied2];
	 copied++;
	 copied2++;
      }


      // Copy from temp back to the real array.
      for (int i = 0; i < n1+n2; i++) {
         a[first + i] = temp[i];
      }
   }
   
}


