package Interface_Package;

public interface IDeque<T> {
    /**
     * Adds an element to the front of the deque.
     * @param data the element to add
     */
    public void addFirst(T data);
    
    /**
     * Adds an element to the back of the deque.
     * @param data the element to add
     */
    public void addLast(T data);
    
    /**
     * Removes and returns the element at the front of the deque.
     * @return the element at the front of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T removeFirst();
    
    /**
     * Removes and returns the element at the back of the deque.
     * @return the element at the back of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T removeLast();
    
    /**
     * Returns the element at the front of the deque without removing it.
     * @return the element at the front of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public T peekFirst();
    
    /**
     * Returns the element at the back of the deque without removing it.
     * @return the element at the back of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    T peekLast();
    
    /**
     * Returns the number of elements in the deque.
     * @return the number of elements in the deque
     */
    public int size();
    
    /**
     * Returns whether the deque is empty.
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Removes all elements from the deque.
     */
    public void clear();
}

