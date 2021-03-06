package week14;

public interface AOPSListGeneric<E> {
    public void addToFront(E x); // puts x on the front of the list
    public void addToBack(E x); // puts x on the back
    public void insert(E x, int position); // put x into the given position
    public void replace(E x, int position); // replace given position with x
    public E get(int position) throws NoSuchListElementException; // return element in given position
    public int size(); // how many elements are in the list
    public boolean isEmpty(); // are there elements in the list
    public boolean contains(E x); // is x in the list?
    public void remove(int position); // delete the element at given position
    public int index(E x); // returns first position of x in the list, -1 if not there
    public AOPSListGeneric<E> sample(int s); // returns a randomly chosen sample of the AOPSListGeneric of size s
}