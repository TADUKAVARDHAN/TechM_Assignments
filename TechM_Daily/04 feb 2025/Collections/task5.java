package Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class task5 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ha.add("Lion");
	ha.add("Tiger");
	ha.add("leapord");
	for(String num:ha)
		System.out.println(num);
	Scanner haha=new Scanner(System.in);
	System.out.println("Enter the String:");
	String original=haha.next();
	int index=ha.indexOf(original);
	System.out.println("Enter the Srting you want to replace to:");
	String replaceto=haha.next();
	ha.set(index, replaceto);
	for(String num:ha)
		System.out.println(num);
	haha.close();
}
}
