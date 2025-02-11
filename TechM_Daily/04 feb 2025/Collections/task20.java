package Collections;

import java.util.LinkedList;
import java.util.Scanner;

public class task20 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		ha.add("Software Engineering");
		Scanner haha=new Scanner(System.in);
		System.out.println("Enter the element:");
        String elem = haha.nextLine();
        haha.close();
        
        System.out.println("First occurance of the string: "+ha.indexOf(elem));
        System.out.println("Last occurance of the string: "+ha.lastIndexOf(elem));
	}
}
