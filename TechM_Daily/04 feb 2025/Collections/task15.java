package Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class task15 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		System.out.println("Enter the index:");
		Scanner haha=new Scanner(System.in);
		int index=haha.nextInt();
		System.out.println("Enter the element:");
		String pos=haha.next();
		ha.add(index, pos);
		haha.close();
		
		Iterator<String> it=ha.iterator();
		while(it.hasNext())
			System.out.println(it.next());
	}
}
