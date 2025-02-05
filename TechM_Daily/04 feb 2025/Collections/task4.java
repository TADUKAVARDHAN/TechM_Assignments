package Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class task4 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ha.add("Lion");
	ha.add("Tiger");
	ha.add("leapord");
	Scanner haha=new Scanner(System.in);
	System.out.println("Enter the index:");
	int h=haha.nextInt();
	if(h>=0 && h<=ha.size())
	System.out.println("Element at given index is: "+ha.get(h));
	else
		System.out.println("Invalid index");
	haha.close();
	
}
}
