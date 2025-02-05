package techm;
import java.util.Scanner;
public class characterAtOdd{
	public static void main(String[] arg) {
		Scanner scan=new Scanner(System.in);
		String ch =scan.nextLine();
		for(int i=0;i<ch.length();i++) {
			if(i%2==0) {
				System.out.print(ch.charAt(i));
			}
		}
		
	}

}
