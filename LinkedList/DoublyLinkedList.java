package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int n;
	
	private class Node {
		private Item item;
		private Node prev;
		private Node next;
	}
	
	public DoublyLinkedList() {
		first = null;
		last = first;
		n = 0;
	}
	
	public boolean isEmpty() {
		return n == 0;
	}
	
	public int size() {
		return n;
	}
	
	public void insertAtBegining(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		if (isEmpty()) {
			last = first;
			first.next = oldFirst;
		} else {
			first.next = oldFirst;
			oldFirst.prev = first;
		}
		n++;		
	}
	
	public void insertAtEnd(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			last.prev = oldLast;
			oldLast.next = last;
		}
		n++;
	}
	
	public void insertAtIndex(Item item, int index) {
		int count = 0;
		Node current = first;
		if (checkValidation(index)) {
			while (count < index - 1) {
				current = current.next;
				count++;
			}				
		}
		Node insertNode = new Node();
		insertNode.item = item;
		insertNode.next = current.next;
		insertNode.prev = current;
		current.next = insertNode;
		current.next.next.prev = insertNode;
		n++;
	}
	
	public Item removeFromBegining() {
		Item item = first.item;
		first = first.next;
		n--;
		if (isEmpty())
			first = last = null;
		return item;
	}
	
	public Item removeFromEnd() {
		Item item = last.item;
		last = last.prev;
		last.next = null;
		n--;
		if (isEmpty())
			first = last = null;
		return item;
	}
	
	public boolean removeItem(Item item) {
		int count = 0;
		Node current = first;
		while (count < n) {
			if (current.item == item) {
				if (count == 0) {
					removeFromBegining();
					return true;
				} else if (count == n - 1) {
					removeFromEnd();
					return true;
				} else {
					current.prev.next = current.next;
					current.next.prev = current.prev;
					n--;
					return true;
				}
			}
			current = current.next;
			count++;
		}
		return false;
	}
	
	private boolean checkValidation(int index) {
		return index > 1 && index < n - 1;
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
