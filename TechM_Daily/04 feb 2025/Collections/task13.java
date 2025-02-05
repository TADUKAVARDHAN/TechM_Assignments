package Collections;

import java.util.ListIterator;
import java.util.LinkedList;
import java.util.Scanner;

public class task13 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		Scanner haha=new Scanner(System.in);
		System.out.println("Enter the index:");
		int index=haha.nextInt();
		ListIterator<String> it=ha.listIterator(index);
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		haha.close();
		
	}
}
