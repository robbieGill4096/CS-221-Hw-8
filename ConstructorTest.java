import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test to ensure constructor for IndexedUnsortedList 
 * implementation throws no exceptions. 
 * 
 * @author CS 221
 */
public class ConstructorTest
{
		// List running test on
		IndexedUnsortedList<Character> list;
		
//************************** Test ***************************************
		/**
		 * Test: new list - construct empty list
		 * Expected Result: No exceptions
		 */
		@Parameters("listType")
		@Test()
		public void testConstructor(String listType)
		{
			// create an empty list 
			list = TestCase.newList(listType);
		}
		
}
