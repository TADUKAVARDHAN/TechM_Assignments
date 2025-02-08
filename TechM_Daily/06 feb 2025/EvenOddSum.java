package org.bhanu;
import java.util.stream.*;
import java.util.*;
public class EvenOddSum {
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
		int x=a1.stream().filter(s->((s%2)==0)).reduce(0,(acc,num)->acc+num);
		int y=a1.stream().filter(s->((s%2)!=0)).reduce(0,(acc,num)->acc+num);
		System.out.println("Sum of even numbers in the list "+x);
		System.out.println("Sum of odd numbers in the list "+y);		
	}
}
