package week18;

public interface AOPSPriorityQueue {
    public void enqueue(int x); // adds x to the queue
    public int dequeue(); // removes and returns the highest priority element
    public int peek(); // returns the highest priority element
    public boolean isEmpty(); // is the priority queue empty?
}
