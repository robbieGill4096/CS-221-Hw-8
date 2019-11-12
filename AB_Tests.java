import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test to ensure add, remove, and set methods to IndexedUnsortedList 
 * implementation with two elements throw no exceptions. 
 * 
 * @author CS 221
 */
public class AB_Tests
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	
	/**
	 * Sets up list with two elements for testing: 
	 * uses Parameter in XML file to select the dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@Parameters("listType")
	@BeforeMethod
	public void initialize(String listType)
	{
		// create an empty list 
		list = TestCase.newList(listType);
		// add first element to list 
		list.addToRear(TestCase.A);
		// add second element to list 
		list.addToRear(TestCase.B);
	}
	
//************************** Tests ***************************************
		/**
		 * Test: removeFirst() on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemoveFirst()
		{
			list.removeFirst();
		}
		
		/**
		 * Test: removeLast() on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemoveLast()
		{
			list.removeLast();
		}
		
		/**
		 * Test: remove(A) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_A()
		{
			list.remove(TestCase.A);
		}
		
		/**
		 * Test: remove(B) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_B()
		{
			list.remove(TestCase.B);
		}
		
		/**
		 * Test: addToFront(C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAddToFront_C()
		{
			list.addToFront(TestCase.C);
		}
		
		/**
		 * Test: addToRear(C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAddToRear_C()
		{
			list.addToRear(TestCase.C);
		}
		
		/**
		 * Test: addAfter(C, A) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAddAfter_CA()
		{
			list.addAfter(TestCase.C, TestCase.A);
		}
		
		/**
		 * Test: addAfter(C, B) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAddAfter_CB()
		{
			list.addAfter(TestCase.C, TestCase.B);
		}
		
		/**
		 * Test: remove(0) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_0()
		{
			list.remove(0);
		}
		
		/**
		 * Test: remove(1) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_1()
		{
			list.remove(1);
		}
		
		/**
		 * Test: set(0 , C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testSet_0C()
		{
			list.set(0, TestCase.C);
		}
		
		/**
		 * Test: set(1, C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testSet_1C()
		{
			list.set(1, TestCase.C);
		}
		
		/**
		 * Test: add(C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAdd_C()
		{
			list.add(TestCase.C);
		}
		
		/**
		 * Test: add(0, C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAdd_0C()
		{
			list.add(0, TestCase.C);
		}
		
		/**
		 * Test: add(1, C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAdd_1C()
		{
			list.add(1, TestCase.C);
		}
		
		/**
		 * Test: add(2, C) on list with two elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testAdd_2C()
		{
			list.add(2, TestCase.C);
		}
		
	
}
