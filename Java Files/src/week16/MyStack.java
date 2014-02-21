package week16;

import week15.AOPSListGeneric;
import week15.LList;

public class MyStack implements AOPSStack {
	private AOPSListGeneric<String> stack = new LList<String> ();

	@Override
	public void push(String s) {
		this.stack.addToFront(s);
		
	}

	@Override
	public String pop() {
		String data = this.stack.get(0);
		
		this.stack.remove(0);
		
		return data;
	}

	@Override
	public String peek() {
		return this.stack.get(0);
	}

	@Override
	public boolean isEmpty() {
		return this.stack.size() == 0;
	}

}
