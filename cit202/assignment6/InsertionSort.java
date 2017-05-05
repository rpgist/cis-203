import java.util.*;

public class InsertionSort implements Sorter {

    // field
    private int [] a;

    public InsertionSort (int [] a) {
	this.a = a;
    }


     // Rearranges the elements of a into sorted order using
     // the selection Shellsort algorithm.
    public  void sort() {
        int skip = a.length / 2;
	while (skip > 0) {
		for (int i = skip; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			while (j >= skip && a[j - skip] > temp) {
				a[j] = a[j - skip];
				j = j - skip;
			}
			a[j] = temp;
		}
		if (skip == 2) {
			skip = 1;
		} else {
			skip *= (5.0 / 11);
		}
	}
}
