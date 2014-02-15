package week15;

public interface AOPSListGeneric<E> {
    public void addToFront(E x); // puts x on the front of the list
    public void addToBack(E x); // puts x on the back
    public void insert(E x, int index); // put x into the given index
    public void replace(E x, int index); // replace given index with x
    public E get(int index); // return element in given index
    public int size(); // how many elements are in the list
    public boolean isEmpty(); // are there elements in the list
    public boolean contains(E x); // is x in the list?
    public void remove(int index); // delete the element at given index
    public int index(E x); // returns first index of x in the list, -1 if not there
}