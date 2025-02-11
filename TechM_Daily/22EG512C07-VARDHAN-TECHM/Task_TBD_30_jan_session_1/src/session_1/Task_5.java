package session_1;

import java.util.Scanner;

public class Task_5 {
    public static void main(String a[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s1 = s.next();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (i % 2 == 0) {
                s2.append(Character.toUpperCase(ch));
            } else {
                s2.append(Character.toLowerCase(ch));
            }
        }

        System.out.println("Output: " + s2.toString());
        s.close();
    }
}
