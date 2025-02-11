package Collections;

import java.util.ArrayList;
import java.util.Scanner;


public class task6 {
	public static void main(String[] args) {
		ArrayList<String> ha=new ArrayList<>();
		ha.add("Lion");
		ha.add("Tiger");
		ha.add("leapord");
		ha.add("Fox");
		ha.add("Zebra");
		for(String num:ha)
			System.out.println(num);
		Scanner haha=new Scanner(System.in);
		System.out.println("Enter the index which you want to remove:");
		int h=haha.nextInt();
		ha.remove(h);
		haha.close();
		for(String num:ha)
			System.out.println(num);
	}
}
