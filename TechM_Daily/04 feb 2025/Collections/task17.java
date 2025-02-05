package Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class task17 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		Scanner haha=new Scanner(System.in);
		System.out.println("Enter the element that should be added at start:");
		String pos=haha.next();
		ha.addFirst(pos);
		haha.close();
		Iterator<String> it=ha.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
