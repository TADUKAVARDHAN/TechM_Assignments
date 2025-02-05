package Collections;
import java.util.ArrayList;
import java.util.Iterator;
public class task2 {
public static void main(String[] args) {
	ArrayList<String> ha=new ArrayList<>();
	ha.add("Dog");
	ha.add("Lion");
	ha.add("Cat");
	System.out.println("List of Animals: ");
	Iterator<String> it=ha.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
}
}
