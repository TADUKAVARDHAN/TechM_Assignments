package techm;
import java.util.Scanner;
public class reverseNumber {
public static void main(String[] arg) {
	Scanner scan=new Scanner(System.in);
	int number=scan.nextInt();
	int reverse=0;
	while(number!=0) {
		int rev=number%10;
		reverse=reverse*10+rev;
		number=number/10;
		
	}
	System.out.println(reverse);
}

}
