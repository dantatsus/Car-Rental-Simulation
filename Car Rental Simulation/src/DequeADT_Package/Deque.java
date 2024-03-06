package DequeADT_Package;

import java.util.NoSuchElementException;

import Interface_Package.IDeque;

public class Deque<T> implements IDeque<T> {
	
    private Node<T> head;
    private Node<T> tail;
    private int size;
    
    public Deque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public void addFirst(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.setPrev(newNode);
            newNode.setNext(head);
        }
        head = newNode;
        size++;
    }
    
    public void addLast(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
    }
    
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T removedData = head.getData();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            head.setPrev(null);
        }
        size--;
        return removedData;
    }
    
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T removedData = tail.getData();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return removedData;
    }
    
    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return head.getData();
    }
    
    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return tail.getData();
    }
    
    public void clear() {
    	while(!isEmpty()) {
    		removeFirst();
    	}
    }
    
    @SuppressWarnings("hiding")
	private class Node<T> {
    	
        private T data;
        private Node<T> next;
        private Node<T> prev;
        
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        
        public T getData() {
            return data;
        }
        
        public Node<T> getNext() {
            return next;
        }
        
        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        public Node<T> getPrev() {
            return prev;
        }
        
        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }
    }

}
