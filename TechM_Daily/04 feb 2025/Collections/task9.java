package Collections;

import java.util.ArrayList;

import java.util.Collections;

public class task9 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ArrayList<String> haha=new ArrayList<>();
	
	ha.add("Lion");
	ha.add("Tiger");
	ha.add("leapord");
	ha.add("Fox");
	ha.add("Zebra");
	haha=new ArrayList<>(Collections.nCopies(ha.size(),""));
	Collections.copy(haha,ha);
	for(String num:haha) {
		System.out.println(num);
	}
}
}
