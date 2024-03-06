package Interface_Package;

public interface IQueue<T> {
	
	/**
     * Adds the given item to the back of the queue.
     * @param item the item to add to the queue
     */
    public void enqueue(T item);

    /**
     * Retrieves and removes the item at the front of the queue.
     * @return the item at the front of the queue
     * @throws Exception if the queue is empty
     */
    public T dequeue() throws Exception;

    /**
     * Retrieves the item at the front of the queue without removing it.
     * @return the item at the front of the queue
     * @throws Exception if the queue is empty
     */
    public T getFront() throws Exception;

    /**
     * Checks whether the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Removes all items from the queue.
     * @throws Exception if the queue is empty
     */
    public void clear() throws Exception;
	
}
