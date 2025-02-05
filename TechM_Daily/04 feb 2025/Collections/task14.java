package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;




public class task14 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		Iterator<String> itt=ha.descendingIterator();
		while(itt.hasNext())
			System.out.println(itt.next());
		
		//OR
		ListIterator<String> it=ha.listIterator(ha.size());
		while(it.hasPrevious()) {
			System.out.println(it.previous());
		}
		
	}
}
