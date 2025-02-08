package org.bhanu;
import java.util.*;
import java.util.stream.*;
public class Average {
	public static void main(String arg[]) {
		ArrayList<Integer> a1=new ArrayList<>();
		a1.add(59);
		a1.add(76);
		a1.add(81);
		a1.add(93);
		a1.add(84);
		System.out.println("List of integers is:"+a1);
		float f=a1.stream().map(Integer::floatValue).reduce(0f,(acc,num)->acc+(num/a1.size()));
		System.out.printf("%.2f",f);
	}
}
