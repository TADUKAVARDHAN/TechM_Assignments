package techm;
import java.util.Scanner;
public class uniqueCharacters {
public static void main(String[] arg) {
Scanner sc=new Scanner(System.in);
String ch=sc.nextLine();
String result="";
for(int i=0;i<ch.length();i++) {
	if(result.indexOf(ch.charAt(i))<0) {
		result+=ch.charAt(i);
	}
	
}
System.out.print(result);
}
}
