package Collections;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Comparator;

public class task8 {
	public static void main(String[] args) {
		ArrayList<String> ha=new ArrayList<>();
		ha.add("Lion");
		ha.add("Tiger");
		ha.add("leapord");
		ha.add("Fox");
		ha.add("Zebra");
		System.out.println("Before Sorting:");
		for(String num:ha)
			System.out.println(num);
		
		//ha.sort(Comparator.naturalOrder());
		Collections.sort(ha);
		System.out.println("After sorting:");
		for(String num:ha)
			System.out.println(num);
	}
}
