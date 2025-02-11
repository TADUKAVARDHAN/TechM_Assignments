package Collections;

import java.util.ArrayList;

public class task3 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ha.add("Pink");
	ha.add("Black");
	ha.add("Grey");
	
	for(String num:ha)
		System.out.println(num);
	System.out.println("Updated Values");
	ha.add(0,"White");
	for(String num:ha)
		System.out.println(num);
}
}
