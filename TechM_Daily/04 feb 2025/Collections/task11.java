package Collections;

import java.util.LinkedList;

public class task11 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Black");
		ha.add("Pink");
		ha.add("Blue");
		
		System.out.println("Original List: "+ha);
		ha.add("Purple");
		System.out.println("Updated List: "+ha);
		
	}

}
