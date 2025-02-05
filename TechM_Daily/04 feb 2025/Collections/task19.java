package Collections;

import java.util.LinkedList;
import java.util.Scanner;

public class task19 {
	public static void main(String[] args) {
		LinkedList<String> ha=new LinkedList<>();
		ha.add("Operating Systems");
		ha.add("Software Engineering");
		ha.add("Java");
		ha.add("Python");
		Scanner haha=new Scanner(System.in);
		System.out.println("Enter the element to insert:");
        String newElement = haha.nextLine();
		
		System.out.println("Enter the position where you want to insert:");
        int position = haha.nextInt();
        if (position < 0 || position > ha.size()) {
            System.out.println("Invalid index! Please enter a valid index between 0 and " + ha.size());
        } else {
            ha.add(position, newElement);
            System.out.println("\nUpdated LinkedList: " + ha);
        }
        haha.close();
	}
}
