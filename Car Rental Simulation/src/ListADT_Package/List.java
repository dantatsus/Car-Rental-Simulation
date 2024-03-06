package ListADT_Package;

import java.util.Arrays;

import Interface_Package.IList;

public abstract class List<T> implements IList<T> {
	
	protected T[] list;
	protected int numberOfEntries;
	protected boolean initialized = false;
	
	public List() {this(10);}
	
	public List(int size) {
		@SuppressWarnings("unchecked")
		T[] tempList = (T[]) new Object[size + 1];
		list = tempList;
		numberOfEntries = 0;
		initialized = true;
	}
	
	public void add(T element) {
		checkInitialization();
		list[numberOfEntries+1] = element;
		numberOfEntries++;
		ensureCapacity();
	}
	
	public void add(int newPosition, T element) {
		checkInitialization();
		if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
			if (newPosition <= numberOfEntries)
				makeRoom(newPosition);
			list[newPosition] = element;
			numberOfEntries++;
			ensureCapacity();
		}
		else
			throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
	}
	
	private int getIndexOf(T anEntry){
		int where = -1;
		boolean found = false;
		int index = 0; 
		while (!found && (index <= numberOfEntries)){
			if (anEntry.equals(list[index])){
				found = true;
				where = index;
			} 
			index++;
		} 
		return where;
	} 
	
	public T remove(T element) {
		checkInitialization();
		int index = getIndexOf(element);
		T result = remove(index);
		return result;
	}
	
	public T remove(int position) {
		checkInitialization();
		if ((position >= 1) && (position <= numberOfEntries)) {
			assert(!isEmpty());
			T result = list[position];
			if (position < numberOfEntries)
				removeGap(position);
			numberOfEntries--;
			return result;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
	}
	
	public boolean replace (int position, T element) {
		checkInitialization();
		if((position >= 1) && (position <= numberOfEntries)) {
			assert !isEmpty();
			list[position] = element;
			return true;
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
	}
	
	public T get(int position) {
		checkInitialization();
		if((position >= 1) && (position <= numberOfEntries)) {
			assert !isEmpty();
			return list[position];
		}
		else
			throw new IndexOutOfBoundsException("Illegal position given to get operation.");
	}
	
	public boolean contains(T element) {
		checkInitialization();
		boolean found = false;
		int index = 1;
		while(!found && (index <= numberOfEntries)) {
			if (element.equals(list[index]))
				found = true;
			index++;
		}
		return found;
	}
	
	public int getLength() {return numberOfEntries;}
	
	public boolean isEmpty() {return numberOfEntries == 0;}
	
	public T[] toArray(){
		checkInitialization();
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = list[index+1];
		}
		return result;
	}
	
	
	private void removeGap(int position) {
		assert(position >= 1) && (position <= numberOfEntries);
		int removedIndex = position;
		int lastIndex = numberOfEntries;
		for(int index = removedIndex; index < lastIndex; index++) {
			list[index] = list[index + 1];
		}
	}
	
	private void makeRoom(int position) {
		assert(position >= 1) && (position <= numberOfEntries + 1);
		int newIndex = position;
		int lastIndex = numberOfEntries;
		
		for (int index = lastIndex; index >= newIndex; index--) {
			list[index + 1] = list[index];
		}
	}
	
	private void ensureCapacity() {
		int capacity = list.length-1;
		if (numberOfEntries >= capacity) {
			int newCapacity = 2 * capacity;
			list = Arrays.copyOf(list, newCapacity + 1);
		}
	}
	
	private void checkInitialization(){
	 if (!initialized)
	 throw new SecurityException("List object is not initialized properly.");
	}
	
	
}
