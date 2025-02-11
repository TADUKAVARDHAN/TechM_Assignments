package Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class task7 {
	public static void main(String[] args) {
		ArrayList<String> ha=new ArrayList<>();
		ha.add("Lion");
		ha.add("Tiger");
		ha.add("leapord");
		ha.add("Fox");
		ha.add("Zebra");
		for(String num:ha)
			System.out.println(num);
		System.out.println("Enter the string which should be searched:");
		Scanner haha=new Scanner(System.in);
		String h=haha.next();
		haha.close();
		System.out.println(ha.contains(h));
		
	}
}
