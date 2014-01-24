package week13;

public interface AOPSList {

	public void addToFront(String item);
	
	public void addToBack(String item);
	
	public void insert(String item, int index);
	
	public void replace(String item, int index);
	
	public String get(int index);	
	
	public int size();
	
	public boolean isEmpty();
	
	public boolean contains(String item);
	
	public void remove(int index);
	
	public int index(String item);
	
}
