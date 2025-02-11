package techm;
import java.util.Scanner;
public class LastCharacterAtEveryWord {
	public static void main(String[] arg) {
		Scanner scan=new Scanner(System.in);
		String ch=scan.nextLine();
		for(int i=1;i<ch.length();i++) {
			if((ch.charAt(i))==' ' ) {
				System.out.print(ch.charAt(i-1));
				
			}
			
		}
		System.out.println(ch.charAt(ch.length()-1));
	}
	

}
