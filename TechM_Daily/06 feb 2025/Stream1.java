package org.bhanu;
import java.util.*;
import java.util.stream.*;
public class Stream1 {
	public static void main(String arg[]) {
		ArrayList<Integer> a1=new ArrayList<>();
		a1.add(5);
		a1.add(10);
		a1.add(7);
		a1.add(54);
		a1.add(65);
		a1.add(7);
		a1.add(86);
		a1.add(879);
		a1.add(97);
		a1.add(6567);
		System.out.println("list before processing"+a1);
		List<Integer> a2=a1.stream().filter(i->((i>=10)&&(i<100))).collect(Collectors.toList());
		System.out.println("List after processing"+a2);
	}
}
