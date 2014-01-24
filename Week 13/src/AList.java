
public class AList implements AOPSList {
	private int capacity;
	private int size;

	private String[] array;

	public AList() {
		this.capacity = 10;
		this.size = 0;

		this.array = new String[this.capacity];
	}

	@Override
	public void addToFront(String item) {
		this.insert(item, 0);
	}

	@Override
	public void addToBack(String item) {
		this.insert(item, this.size);
	}

	@Override
	public void insert(String item, int index) {
		if (index < 0) {
			return;
		}

		if (this.size == this.capacity) {
			this.resize();
		}

		for (int i = this.size; i > index; i --) {
			this.array[i] = this.array[i - 1];
		}

		this.array[index] = item;

		this.size ++;
	}

	private void resize() {
		String[] newArray = new String[this.capacity * 2];

		for (int i = 0; i < this.array.length; i ++) {
			newArray[i] = this.array[i];
		}

		this.array = newArray;
		this.capacity = this.array.length;
	}

	@Override
	public void replace(String item, int index) {
		if (index >= 0 && index <= this.size - 1) {
			this.array[index] = item;
		}

	}

	@Override
	public String get(int index) {
		if (index >= 0 && index <= this.size - 1){
			return this.array[index];
		}
		
		return "ERROR";
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public boolean contains(String item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public int index(String item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		String outStr = "[" + this.array[0];

		for (int i = 1; i < this.size(); i ++) {
			outStr += ", " + this.array[i];
		}

		outStr += "]";

		return outStr;
	}

}
