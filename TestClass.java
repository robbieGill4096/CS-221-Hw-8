import java.util.Iterator;

public class TestClass {
	public static final Character A = new Character('A');

	public static final Character B = new Character('B');

	public static final Character C = new Character('C');
	public static final Character D = new Character('D');

	public static final Character Z = new Character('Z');

	

	public static <T> void main(String[] args) {

		IUSingleLinkedList<T> sl = new IUSingleLinkedList<T>();

		sl.add((T)A);
		sl.addAfter((T)Z, (T)A);
		sl.last();
		//sl.add((T)B);
		//sl.add((T)C);
		

		//sl.add((T)C);

		//sl.addAfterExperimental((T)Z, (T)A);
		Iterator<T> slReader = sl.iterator();
		System.out.println(slReader.next());
		System.out.println(slReader.next());
		System.out.println(sl.last());
	}


}
