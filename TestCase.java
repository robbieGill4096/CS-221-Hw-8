import java.util.Iterator;
import java.util.ListIterator;
import org.testng.Assert;

/**
 * TestCase class for any implementation of the 
 * IndexedUnsortedList interface. 
 * 
 * @author CS221
 *
 */
public class TestCase
{
		// Elements that can be in the list
		public static final Character A = new Character('A');
		public static final Character B = new Character('B');
		public static final Character C = new Character('C');
		public static final Character D = new Character('D');
		public static final Character E = new Character('E');
		public static final Character F = new Character('F');
		public static final Character G = new Character('G');
		
		// enumeration for state of Iterator
		public enum ItrState { init, next, nextNext, nextRemove, nextNextRemove, nextRemoveNext,
			nextNextNext, nextNextRemoveNext, nextNextNextRemove } 
		// enumeration for state of ListIterator
		public enum ListItrState { init, add, nextAdd, nextPrev, nextNextPrev, nextPrevAdd,
			nextPrevRemove, nextNextAdd, nextNextPrevAdd, nextNextPrevRemove, 
			nextNextNextPrev, nextNextNextPrevAdd, nextNextNextPrevRemove, nextNextNextAdd } 
				
		/**
		 * Constructs new list for testing. 
		 * 
		 * @param listType - String representing list type.  
		 * @return new list of the given type 
		 */
		public static IndexedUnsortedList<Character> newList(String listType)
		{
			IndexedUnsortedList<Character> newList = null;
		
			if(listType.equals("goodList"))
			{
			    newList = new GoodList<Character>();
			}
			else if(listType.equals("arrayList"))
			{
//				newList = new IUArrayList<Character>(); 
			}
			else if(listType.equals("singleLinkedList"))		
			{
			    newList = new IUSingleLinkedList<Character>(); 
			}
			else if(listType.equals("doubleLinkedList"))
			{
//			    newList = new IUDoubleLinkedList<Character>(); 
			}
		
			return newList; 
		}
		
		//****** Test cases for general List methods ************************************
		/**
		 * Tests removeFirst method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - Character object
		 */
		public static void removeFirst(IndexedUnsortedList<Character> list, Character element)
		{
			Character result = list.removeFirst();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests removeLast method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - Character object
		 */
		public static void removeLast(IndexedUnsortedList<Character> list, Character element)
		{
			Character result = list.removeLast();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests remove(element) method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - Character object
		 */
		public static void remove(IndexedUnsortedList<Character> list, Character element)
		{
			Character result = list.remove(element);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests first method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - reference to Character object
		 */
		public static void first(IndexedUnsortedList<Character> list, Character element)
		{
			Character result = list.first();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests last method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - reference to Character object 
		 */
		public static void last(IndexedUnsortedList<Character> list, Character element)
		{
			Character result = list.last();
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests contains method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - reference to Character object 
		 * @param expectedResult - boolean value 
		 */
		public static void contains(IndexedUnsortedList<Character> list, Character element, boolean expectedResult)
		{
			boolean result = list.contains(element);
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests isEmpty method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void isEmpty(IndexedUnsortedList<Character> list, boolean expectedResult)
		{
			boolean result = list.isEmpty();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests size method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param expectedResult - int value 
		 */
		public static void size(IndexedUnsortedList<Character> list, int expectedResult)
		{
			int result = list.size();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests size method
		 * Just checks that result is a String object.
		 * @param list - implementation of IndexedUnsortedList interface
		 */
		public static void toString(IndexedUnsortedList<Character> list)
		{
			String result = list.toString();
			Assert.assertTrue(String.class.isAssignableFrom(result.getClass()));
		}
				
		//****** Test cases for IndexedList methods ************************************
		/**
		 * Tests add(index) method
		 *  @param list - implementation of IndexedUnsortedList interface
		 * @param index - int value
		 * @param element - Character object
		 */
		public static void add(IndexedUnsortedList<Character> list, int index, Character element)
		{
			list.add(index, element);
		}
		
		/**
		 * Tests remove(index) method
		 *  @param list - implementation of IndexedUnsortedList interface
		 * @param index - int value
		 * @param element - Character object
		 */
		public static void remove(IndexedUnsortedList<Character> list, int index, Character element)
		{
			Character result = list.remove(index);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests set method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param index - int value
		 * @param element - Character object 
		 */
		public static void set(IndexedUnsortedList<Character> list, int index, Character element)
		{
			list.set(index, element);
		}
		
		/**  
	     * Tests add(element) method
	     * @param list - implementation of IndexedUnsortedList interface
	     * @param element - Character object   
	     */
	    public static void add(IndexedUnsortedList<Character> list, Character element)
	    {
	    	list.add(element);
	    }

	    /**
		 * Tests get method
		 *  @param list - implementation of IndexedUnsortedList interface
		 * @param index - int value
		 * @param element - Character object 
		 */
		public static void get(IndexedUnsortedList<Character> list, int index, Character element)
		{
			Character result = list.get(index);
			Assert.assertEquals(result, element);
		}
		
		/**
		 * Tests indexOf method
		 *  @param list - implementation of IndexedUnsortedList interface
		 * @param index - int value
		 * @param element - Character object 
		 */
		public static void indexOf(IndexedUnsortedList<Character> list, int index, Character element)
		{
			int result = list.indexOf(element);
			Assert.assertEquals(result, index);
		}
		
		//****** Test cases for UnsortedList methods ************************************
		/**
		* Tests addToFront method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - Character object 
		 */
		public static void addToFront(IndexedUnsortedList<Character> list, Character element)
		{
			list.addToFront(element);
		}
		
		/**
		 * Tests addToRear method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param element - Character object
		 */
		public static void addToRear(IndexedUnsortedList<Character> list, Character element)
		{
			list.addToRear(element);
		}
		
		/**
		 * Tests addAfter method
		 * @param list - implementation of IndexedUnsortedList interface
		 * @param addElement - Character object
		 * @param element - Character object
		 */
		public static void addAfter(IndexedUnsortedList<Character> list, Character addElement, Character element)
		{		
			list.addAfter(addElement, element);
		}
		
		//****** Test cases for Iterator  ************************************
		/**
		 * Tests iterator method
		 * @param list - implementation of IndexedUnsortedList interface
		 */
		public static void iterator(IndexedUnsortedList<Character> list)
		{
			Assert.assertTrue(Iterator.class.isAssignableFrom(list.iterator().getClass()));
		}
		
		/**
		 * Tests hasNext method
		 * @param itr - Iterator over list implementation of IndexedUnsortedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void hasNext(Iterator<Character> itr, boolean expectedResult)
		{
			boolean result = itr.hasNext();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests next method
		 * @param itr - Iterator over list implementation of IndexedUnsortedList interface
		 * @param element - Character object
		 */
		public static void next(Iterator<Character> itr, Character element)
		{
			Character result = itr.next();
			Assert.assertEquals(result, element);
		}

		/**
		 * Tests remove method
		 * @param itr - Iterator over list implementation of IndexedUnsortedList interface
		 */
		public static void remove(Iterator<Character> itr)
		{
			itr.remove();
		}
		
		//****** Test cases for ListIterator methods ************************************
		/**
		 * Tests listIterator method
		 * @param list - implementation of IndexedUnsortedList interface
		 */
		public static void listIterator(IndexedUnsortedList<Character> list)
		{
			Assert.assertTrue(ListIterator.class.isAssignableFrom(list.listIterator().getClass()));
		}
		
		/**
		 * Tests listIterator method
		 * @param list - implementation of IndexedUnsortedList interface
		 *  @param startIndex - int value 
		 */
		public static void listIterator(IndexedUnsortedList<Character> list, int startIndex)
		{
			Assert.assertTrue(ListIterator.class.isAssignableFrom(list.listIterator(startIndex).getClass()));
		}

		/**
		 * Tests hasPrevious method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param expectedResult - boolean value 
		 */
		public static void hasPrevious(ListIterator<Character> itr, boolean expectedResult)
		{
			boolean result = itr.hasPrevious();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests previous method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param element - Character object 
		 */
		public static void previous(ListIterator<Character> itr, Character element)
		{
			Character result = itr.previous();
			Assert.assertEquals(result, element);
		}

		/**
		 * Tests add method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param element - Character object 
		 */
		public static void add(ListIterator<Character> itr, Character element)
		{
			itr.add(element);
		}
	
		/**
		 * Tests nextIndex method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param expectedResult - int value 
		 */
		public static void nextIndex(ListIterator<Character> itr, int expectedResult)
		{
			int result = itr.nextIndex();
			Assert.assertEquals(result, expectedResult);
		}
	
		/**
		 * Tests previousIndex method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param expectedResult - int value 
		 */
		public static void previousIndex(ListIterator<Character> itr, int expectedResult)
		{
			int result = itr.previousIndex();
			Assert.assertEquals(result, expectedResult);
		}
		
		/**
		 * Tests set method
		 * @param itr - ListIterator over list implementation of IndexedUnsortedList interface
		 * @param element - Character element
		 */
		public static void set(ListIterator<Character> itr, Character element)
		{
			itr.set(element);
		}
		
		//****** Sets up Iterator and ListIterator objects for testing  ************************************
		/**
		 * Sets up Iterator for tests. 
		 * @param itrState - ItrState of Iterator when run tests 
		 */
		public static Iterator<Character> initItr(IndexedUnsortedList<Character> list, ItrState itrState)
		{
			Iterator <Character> itr = list.iterator();
			// choose state of iterator to run tests on 
			switch (itrState) 
			{	
		        case init:  
		        		break;			// just need to initialize iterator 
		        case next:  
		        		itr.next();
		        		break;
		        case nextNext:  
		        		itr.next();
		        		itr.next();
		        		break;
		        case nextRemove:
		        		itr.next();
		        		itr.remove();
		        		break;
		        case nextNextRemove:  
	        			itr.next();
	        			itr.next();
	        			itr.remove();
		        		break;	        
		        case nextRemoveNext:  
		        		itr.next();
		        		itr.remove();
		        		itr.next();
		        		break;
		        case nextNextNext:
						itr.next();
						itr.next();
						itr.next();
						break;
		        case nextNextNextRemove:
						itr.next();
						itr.next();
						itr.next();
						itr.remove();
						break;
		        case nextNextRemoveNext:
						itr.next();
						itr.next();
						itr.remove();
						itr.next();
						break;
		        default:
						System.out.println("Invalid Iterator State");
						break;
			}
			return itr; 
		}
		
		/**
		 * Sets up ListIterator for tests. 
		 * @param listItrState - ListItrState of ListIterator when run tests 
		 */
		public static ListIterator<Character> initListItr(IndexedUnsortedList<Character> list, ListItrState listItrState)
		{
			ListIterator <Character> listItr = list.listIterator();
			// choose state of listIterator to run tests on 
			switch (listItrState) 
			{	
			 
		        case init:  
		        		break;			// just need to initialize listIterator 
		        case add:  
		        		listItr.add(E);
		        		break;
		        case nextAdd:  
		        		listItr.next();
		        		listItr.add(E);
		        		break;
		        case nextPrev:
		        		listItr.next();
		        		listItr.previous();
		        		break;
		        case nextPrevAdd:  
		        		listItr.next();
		        		listItr.previous();
		        		listItr.add(E);
		        		break;
		        case nextPrevRemove:
			        	listItr.next();
			        	listItr.previous();
			        	listItr.remove();
						break;		
		        case nextNextPrev:  
		        		listItr.next();
		        		listItr.next();
		        		listItr.previous();
		        		break;
		        case nextNextAdd:
		        		listItr.next();
		        		listItr.next();
		        		listItr.add(E);
		        		break;
		        case nextNextPrevAdd:  
		        		listItr.next();
		        		listItr.next();
		        		listItr.previous();
		        		listItr.add(E);
		        		break;	   
		        case nextNextPrevRemove:  
		        		listItr.next();
		        		listItr.next();
		        		listItr.previous();
		        		listItr.remove();
		        		break;
		        case nextNextNextPrev:
		        		listItr.next();
			        	listItr.next();
			        	listItr.next();		
			        	listItr.previous();		
			        	break;
		        case nextNextNextAdd:
	        		listItr.next();
		        	listItr.next();
		        	listItr.next();		
		        	listItr.add(E);		
		        	break;
		        case nextNextNextPrevAdd:
			        	listItr.next();
			        	listItr.next();
			        	listItr.next();
			        	listItr.previous();
						listItr.add(E);
						break;
		        case nextNextNextPrevRemove:
			        	listItr.next();
			        	listItr.next();
			        	listItr.next();
			        	listItr.previous();
			        	listItr.remove();
						break;
		        default:
						System.out.println("Invalid List Iterator State");
						break;
			}
			return listItr; 
		}
}
