package org.bhanu;
import java.util.*;
import java.util.stream.*;
import java.lang.*;
public class MaxMin {
	public static void main(String arg[]) {
		ArrayList<Integer> a1=new ArrayList<>();
		a1.add(59);
		a1.add(76);
		a1.add(81);
		a1.add(93);
		a1.add(84);
		System.out.println("List of integers is:"+a1);
		int x=a1.stream().reduce(a1.get(0),((acc,num)->Math.max(acc, num)));
		int y=a1.stream().reduce(a1.get(0),((acc,num)->Math.min(acc, num)));
		System.out.println("Maximum of list is: "+x);
		System.out.println("Minimum of list is: "+y);
		System.out.println("Minimum of list is: "+a1.stream().sorted().collect(Collectors.toList()).get(0));
		System.out.println("Maximum of list is: "+a1.stream().sorted().collect(Collectors.toList()).get(a1.size()-1));		
	}
}
