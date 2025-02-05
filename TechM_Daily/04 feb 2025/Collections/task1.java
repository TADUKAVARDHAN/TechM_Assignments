package Collections;

import java.util.ArrayList;
//import java.util.Iterator;

public class task1 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ha.add("Black");
	ha.add("Blue");
	ha.add("Purple");
	ha.add("Pink");
	System.out.println("Colours in list is: "+ha);
	
	System.out.println("CLOURS:");
	for(String i:ha)
		System.out.println(i);
	
	
	/*Iterator<String> it= ha.iterator();
	while(it.hasNext()) {
		Object elements =it.next();
		System.out.println(elements);
	}*/
	
}
}
