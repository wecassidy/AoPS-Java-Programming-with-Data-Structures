package week13;

public class AList<E> implements AOPSListGeneric<E> {
    private Object [] array; // to store the elements
    private int capacity; // number of spots for elements in the array
    private int size; // number of elements actually stored
    
    /**
     * Constructor
     * Sets an empty list of capacity 10
     */
    public AList()
    {
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
    private void resize()
    {
        Object [] newArray = new Object[2*this.capacity];
        for (int i = 0; i < this.size; i++)
            newArray[i] = this.array[i]; // copy elements to new list
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
            this.array[i+1] = this.array[i];
        this.array[position] = x; // place element in position
        this.size++; // adjust size
    }

    @Override
    /**
     * Change element in the list
     * x new element to put in
     * position place to replace
     */
    public void replace(E x, int position) {
        if (position >= 0 && position <= this.size - 1) // check if valid
            this.array[position] = x; // overwrite spot in array
    }

    @Override
    /**
     * Determine element at particular position
     * Return "ERROR" if position is invalid
     */
    public E get(int position) throws NoSuchListElementException {
        if (position >= 0 && position <= this.size - 1) // check for valid
            return (E) this.array[position]; // return array element
        else
           throw new NoSuchListElementException();
    }
    @Override
    /**
     * Get the number of elements in the list
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * Return true if and only if no elements are in the list
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    /**
     * Return true if and only if x occurs in the list
     */
    public boolean contains(E x) {
        return this.index(x) != -1; // determine if index in the list is not -1
    }

    @Override
    /**
     * Remove element at given position
     */
    public void remove(int position) {
        if (position<0 || position>=this.size) // check for invalid position
            return;
        for (int i=position+1; i < this.size; i++) // shift everything after 1 space forward
            this.array[i-1] = this.array[i];
        this.size--; // adjust size
    }

    @Override
    /**
     * Find index of x
     * Return -1 if not present, position number if present
     */
    public int index(E x) {
        for (int pos = 0; pos < this.size; pos++) // loop through array
            if (x.equals(this.array[pos])) // if we find it, return the position
                return pos;
        return -1; // -1 if we get through the loop without finding it
    }
    /**
     * Return a E representation of the entire list
     */
    public String toString()
    {
        String answer = "["; // open bracket
        for (int i=0; i < this.size-1; i++)
            answer += this.array[i]+", "; // all elements but last followed by commas
        if (this.size>0) // if at least one element, follow last one by ]
            answer += this.array[this.size-1] + "]";
        else
            answer += "]"; // immediate close bracket if no elements ([])
        return answer;
    }
         
}


