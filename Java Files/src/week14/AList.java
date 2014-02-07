package week14;

import java.util.Arrays;

public class AList implements AOPSList {
    private String [] array; // to store the elements
    private int capacity; // number of spots for elements in the array
    private int size; // number of elements actually stored
    
    /**
     * Constructor
     * Sets an empty list of capacity 10
     */
    public AList() {
        this.capacity = 10;
        this.array = new String[this.capacity];
        this.size = 0;
    }
    
    @Override
    /**
     * Puts an element at the beginning of the list
     * x element to insert
     */
    public void addToFront(String x) {
        this.insert(x, 0); // add element to position 0
    }
    
    @Override
    /**
     * Puts an element at the end of the list
     * x element to insert
     */
    public void addToBack(String x) {
        this.insert(x,  this.size); // add element at open last position
    }
    
    /**
     * Doubles capacity of the list
     */
    private void resize() {
        String [] newArray = new String[2*this.capacity];
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
    public void insert(String x, int position) {
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
	public void replace(String x, int position) {
        if (position >= 0 && position <= this.size - 1)
            this.array[position] = x;
    }
	
	@Override
	public String get(int position) {
		if (position >= 0 && position <= this.size - 1) {
			return this.array[position];
		}
		
		else {
			throw new IllegalArgumentException();
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
	public boolean contains(String x) {
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
	public int index(String x) {
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
}