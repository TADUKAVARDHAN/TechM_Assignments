package org.bhanu;
import java.util.*;
import java.util.stream.*;
public class UpperLower {
	public static void main(String arg[]) {
	ArrayList<String> l=new ArrayList<>();
	l.add("red");
	l.add("Green");
	l.add("Yellow");
	l.add("Orange");
	l.add("Violet");
	System.out.println("List of colors is:"+l);
	List<String> s=l.stream().map(String::toUpperCase).collect(Collectors.toList());
	System.out.println("Lint of colors in uppercase is:"+s);
	List<String> s1=l.stream().map(String::toLowerCase).collect(Collectors.toList());
	System.out.println("Lint of colors in lowercase is:"+s1);
	}
}
