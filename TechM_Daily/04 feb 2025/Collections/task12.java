package Collections;

import java.util.Iterator;
import java.util.LinkedList;

public class task12 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Black");
		ha.add("Pink");
		ha.add("Blue");
		System.out.println("Colours:");
		Iterator<String> it=ha.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
