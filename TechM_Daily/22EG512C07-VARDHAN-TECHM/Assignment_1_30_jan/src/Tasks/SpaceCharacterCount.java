package techm;
import java.util.Scanner;

public class SpaceCharacterCount {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        String st = sc.nextLine();
        int spaceCount = st.length() - st.replace(" ", "").length();
        int characterCount = st.replace(" ", "").length();
        System.out.println("Number of spaces: " + spaceCount +" Number of characters: " + characterCount);
        
        
        sc.close();
    }
}
