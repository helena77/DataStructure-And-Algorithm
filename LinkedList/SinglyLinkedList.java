package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

//singly Linked List
public class SinglyLinkedList<Item> implements Iterable<Item> {	
    private Node last;
    private Node first;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    public SinglyLinkedList() {
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }
    
    public int size() {
    	return n;
    }


    public void insertAtEnd(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty())
        	first = last;
        else 
            oldLast.next = last;
        n++;
    }

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("The queue is empty");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
	
}




