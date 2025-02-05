package Collections;

import java.util.ArrayList;
import java.util.Collections;

public class task10 {
	public static void main(String[] args) {
		ArrayList<String> ha=new ArrayList<>();
		ha.add("Lion");
		ha.add("Tiger");
		ha.add("leapord");
		ha.add("Fox");
		ha.add("Zebra");
		System.out.println("Before Shuffling:");
		for(String num:ha)
			System.out.println(num);
		Collections.shuffle(ha);
		System.out.println("After Shuffling:");
		for(String num:ha)
			System.out.println(num);
		
	}
}
