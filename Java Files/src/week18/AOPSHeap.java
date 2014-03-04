package week18;

import java.util.LinkedList;
import java.util.List;

public class AOPSHeap implements AOPSPriorityQueue {
    private int [] heap; // array of elements
    private int size; // number of elements
    
    public AOPSHeap() {
        this.heap = new int[32]; // assume max of 32 elements
        this.size = 0;
    }
    
    @Override
    public void enqueue(int x) {
        this.heap[this.size] = x; // put x in last spot
        this.size ++; // fix the this.size
        bubbleUp(); // fix the heap
    }

    private void bubbleUp() {
        int cur = this.size - 1;      // Location of last item added
        int parent = (cur - 1) / 2;  // Parent of the new item

        // We only need to check heaps with more than 1 element
        if (this.size > 1) {
            // Walk up the heap until you reach the top or stop finding
            // values that are out of place
            while (parent >= 0 && this.heap[cur] > this.heap[parent]) {
            // Swap the parent and child values
                int temp = this.heap[cur];
                this.heap[cur] = this.heap[parent];
                this.heap[parent] = temp;

                // Move up one level in the heap
                cur = parent;
                parent = (cur - 1) / 2;
            }
        }
        
    }
    
    @Override
    public int dequeue() {
        int biggest = this.heap[0]; // biggest is at the root
        this.size--; // one less in the heap
        this.heap[0] = this.heap[this.size]; // move last leaf to top
        bubbleDown(); // fix the heap
        return biggest;
    }

    private void bubbleDown() {
        int parent = 0;        // Parent position
        int left;              // Left child
        int right;             // Right child

        int maxPos;            // Position of the largest child
        int maxValue;           // Value of the largest child

        boolean continueScan;  // When true heap is ordered

        // Only need to look if the heap this.size is greater than 1
        if (this.size > 1) {
            do {
                left = parent * 2 + 1;
                right = parent * 2 + 2;

                continueScan = false;

                if (left < this.size) {
                    // I have at least one child

                    if (right < this.size) {
                        // I have two children - figure out which is
                        // the larger
                        if (this.heap[left] > this.heap[right]) {
                            // Left is the bigger
                            maxValue = this.heap[left];
                            maxPos = left;
                        }
                        else {
                            // Right is the largest
                            maxValue = this.heap[right]; 
                            maxPos = right;
                        }

                        // If the parent is smaller than the largest child
                        // swap them and continue scan
                        if (this.heap[parent] < maxValue ) {
                            int temp = this.heap[parent];
                            this.heap[parent] = this.heap[maxPos];
                            this.heap[maxPos] = temp;
                            parent = maxPos;
                            continueScan = true;
                        }
                    }
                    else {
                        // Only one child (must be the larger) - is the
                        // parent smaller than the left child?
                        if (this.heap[parent] < (this.heap[left])) {
                            // Yes - swap them
                            int temp = this.heap[parent];
                            this.heap[parent] = this.heap[left];
                            this.heap[left] = temp;
                            parent = left;
                            continueScan = true;
                        }
                    }
                }
            } while (continueScan);
        }


    }
    
    @Override
    public int peek() {
        return this.heap[0]; // largest is at the top
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0; // no elements in heap
    }
    
    public List<Integer> makeList() {
    	List<Integer> out = new LinkedList<Integer> ();
    	
    	for (int thing : this.heap) {
    		out.add(thing);
    	}
    	
    	return out;
    }
    
    public static void main(String[] args) {
    	AOPSHeap h = new AOPSHeap();
    	
    	for (int x : new int[] {23, 56, 12, 18, 45, 63, 2}) {
    		h.enqueue(x);
    	}
    	
    	System.out.println(h.makeList());
    }

}
