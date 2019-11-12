import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
 * 
 * @author Robbie Gill
 * CS-221 Matthew Thomas Section 002
 */
public class IUSingleLinkedList<T> implements IndexedUnsortedList<T> {

	private SLLNode<T> head; // point to the first node
	private SLLNode<T> tail; // points to the last node
	private int count; // counts the number of nodes in the linkedList
	private int modCount; // number of modifications that have been made to the linked list.

	public IUSingleLinkedList() {

		head = null;
		tail = null;
		count = 0;
		modCount = 0;

	}

	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element
	 *            the element to be added to the front of this list
	 */
	@Override
	public void addToFront(T element) {
		SLLNode<T> newElementNode = new SLLNode(element);
		if (isEmpty() == true) {
			this.head = newElementNode;
			this.tail = newElementNode;
		} else {
			newElementNode.setNext(head);
			head = newElementNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of this list
	 */
	@Override
	public void addToRear(T element) {
		SLLNode<T> newRearNode = new SLLNode<T>(element);
		if (isEmpty() == true) {
			this.head = newRearNode;
			this.tail = newRearNode;
		} else {
			tail.setNext(newRearNode);
			tail = newRearNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of the list
	 */
	@Override
	public void add(T element) {
		addToRear(element);
	}

	/**
	 * Adds the specified element after the specified target.
	 *
	 * @param element
	 *            the element to be added after the target
	 * @param target
	 *            the target is the item that the element will be added after
	 * @throws NoSuchElementException
	 *             if target element is not in this list
	 */
	@Override
	public void addAfter(T element, T target) {
		int foundIndex = indexOf(target);
		if (foundIndex < 0 || foundIndex > count) {
			throw new NoSuchElementException();
		}
		add(indexOf(target)+1,element);

	}

	/**
	 * Inserts the specified element at the specified index.
	 * 
	 * @param index
	 *            the index into the array to which the element is to be inserted.
	 * @param element
	 *            the element to be inserted into the array
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index > size)
	 */
	@Override
	public void add(int index, T element) {

		if (index < 0 || index > count) {
			throw new IndexOutOfBoundsException();
		}
		else if (index == 0) {
			addToFront(element);
		} else {
			SLLNode<T> current = head;
			for (int currentIndex = 1; currentIndex < index; currentIndex++) {
				current = current.getNext();
			}
			SLLNode<T> newElementNode = new SLLNode<T>(element);
			newElementNode.setNext(current.getNext());
			current.setNext(newElementNode);
			if (current == tail) {
				tail = newElementNode;
			}
			count++;
			modCount++;

		}
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws NoSuchElementException
	 *             if list contains no elements
	 */
	@Override
	public T removeFirst() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		T removedElement = this.head.getElement();
		this.head = this.head.getNext();
		if (count == 1) {
			this.tail = null;
		}
		modCount++;
		count--;
		return removedElement;
	}

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return the last element from this list
	 * @throws NoSuchElementException
	 *             if list contains no elements
	 */
	@Override
	public T removeLast() {
		if (isEmpty() == true) {
			throw new NoSuchElementException();
		}
		T oldTailElement = tail.getElement();
		if (head == tail) {
			head = tail = null;

		} else {

			SLLNode<T> newTail = head;

			while (newTail.getNext() != tail) {
				newTail = newTail.getNext();
			}

			newTail.setNext(null);
			tail = newTail;
		}
		count--;
		modCount++;
		return oldTailElement;

	}

	/**
	 * Removes and returns the first element from the list matching the specified
	 * element.
	 *
	 * @param element
	 *            the element to be removed from the list
	 * @return removed element
	 * @throws NoSuchElementException
	 *             if element is not in this list
	 */
	@Override
	public T remove(T element) {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		boolean found = false;
		SLLNode<T> previous = null;
		SLLNode<T> current = head;

		while (current != null && !found) {
			if (element.equals(current.getElement())) {
				found = true;
			} else {
				previous = current;
				current = current.getNext();
			}
		}

		if (found == false) {
			throw new NoSuchElementException();
		}

		if (size() == 1) { // only node
			return removeFirst();
		} else if (current == head) { // first node
			head = current.getNext();
		} else if (current == tail) { // last node
			return removeLast();
		} else { // somewhere in the middle
			previous.setNext(current.getNext());
		}

		count--;
		modCount++;

		return current.getElement();
	}

	/**
	 * Removes and returns the element at the specified index.
	 *
	 * @param index
	 *            the index of the element to be retrieved
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size)
	 */
	@Override
	public T remove(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}

		if (index == 0) {
			return removeFirst();

		}
		else if (index == count - 1) {
			return removeLast();
		}
		else {
		SLLNode<T> current = head;
		SLLNode<T> toBeRemoved = null;
		SLLNode<T> after = null;
		T removedElement = null;

		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		removedElement = current.getNext().getElement();
		toBeRemoved = current.getNext();
		after = current.getNext().getNext();
		current.setNext(after);
		toBeRemoved.setNext(null);

		count--;
		modCount++;
		return removedElement;
		}
	}

	/**
	 * Replace the element at the specified index with the given element.
	 *
	 * @param index
	 *            the index of the element to replace
	 * @param element
	 *            the replacement element to be set into the list
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size)
	 */
	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		else if(index == 0) {
			head.setElement(element);
			
		}
		else if(index == count-1) {
			tail.setElement(element);
		}
		else {
			SLLNode<T> current = head;
			for(int curIndex =0; curIndex < index; curIndex++) {
				current = current.getNext();
			}
			current.setElement(element);
		}
		
	}

	/**
	 * Returns a reference to the element at the specified index.
	 *
	 * @param index
	 *            the index to which the reference is to be retrieved from
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size)
	 */
	@Override
	public T get(int index) {
		SLLNode<T> retrievedNode = head;
		modCount++;

		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();

		} else {
			for (int i = 1; i <= index; i++) {
				retrievedNode = retrievedNode.getNext();
			}

		}

		return retrievedNode.getElement();
	}

	/**
	 * Returns the index of the first element from the list matching the specified
	 * element.
	 *
	 * @param element
	 *            the element for the index is to be retrieved
	 * @return the integer index for this element or -1 if element is not in the
	 *         list
	 */

	@Override
	public int indexOf(T element) {
		modCount++;
		SLLNode<T> current = head;
		int index;
		for (int i = 0; i < count; i++) {

			if ((element.equals(current.getElement()))) {
				index = i;
				return index;
			}
			current = current.getNext();
		}
		return -1;

	}

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 * @throws NoSuchElementException
	 *             if list contains no elements
	 */
	@Override
	public T first() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		modCount++;
		return head.getElement();

	}

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 * @throws NoSuchElementException
	 *             if list contains no elements
	 */
	@Override
	public T last() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		modCount++;

		return tail.getElement();
	}

	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target
	 *            the target that is being sought in the list
	 * @return true if the list contains this element, else false
	 */
	@Override
	public boolean contains(T target) {
		modCount++;
		SLLNode<T> current = head;
		for (int i = 1; i < count+1; i++) {

			if (current.getElement() == target) {
				return true;
			}
			current = current.getNext();
		}
		return false;

	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		modCount++;
		if (count == 0) {
			return true;

		}
		return false;
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	@Override
	public int size() {
		modCount++;

		return count;
	}

	/**
	 * Returns an Iterator for the elements in this list.
	 *
	 * @return an Iterator over the elements in this list
	 */
	@Override
	public Iterator<T> iterator() {

		return new SLLIterator();

	}

	/**
	 * Returns a ListIterator for the elements in this list.
	 *
	 * @return a ListIterator over the elements in this list
	 *
	 * @throws UnsupportedOperationException
	 *             if not implemented
	 */
	@Override
	public ListIterator<T> listIterator() {
		throw new UnsupportedOperationException();

	}

	/**
	 * Returns a ListIterator for the elements in this list, with the iterator
	 * positioned before the specified index.
	 *
	 * @return a ListIterator over the elements in this list
	 *
	 * @throws UnsupportedOperationException
	 *             if not implemented
	 */
	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		throw new UnsupportedOperationException();
	}

	/** Iterator for IUSingleLinkedList */
	private class SLLIterator implements Iterator<T> {
		private SLLNode<T> nextNode;
		private int iterModCount;
		boolean canRemove;
		private int curIndex;

		/**
		 * Creates a new iterator for the list
		 * 
		 */
		public SLLIterator() {
			nextNode = head;
			iterModCount = modCount;
			canRemove = false;
		}

		/**
		 * 
		 * 
		 */
		@Override
		public boolean hasNext() {
			// TODO
			if (iterModCount != modCount)
				throw new ConcurrentModificationException();
			return (nextNode != null);
		}

		/**
		 * 
		 * 
		 */
		@Override
		public T next() {
			// TODO
			if (!hasNext())
				throw new NoSuchElementException();
			T retVal = nextNode.getElement();
			nextNode = nextNode.getNext();
			canRemove = true;
			curIndex++;
			return retVal;

		}

		/**
		 * 
		 * 
		 */

		@Override
		public void remove() {
			// TODO
			if (iterModCount != modCount)
				throw new ConcurrentModificationException();

			if (!canRemove) {
				throw new IllegalStateException();
			}

			SLLNode<T> previous = null;
			SLLNode<T> current = head;

			for (int i = 0; i < curIndex - 1; i++) {
				previous = current;
				current = current.getNext();
			}

			if (current == head) {
				head = nextNode;
			} else if (current == tail) {
				tail = previous;
				previous.setNext(null);
			} else if (current == head && current == tail) {
				head = tail = null;
			} else {
				previous.setNext(current.getNext());
			}

			curIndex--;
			modCount++;
			count--;
			iterModCount = modCount;
			canRemove = false;

		}
	}

}
