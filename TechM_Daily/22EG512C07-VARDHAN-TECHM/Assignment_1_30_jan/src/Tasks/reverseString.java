package techm;
import java.util.Scanner;
public class reverseString {
public static void main(String[]arg) {
	Scanner sc=new Scanner(System.in);
	String st=sc.nextLine(); 
	String res="";
	for(int i=st.length()-1;i>=0;i--) {
		res+=st.charAt(i);
		
	}
	System.out.println(res);
}
}
