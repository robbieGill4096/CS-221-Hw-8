import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test to ensure add methods to empty IndexedUnsortedList 
 * implementation throw no exceptions. 
 * 
 * @author CS 221
 */
public class EmptyListTests
{
	// List running tests on
	IndexedUnsortedList<Character> list;
	
	/**
	 * Sets up empty list for testing: 
	 * uses Parameter in XML file to select the dynamic type of the list. 
	 * @param listType - String representing the dynamic type of the list. 
	 */
	@Parameters("listType")
	@BeforeMethod
	public void initialize(String listType)
	{
		// create an empty list
		list = TestCase.newList(listType);
	}

//************************** Tests ***************************************
	/**
	 * Test: addToFront(A) on empty list
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAddToFront_A()
	{
		list.addToFront(TestCase.A);
	}

	/**
	 * Test: addToRear(A) on empty list
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAddToRear_A()
	{
		list.addToRear(TestCase.A);
	}

	/**
	 * Test: add(A) on empty list
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAdd_A()
	{
		list.add(TestCase.A);
	}

	/**
	 * Test: add(0, A) on empty list
	 * Expected Result: No exceptions
	 */
	@Parameters("listType")
	@Test()
	public void testAdd_0A()
	{
		list.add(0, TestCase.A);
	}

}
