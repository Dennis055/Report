/**
 * This class sorts an array, using the merge sort algorithm.
 */
public class MergeSort {
	private int[] a;

	/**
	 * Constructs a merge sorter.
	 * 
	 * @param anArray
	 *            the array to sort
	 */
	public MergeSort(int[] anArray) {
		a = anArray;
	}

	/**
	 * Sorts the array managed by this merge sorter.
	 */
	public void sort() {
		if (a.length <= 1) //divide the partition into minimum 2
			return;
		int[] first = new int[a.length / 2];
		int[] second = new int[a.length - first.length];
		// Copy the first half of a into first, the second half into second
		for (int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		MergeSort firstSorter = new MergeSort(first);
		MergeSort secondSorter = new MergeSort(second);
		firstSorter.sort();
		secondSorter.sort();
		merge(first, second);
	}

	/**
	 * Merges two sorted arrays into the array managed by this merge sorter.
	 * 
	 * @param first
	 *            the first sorted array
	 * @param second
	 *            the second sorted array
	 */
	private void merge(int[] first, int[] second) {
		int iFirst = 0; // Next element to consider in the first array
		//like draw a card , and the card was a variable
		int iSecond = 0; // Next element to consider in the second array
		int j = 0; // Next open position in a

		// we sort the array  a with the index j
		while (iFirst < first.length && iSecond < second.length) { //you can continue drawing 
			if (first[iFirst] < second[iSecond]) {
				a[j] = first[iFirst];
				iFirst++;
			} else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}
		// Note that only one of the two loops below copies entries
		// Copy any remaining entries of the first array
		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++;
			j++;
		}
		// Copy any remaining entries of the second half
		while (iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++;
			j++;
		}
	}
}
