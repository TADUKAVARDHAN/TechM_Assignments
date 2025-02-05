package techm;

import java.util.Scanner;

public class SmallestVowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase(); 
        
        char smallestVowel = 'z';
        for (char ch : input.toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) { 
                if (ch < smallestVowel) {
                    smallestVowel = ch;
                }
            }
        }
        System.out.print("Smallest vowel: " + smallestVowel);

    }
}
