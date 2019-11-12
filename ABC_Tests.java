import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test to ensure remove and set methods to IndexedUnsortedList 
 * implementation with three elements throw no exceptions. 
 * 
 * @author CS 221
 */
public class ABC_Tests
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	
	/**
	 * Sets up list with three elements for testing: 
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
		// add third element to list 
		list.addToRear(TestCase.C);
	}
	
//************************** Tests ***************************************
		/**
		 * Test: removeFirst() on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemoveFirst()
		{
			list.removeFirst();
		}
		
		/**
		 * Test: removeLast() on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemoveLast()
		{
			list.removeLast();
		}

		/**
		 * Test: remove(A) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_A()
		{
			list.remove(TestCase.A);
		}
		
		/**
		 * Test: remove(B) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_B()
		{
			list.remove(TestCase.B);
		}
		
		/**
		 * Test: remove(C) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_C()
		{
			list.remove(TestCase.C);
		}
		
		/**
		 * Test: remove(0) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_0()
		{
			list.remove(0);
		}
		
		/**
		 * Test: remove(1) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_1()
		{
			list.remove(1);
		}
		
		/**
		 * Test: remove(2) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testRemove_2()
		{
			list.remove(2);
		}
		
		/**
		 * Test: set(0 , D) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testSet_0D()
		{
			list.set(0, TestCase.D);
		}
		
		/**
		 * Test: set(1 , D) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testSet_1D()
		{
			list.set(0, TestCase.D);
		}
		
		/**
		 * Test: set(2 , D) on list with three elements
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testSet_2D()
		{
			list.set(0, TestCase.D);
		}
		
}
