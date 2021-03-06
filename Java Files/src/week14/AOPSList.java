package week14;

public interface AOPSList {
    public void addToFront(String x); // puts x on the front of the list
    public void addToBack(String x); // puts x on the back
    public void insert(String x, int position); // put x into the given position
    public void replace(String x, int position); // replace given position with x
    public String get(int position); // return element in given position
    public int size(); // how many elements are in the list
    public boolean isEmpty(); // are there elements in the list
    public boolean contains(String x); // is x in the list?
    public void remove(int position); // delete the element at given position
    public int index(String x); // returns first position of x in the list, -1 if not there
}