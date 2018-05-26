
public class QuickSort {
	private int[] a;

	/**
	 * Constructs a bubble sorter.
	 * 
	 * @param anArray
	 *            the array to sort
	 */
	public QuickSort(int[] anArray) {
		a = anArray;
	}

	public void sort(int from, int to) { //recursive
		if (from >= to)
		return;  //if just be implemented in here
		int p = partition(from, to);
		// recursion call sort() for divide
		sort(from, p);
		sort(p+1,to);
	}
	private int partition(int from, int to) {
		int pivot = a[from]; 
		int i = from - 1;
		int j = to + 1;
		while (i < j) {
			// Implement swap logics, call swap()
			i++;
			while(a[i] < pivot)
			i++; //start running
			j--;
			while(a[j] > pivot) 
			j--;
			if(i <j) //normal situation
			swap(i,j);  //set pivot to j
		}
		// return new pivot
		return j;
	}

	private void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	
}
