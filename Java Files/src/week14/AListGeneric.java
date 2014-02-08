package week14;

import java.util.Random;

public class AListGeneric<E> implements AOPSListGeneric<E> {
    private Object[] array; // to store the elements
    private int capacity; // number of spots for elements in the array
    private int size; // number of elements actually stored
    
    /**
     * Constructor
     * Sets an empty list of capacity 10
     */
    public AListGeneric() {
        this.capacity = 10;
        this.array = new Object[this.capacity];
        this.size = 0;
    }
    
    @Override
    /**
     * Puts an element at the beginning of the list
     * x element to insert
     */
    public void addToFront(E x) {
        this.insert(x, 0); // add element to position 0
    }
    
    @Override
    /**
     * Puts an element at the end of the list
     * x element to insert
     */
    public void addToBack(E x) {
        this.insert(x,  this.size); // add element at open last position
    }
    
    /**
     * Doubles capacity of the list
     */
    private void resize() {
        Object[] newArray = new Object[2*this.capacity];
        for (int i = 0; i < this.size; i++)
            newArray[ i ] = this.array[ i ]; // copy elements to new list
        this.array = newArray; // make array the new list
        this.capacity *= 2;        
    }
    
    @Override
    /**
     * Add an element somewhere in the list
     * x element to insert
     * position place where element will end up
     */
    public void insert(E x, int position) {
        if (position < 0 || position > this.size) // verify position is valid
            return;
        if (this.capacity == this.size) // resize if array is currently full
            this.resize();
        for (int i=this.size-1; i >= position; i--) // shift elements after position down 1 spot
            this.array[i+1] = this.array[ i ];
        this.array[position] = x; // place element in position
        this.size++; // adjust size
    }
    
	@Override
	public void replace(E x, int position) {
        if (position >= 0 && position <= this.size - 1)
            this.array[position] = x;
    }
	
	@Override
	public E get(int position) throws NoSuchListElementException {
		if (position >= 0 && position <= this.size - 1) {
			return (E) this.array[position];
		}
		
		else {
			throw new NoSuchListElementException();
		}
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public boolean contains(E x) {
		return this.index(x) != -1;
	}
	
	@Override
	public void remove(int position) {
        if (position<0 || position>=this.size)
            return;
        for (int i=position+1; i < this.size; i++)
            this.array[i-1] = this.array[i];
        this.size--;
    }
	
	@Override
	public int index(E x) {
		for (int i = 0; i < this.size; i ++) {
			if (this.array[i].equals(x)) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
        String answer = "[";
        
        for (int i = 0; i < this.size - 1; i ++) {
        	answer += this.array[i] + ", ";
        }
        
        if (this.size > 0) {
        	answer += this.array[this.size - 1] + "]";
        }
        
        else {
        	answer += "]";
        }
        
        return answer;
    }
	
	public AOPSListGeneric<Integer> getIndices(E element) {
		AOPSListGeneric<Integer> indices = new AListGeneric<Integer> ();
		
		for (int i = 0; i < this.size; i ++) {
			if (this.array[i].equals(element)) {
				indices.addToBack(i);
			}
		}
		
		return indices;
	}
	
	@Override
	public AListGeneric<E> sample(int s) {
		if (s >= this.size || s < 0) { // Check if the of the sample is outside of the range of the list
			throw new BadSampleSizeException(); // If so, throw a BadSampleSizeException
		}
		
		AListGeneric<E> sampleInputs = this.clone(); // Clone this list so that we can remove values from a list of sample inputs without messing with this list
		AListGeneric<E> output = new AListGeneric<E>(); // Create a list to hold the sample
		
		Random rand = new Random(); // Create a Random object to generate random indices
		
		for (int i = 0; i < s; i ++) { // Repeat the loop s times
			try { // Try the block of code, and if an exception is thrown, deal with it in the catch block
				int index = rand.nextInt(sampleInputs.size()); // Get a random index from 0 to (size of the sample input list - 1), inclusive
				
				output.addToBack(sampleInputs.get(index)); // Add the element in the list of sample inputs at the random index to the back of the output array
				
				sampleInputs.remove(index); // Remove the element at index from sampleInputs so that it can't be selected again
			}
			
			catch (NoSuchListElementException e) {} // The catch should never be entered, so we leave it empty
		}
		
		return output; // Return the output list
	}
	
	public AListGeneric<E> clone() {
		AListGeneric<E> newList = new AListGeneric<E>(); // Create a new list that will end up with the same contents as the original list
		
		for (int i = 0; i < this.size; i ++) { // Loop through every element in this list
			newList.addToBack((E) this.array[i]); // Add the element at i in this list to the back of the new list
		}
		
		return newList; // Return the cloned array
	}
	
}

class BadSampleSizeException extends IllegalArgumentException {

	public BadSampleSizeException() {
		super();
	}
	
	public BadSampleSizeException(String mesg) {
		super(mesg);
	}
	
}

/*
(The following assumes that s is valid. If s is invalid, the method runs in constant time because it throws an exception before it loops at all. When I say
that O(___) = O(____), I use = in a very loose sense that is applicable to big-Oh running time analysis and nothing else.)
Let M be the size of this.array and N be equal to s, the input of the sample() method.

Running time of the resize() method:
This method creates a new array and copies the contents of the original array into it, so it runs in O(L) time, where L is the size of the current array.

Running time of the clone() method:
In the clone() method, the for loop repeats M times, and each of the M iterations one of two "versions" of addToBack() is called, the version where the array
isn't resized and the version where it is. The calls to addToBack() which do not resize the array can be ignored because it runs in constant time. Because
the amount of time required to resize increases exponentially within each call (the first call loops 10 times, the second 20, the nth 10 * 2^(n - 1)), we can
ignore all the calls but the last one because 2^n is always far greater than 2^(n - 1) for very large n. That means we need to find some x such that
10 * 2^x > M/10 and take the ceiling. Solving for x in terms of M, we find x = log_2 (M/10), giving us the running time of clone as O(M log_2 (M/10)) = O(M
log (M)).

The for loop repeats N times, and inside it there are calls to addToBack(), nextInt(), and remove(). nextInt() runs in constant time, so it can be ignored.
remove(), in the worst case, repeats M times. Finally, we can find the number of times addToBack() calls clone (and thus runs in non-constant time) using the
same process as described above and get the number of loops is log_2 (N/10). This leaves us with O(N log_2 (N/10)) = O(N log (N)).

Because the two "blocks" of code are independent, we add them, which leaves us with O(N log (N) + M log (M)).
*/
