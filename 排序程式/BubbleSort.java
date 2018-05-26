
public class BubbleSort {
	private int[] a;
	public BubbleSort(int[] anArray) {
		a = anArray;
	}
	public void sort() {
		boolean swapped = true; 	
		for (int i = a.length - 1; i > 0 && swapped; i--) {   	//recursive
		swapped = false;
		for (int j = a.length - 1; j >= a.length - i; j--) //push the MAX value to the right 
				if (a[j] < a[j - 1]) {
					swap(j, j - 1);
					swapped = true;
				}
		}

	}
	private void swap(int i, int j) {		//write a swap method to enhance the safeguard of program
		int temp = a[i];  
		a[i] = a[j];
		a[j] = temp;

	}
}
