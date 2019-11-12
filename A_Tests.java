import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test to ensure add, remove, and set methods to IndexedUnsortedList 
 * implementation with one element throw no exceptions. 
 * 
 * @author CS 221
 */
public class A_Tests
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	
	/**
	 * Sets up list with one element for testing: 
	 * uses Parameter in XML file to select the dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@Parameters("listType")
	@BeforeMethod
	public void initialize(String listType)
	{
		// create an empty list 
		list = TestCase.newList(listType);
		// add one element to list 
		list.addToRear(TestCase.A);
	}
	
//************************** Tests ***************************************
	/**
	 * Test: removeFirst() on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testRemoveFirst()
	{
		list.removeFirst();
	}
	
	/**
	 * Test: removeLast() on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testRemoveLast()
	{
		list.removeLast();
	}

	/**
	 * Test: remove(A) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testRemove_A()
	{
		list.remove(TestCase.A);
	}

	/**
	 * Test: addToFront(B) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAddToFront_B()
	{
		list.addToFront(TestCase.B);
	}

	/**
	 * Test: addToRear(B) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAddToRear_B()
	{
		list.addToRear(TestCase.B);
	}

	/**
	 * Test: addAfter(B, A) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAddAfter_BA()
	{
		list.addAfter(TestCase.B, TestCase.A);
	}

	/**
	 * Test: remove(0) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testRemove_0()
	{
		list.remove(0);
	}

	/**
	 * Test: set(0, B) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testSet_0B()
	{
		list.set(0, TestCase.B);
	}

	/**
	 * Test: add(0, B) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAdd_0B()
	{
		list.add(0, TestCase.B);
	}

	/**
	 * Test: add(1, B) on list with one element
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAdd_1B()
	{
		list.add(1, TestCase.B);
	}

}
