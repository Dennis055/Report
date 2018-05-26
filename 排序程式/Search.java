/**
 * A class for executing linear searches through an array.
 */
public class Search {
	private  int[] a;

	/**
	 * Constructs the LinearSearcher.
	 * 
	 * @param anArray
	 *            an array of integers
	 */
	public Search(int[] anArray) {
		a = anArray;   //constructor 
	}
	/**
	 * Finds a value in an array, using the linear search algorithm.
	 * 
	 * @param v
	 *            the value to search
	 * @return the index at which the value occurs, or -1 if it does not occur in
	 *         the array(out of the array)
	 *         
	 */
	
	public  String  search(int v) {
		String p = " ";
		
		for(int i = 0 ;i < a.length;i++ ) {
			if(a[i]==v) {
				p = p + i + ",";				
			}
	}return p;			
  }
}
