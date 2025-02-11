package org.bhanu;
import java.util.*;
import java.util.stream.*;
public class REmoveDuplicates {
	public static void main(String arg[]) {
	ArrayList<Integer> a1=new ArrayList<>();
	a1.add(59);
	a1.add(76);
	a1.add(81);
	a1.add(59);
	a1.add(93);
	a1.add(81);
	a1.add(59);
	a1.add(59);
	a1.add(93);
	a1.add(84);
	a1.add(81);
	System.out.println("List is:"+a1);
	List<Integer> l=a1.stream().distinct().collect(Collectors.toList());
	System.out.println("List after removing duplicates is: "+l);
}
}