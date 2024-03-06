package Interface_Package;

public interface IList<T> {
    
    // Adds a new entry to the end of this list.
    public void add(T element);
    
    // Adds a new entry at a specified position within this list.
    public void add(int newPosition, T element);
    
    // Removes the first occurrence of the specified element from this list, if it is present.
    public T remove(T element);
    
    // Removes the entry at the specified position from this list.
    public T remove(int position);
    
    // Replaces the entry at the specified position in this list with the specified element.
    public boolean replace(int position, T element);
    
    // Retrieves the entry at the specified position in this list.
    public T get(int position);
    
    // Detects whether this list contains the specified element.
    public boolean contains(T element);
    
    // Gets the number of entries in this list.
    public int getLength();
    
    // Sees whether this list is empty.
    public boolean isEmpty();
    
    // Returns an array of all entries in this list.
    public T[] toArray();
}

