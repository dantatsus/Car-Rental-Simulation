package QueueADT_Package;

import Interface_Package.IQueue;

public class Queue<T> implements IQueue<T> {
	
	private T[] queue;
	
	private int frontIndex;
	private int backIndex;
	private boolean initialized = false;
	private static final int MAX_CAPACITY = 10000;
	
	public Queue(int capacity) {
		
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[capacity + 1];
		queue = tempQueue;
		
		frontIndex = 0;
		backIndex = capacity;
		initialized = true;
	}
	
	public void enqueue(T item) {
		checkInitialization();
		ensureCapacity();
		backIndex = (backIndex + 1) % queue.length;
		queue[backIndex] = item;
	}
	
	public T getFront() throws Exception {
		checkInitialization();
		return queue[frontIndex];
	}
	
	public T dequeue() throws Exception {
		checkInitialization();
		if(isEmpty())
			throw new Exception("This queue is empty(dequeue method)");
		else {
			T front = queue[frontIndex];
			queue[frontIndex] = null;
			frontIndex = (frontIndex + 1) % queue.length;
			return front;
		}
	}
	
	public boolean isEmpty() {
		return frontIndex == ((backIndex + 1) % queue.length);}
	
	public void clear() throws Exception {
		checkInitialization();
		if(!isEmpty())
			dequeue();
	}
	
	
	// Private methods for Queue Class
	
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY)
			throw new IllegalStateException("");
	}
	
	private void checkInitialization() {
		if(!initialized)
			throw new SecurityException("This Queue object is not initialized properly.");
	}
	
	private void ensureCapacity() {
		
		if (frontIndex == ((backIndex + 2) % queue.length)){ 
			T[] oldQueue = queue;
			int oldSize = oldQueue.length;
			int newSize = 2 * oldSize;
			checkCapacity(newSize - 1);
			
			@SuppressWarnings("unchecked")
			T[] tempQueue = (T[]) new Object[newSize];
			queue = tempQueue;
			for (int index = 0; index < oldSize - 1; index++)
				{
				queue[index] = oldQueue[frontIndex];
				frontIndex = (frontIndex + 1) % oldSize;
				} // end for
			frontIndex = 0;
			backIndex = oldSize - 2;
		}
	}
	
	
}
