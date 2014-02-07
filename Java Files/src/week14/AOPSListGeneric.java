package week14;

public interface AOPSListGeneric<E> {

	public void addToFront(E item);
	
	public void addToBack(E item);
	
	public void insert(E item, int index);
	
	public void replace(E item, int index);
	
	public E get(int index) throws NoSuchListElementException;	
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean contains(E item);
	
	public void remove(int index);
	
	public int index(E item);
	
}
