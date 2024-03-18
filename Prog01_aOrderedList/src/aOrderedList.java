/**
* <aOrderedList class>
*
* CSC 1351 Programming Project No 1
7
* Section 2
*
* @author <Julianna Mcphail>
* @since <March 17 2024>
*
*/
import java.util.Arrays;
import java.util.NoSuchElementException;

class aOrderedList {

	private static final int SIZEINCREMENTS = 20; //size of increments for increasing ordered list
	private Comparable[] oList; //the ordered list
	private int listSize; //the size of the ordered list
	private int numObjects; //the number of objects in the ordered list
	private int curr = 0;
	
	public aOrderedList() {
		numObjects = 0;
		listSize = SIZEINCREMENTS;
		oList = new Car[SIZEINCREMENTS];
				
		
	}
	/*Constructor that sets sets numObjects to 0, sets listSize to the value of
	SIZEINCREMENTS, and instantiates the array oList to an array of size
	SIZEINCREMENTS
	*/
	
	public void add(Comparable newObject) {
		if(numObjects == oList.length) {
			oList = Arrays.copyOf(oList, listSize + SIZEINCREMENTS); //step 5 increases array
		}
		int i;
		for(i = 0; i < numObjects; i++) {
			if(oList[i].compareTo(newObject) > 0) {
				break;
			}
		}
		System.arraycopy(oList, i, oList, i + 1, numObjects - 1);
		oList[i] = newObject;
		numObjects++;	 
	}

	/*Adds the newCar object to the sorted array in the correct position to maintain sorted
	order.
	*/
	
	public String toString() {
		StringBuilder bb = new StringBuilder("{");
		for(int i = 0; i < numObjects; i++) {
			if(i < numObjects - 1) {
				bb.append(", ");
			}
			Object c = oList[i];
			bb.append("[").append(c.toString()).append("]");
		}
		bb.append("]");
		return bb.toString();

	}
	/*Returns the toString values of the list objects, separated by commas, and delimited
	by brackets (e.g., [Make: Kia, Year: 2007, Price: 4000;]. This method
	calls the toString of the Car objects in the oList array to construct the return value of
	the method.
	*/
	
	public int size() {
		return listSize;
	}
	//Returns the number of elements in this list.
	
	public Comparable get(int index) {
		return get(index);
	}
	//Returns the element at the specified position in this list.
	
	public boolean isEmpty() {
		if(numObjects == 0){
			return true;
		}
		else{
			return false;
		}
	}
	//Returns true if the array is empty and false otherwise.
	
	public void remove(int index) {
		for (int i = index+1; i < numObjects; i++) {
		    oList[i-1] = oList[i];
		}
		listSize--;
	}
	/*Removes the element at the specified position in this list. Remember that elements that
	follow the removed element must “move down” to fill the hole in the array
	*/
	
// part of step 8 
	
	public void reset() {
		curr = 0;
		
	}
	//Resets iterator parameters so that the “next” element is the first element in the array, if any
	
	public Comparable next() {
		if(hasNext()) {
			throw new NoSuchElementException("No more elements");
		}
		return (Comparable)oList[curr++];
	}
	//Returns the next element in the iteration and increments the iterator parameters.
	
	public boolean hasNext() {
		return curr < numObjects;
		
	}
	//Returns true if the iteration has more elements to iterate through
	
	public void remove() {
		if(curr <= 0) {
			throw new IllegalStateException("Unable to remove");
		}
		remove(curr - 1);
		curr--;
		
	}
	//Removes the last element returned by the next() method.
	
	
	
}


